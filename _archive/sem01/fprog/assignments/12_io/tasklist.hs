import System.Exit

main :: IO ()
main = do
  cmd <- getLine
  doCommand $ words cmd
  main

type Task = (Bool, String)
type TaskList = [Task]

filePath :: String
filePath = "tasks.txt"

doCommand :: [String] -> IO ()
doCommand (cmd:args)  | cmd == "list" = listTasks
                      | cmd == "add" = addTaskToList argument
                      | cmd == "done" = completeTask (read argument :: Int)
                      | cmd == "remove" = removeTaskFromList (read argument :: Int)
                      | cmd == "help" = putStrLn "commands: list | add description | done task# | remove task#"
                      | cmd == "quit" = exitSuccess
                      where argument = unwords args
doCommand _ = return()

listTasks :: IO ()
listTasks = do 
  list <- readTasks
  putStrLn $ show $ numberTasks list

modifyTasks :: (TaskList -> TaskList) -> IO ()
modifyTasks f = do
  list <- readTasks
  writeTasks $ f list

addTaskToList :: String -> IO ()
addTaskToList desc = modifyTasks $ addTask desc

completeTask :: Int -> IO ()
completeTask num = modifyTasks $ markDone num

removeTaskFromList :: Int -> IO ()
removeTaskFromList num = modifyTasks $ removeTask num

readTasks :: IO TaskList
readTasks = do 
  content <- readFile filePath                
  let list = if null content then [] else (read content)                
  length list `seq` return list 

writeTasks :: TaskList -> IO ()
writeTasks list = writeFile filePath (show list)

addTask :: String -> TaskList -> TaskList
addTask "" _ = error "Task has to contain text"
addTask task list = list ++ [(False, task)]

removeTask :: Int -> TaskList -> TaskList
removeTask nr tasks = take nr tasks ++ drop (nr+1) tasks 

numberTasks :: TaskList -> [(Int, Task)]
numberTasks = zip [0..]
--numberTasks = foldl (\acc l -> acc ++ [(length acc, l)] ) []

markDone :: Int -> TaskList -> TaskList
markDone pos = let mark acc task | num == pos = acc ++ [(True, title)]
                                 | otherwise = acc ++ [task]
                                 where num = length acc
                                       title = snd task
               in foldl mark []
