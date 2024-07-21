 # CliSimulationComand
Cli simulation with 4 command (touch,mkdir,cd, and ls)
-------------------------------------------------------
To do the mission created  5 Directories.
1. OsOperation- Excuting the query. there is 4 command
  1.1 mkdir- create directories with command--> "mkdir directoryName"
  1.2 ls- Dispaly the Directories or file in the path with command --> "ls"
  1.3 cd- change the directories path with command --> "cd directoryName" or "cd .."
  1.4 touch- create files with command --> "touch fileName"
2. for this directory there is 3 classes: 
  2.1 QueryRunner- Excute the user command or Test command
  2.2 OsOperationAbstractclass-  this class created several methods, like capitalize, extract command and extractParameters.
  2.3 OSCommand- class that Initializing the parameters and send to the relevant class for the process
3. all the three classes help us to run the query and send the relevant command to the adjust class. (Cd/ LS/ Touch/ Mkdir).
4. OsClass- in this directory we have the command classes
  4.1 Cd- The command cd changes to directory passed as an argument. cd.. or cd dir 
  4.2 Ls- The command lc changes to directory passed as an argument. ls
  4.3 Mkdir-The command mkdir changes to directory passed as an argument. mkdir dirName
  4.4 Touch- The command Touch changes to directory passed as an argument. touch file.png
5. SystemUtilityOpertion- utilty that help us to create the files/ Directories and keep them in the list
  5.1 AddDirectoryAndFolder- Adding the Files/ Directory to the tree
  5.2 CreateListAndTree- Class created to handle the tree with directory list
  5.3 DirectoryInit-Class for initialization the directories 
  5.4 FileInitialization- initialization the files/ Dirs
6. Test- Unit test of the code, help us to make a sanity test for our code
  6.1 TestLs- testing the ls command
  6.2 TestMkdir- testing the mkdir command
  6.3 TestCd- testing the cd command
  6.4 TestTouch- testing the touch command
  note- for that our system using TestNg 
7. Log- Send us logs about the flow
8. Exceptions- there is severla exception that our system throw.
---------------------------------------
Example:
User:
please write your query mkdir Table
Great! you create a Directory
please write your query mkdir Computer
Great! you create a Directory
please write your query touch Computer.xml
Great! you create a file
please write your query ls
Table
Computer
Computer.xml
please write your query 
--------------------------------
Test:
===============================================
Sample test Suite
Total tests run: 9, Failures: 0, Skips: 0
===============================================

Logs:

2020-12-07 10:27:04,063 INFO  [Log] ***************************************************************************************** 
 2020-12-07 10:27:04,063 INFO  [Log] ***********************                 LunchCli       ********************************* 
 2020-12-07 10:27:04,063 INFO  [Log] **************************************************************************************** 
 2020-12-07 10:27:04,094 INFO  [Log] launch the process 
 2020-12-07 10:27:04,094 INFO  [Log] return parameter 
 2020-12-07 10:27:04,094 INFO  [Log] send the command to relevant class 
 2020-12-07 10:27:04,094 INFO  [Log] Start make files 
 2020-12-07 10:27:04,094 INFO  [Log] Creating files 
 2020-12-07 10:27:04,094 INFO  [Log] launch the process 
 2020-12-07 10:27:04,094 INFO  [Log] return parameter 
 2020-12-07 10:27:04,094 INFO  [Log] send the command to relevant class 
 2020-12-07 10:27:04,094 INFO  [Log] run cd command    
 2020-12-07 10:27:04,095 INFO  [Log] ****************            CloseCli And complete the Test             *****************  
 
 
