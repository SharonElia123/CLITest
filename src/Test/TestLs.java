package Test;
import OsClasses.Ls;
import OsOperation.QueryRunner;
import SystemUtilityOpertion.AddDirectoryAndFolder;
import org.testng.annotations.*;
import Log.Log;
import static OsOperation.QueryRunner.VerifyTestOrUser;
import static org.testng.AssertJUnit.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class TestLs {
    static String inputNameDir="TestLs";
    static String inputNameFile="Testls.png";
    static Ls dd=new Ls();
    static List<String> list=new ArrayList<String>();
    static AddDirectoryAndFolder closeCli= new AddDirectoryAndFolder();
    @BeforeTest
    public void launchCli() {
        QueryRunner querycli = new QueryRunner();
        Log.startTestCase("LunchCli");
    }
    @Test(priority = 0)
    public static void lsVerify1Dir() throws Exception {
        VerifyTestOrUser("Test","mkdir "+inputNameDir+"");
        VerifyTestOrUser("Test","ls");
        list=dd.testLs();
        System.out.print(list);
        if (list.contains(inputNameDir)) {
            assert true;
        } else {
            assert false;
        }
    }

    @Test(priority = 1)
    public static void lsTestCreatFile() throws Exception {

        VerifyTestOrUser("Test","touch "+inputNameFile+"");
        VerifyTestOrUser("Test","ls");
        list=dd.testLs();
        System.out.print(list);
        if (list.contains(inputNameFile)) {
            assert true;
        } else {
            assert false;
        } }
    @AfterTest
    public void CloseCli(){
        Log.endTestCase("CloseCli And complete the Test");
        closeCli.killProcess();

    }

}