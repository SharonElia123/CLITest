package Test;
import OsClasses.Ls;
import OsOperation.QueryRunner;
import SystemUtilityOpertion.AddDirectoryAndFolder;
import org.testng.annotations.*;
import Log.Log;
import static OsOperation.QueryRunner.VerifyTestOrUser;
import java.util.ArrayList;
import java.util.List;

public class TestCd {
    static String inputNameDir="TestCd";
    static String inputNameFile="TestCd.txt";
    static Ls dd=new Ls();
    static List<String> list=new ArrayList<String>();
    static AddDirectoryAndFolder closeCli= new AddDirectoryAndFolder();
    @BeforeTest
    public void launchCli() {
        QueryRunner querycli = new QueryRunner();
        Log.startTestCase("LunchCli");
    }

    @Test(priority = 0)
    public static void lsTestCdFile() throws Exception {
        VerifyTestOrUser("Test","touch "+inputNameFile+"");
        VerifyTestOrUser("Test","cd "+inputNameFile+"");
        VerifyTestOrUser("Test","cd ..");
        VerifyTestOrUser("Test","ls");
        list=dd.testLs();
        if (list.contains(inputNameFile)) {
            assert true;
        } else {
            assert false;
        } }
    @Test(priority = 1)
    public static void lsTestCd() throws Exception {
        VerifyTestOrUser("Test", "mkdir " + inputNameDir + "");
        VerifyTestOrUser("Test", "cd " + inputNameDir + "");
            }
    @AfterTest
    public void CloseCli(){
        Log.endTestCase("CloseCli And complete the Test");
        closeCli.killProcess();

    }
}