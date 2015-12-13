import Network.HTTP
import System.Environment
import Control.Monad
--import Data.Aeson -- cabal install aeson

main :: IO ()
main = do
  args <- getArgs
  if length args == 0
    then forever askForMovie
    else do
      let name = head args
      body <- getMovieInfo name
      putStrLn $ formatJSON body
      forever askForMovie

askForMovie :: IO ()
askForMovie = do
  putStrLn "enter name of movie: "
  name <- getLine
  body <- getMovieInfo name
  putStrLn $ formatJSON body

getMovieInfo :: String -> IO String
getMovieInfo name = do
  let url = "http://www.omdbapi.com/?t=" ++ name
  response <- (simpleHTTP . getRequest) url
  getResponseBody response

-- not very good formatter ;)
formatJSON :: String -> String
formatJSON x = concat $ map addNewLine x
             where addNewLine c | c == '{' = "{ \n"
                                | c == '}' = "\n }"
                                | c == ',' = ",\n"
                                | otherwise = [c]

--askForMovieM :: (Maybe String) -> IO ()
--askForMovieM Nothing = do putStrLn "enter name of movie: "
--                          name <- getLine
--                          askForMovieM (Just name)
--askForMovieM (Just name) = do body <- getMovieInfo name
--                              putStrLn body