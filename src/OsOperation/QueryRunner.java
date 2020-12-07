package OsOperation;
import SystemUtilityOpertion.DirectoryInit;
import SystemUtilityOpertion.AddDirectoryAndFolder;
import Test.TestLs;
import java.util.Scanner;
import Log.Log;
/*This is the main class:
* from this class, user or Test can run the cli simulation
* User or Test should decide which command to run: 1. mkdir 2. cd 3. ls 4. touch
* * */
public class QueryRunner {
    static Scanner  sc = new Scanner(System.in);
    static String inputSelected;
    static TestLs testCli = new TestLs();
    // Create Directory Tree
    public QueryRunner() {
      AddDirectoryAndFolder.createDirectoryTree(new DirectoryInit());
    }
    /*Verify the system from the main class
    1. for example for mkdir should write "mkdir Test"
    2. for cd you can use command "cd .." or "cd Test"
    3. In addition, for ls you can use "ls"
    4. also, to make file use the command touch, "touch Test.png"
     */
    public static void main(String[] args) throws Exception {
        Log.startTestCase("LunchCli with User command");
        QueryRunner command = new QueryRunner();
        String caseSelected = "User";
        while (true){
            System.out.print("please write your query ");
            inputSelected = sc.nextLine();
            VerifyTestOrUser(caseSelected,inputSelected);
        }
    }
    //Method that selected which user run the process
    public static void VerifyTestOrUser(String caseSelected,String inputSelected) throws Exception {
        if (caseSelected == "User") {
            LaunchCli(inputSelected);
        }
        else if (caseSelected == "Test") {
            LaunchCli(inputSelected);

             }
    }
    // this method send the inputSelected to the OsCommand and execute the cli
    public  static void  LaunchCli(String inputSelected) throws Exception {
               Log.info("launch the process");
                try {
                    OSCommand in = new OSCommand(inputSelected);
                    in.getOsOpertion().executeQuery();
                } catch (Exception e) {
                    throw new Exception("please write correct Command Operation");

                }
            }
        }




