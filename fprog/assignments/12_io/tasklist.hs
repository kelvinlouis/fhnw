main :: IO ()
main = do
  cmd <- getLine
  doCommand cmd
  main

type Task = (Bool, String)
type TaskList = [Task]

filePath :: String
filePath = "tasks.txt"

doCommand :: String -> IO ()
doCommand line | cmd == "list" = listTasks
               | cmd == "add" = addTaskToList argument
               | cmd == "done" = completeTask (read argument :: Int)
               | otherwise = putStrLn "incorrect command: list | add description | done task#"
               where parts = words line
                     cmd = head parts
                     argument = (unwords . tail) parts

listTasks :: IO ()
listTasks = do 
  list <- readTasks
  putStrLn $ show $ numberTasks list

addTaskToList :: String -> IO ()
addTaskToList desc = do
  list <- readTasks
  let newList = addTask desc list
  writeTasks newList

completeTask :: Int -> IO ()
completeTask num = do
  list <- readTasks
  let newList = markDone num list
  writeTasks newList

readTasks :: IO TaskList
readTasks = do 
  content <- readFile filePath                
  let list = if null content then [] else (read content)                
  length list `seq` return list 

writeTasks :: TaskList -> IO ()
writeTasks list = do
  writeFile filePath (show list)

addTask :: String -> TaskList -> TaskList
addTask "" _ = error "Task has to contain text"
addTask task list = list ++ [(False, task)]

numberTasks :: TaskList -> [(Int, Task)]
numberTasks = foldl (\acc l -> acc ++ [(length acc, l)] ) []

markDone :: Int -> TaskList -> TaskList
markDone pos = let mark acc task | num == pos = acc ++ [(True, title)]
                                 | otherwise = acc ++ [task]
                                 where num = length acc
                                       title = snd task
               in foldl mark []