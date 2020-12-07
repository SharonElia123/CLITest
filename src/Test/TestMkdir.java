package Test;
import OsClasses.Ls;
import OsOperation.QueryRunner;
import org.testng.annotations.*;
import Log.Log;
import static OsOperation.QueryRunner.VerifyTestOrUser;
import java.util.ArrayList;
import java.util.List;
import SystemUtilityOpertion.AddDirectoryAndFolder;
@Test
public class TestMkdir {

    static String inputNameDir="TestMkdir";
    static String inputNameDir1="TestMkdir1";
    static Ls dd=new Ls();
    static List<String> list=new ArrayList<String>();
    Ls ls = new Ls();
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
    public static void lsVerify1CdCommand() throws Exception {
        VerifyTestOrUser("Test","mkdir "+inputNameDir1+"");
        VerifyTestOrUser("Test","cd "+inputNameDir1+"");
        //VerifyTestOrUser("Test","Cd ..");
    }
    @Test(priority = 1)
    public static void VerifySeveralDirs() throws Exception {
        for(int i=2;i<=20;i++){
        VerifyTestOrUser("Test","mkdir Test"+i+"");

    }
    VerifyTestOrUser("Test","ls");}
    @AfterTest
    public void CloseCli(){
        Log.endTestCase("CloseCli And complete the Test");
        closeCli.killProcess();

    }
}