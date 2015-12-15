module Tasks.Core
(addTask
,removeTask
,numberTasks
,markDone
) where

type Task = (Bool, String)
type TaskList = [Task]

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
