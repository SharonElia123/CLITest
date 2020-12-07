package Test;

import Log.Log;
import OsClasses.Ls;
import OsOperation.QueryRunner;
import SystemUtilityOpertion.AddDirectoryAndFolder;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static OsOperation.QueryRunner.VerifyTestOrUser;

@Test
public class TestTouch {

    static String inputNameFile="TestTouch.xml";
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
        VerifyTestOrUser("Test","touch "+inputNameFile+"");
        VerifyTestOrUser("Test","cd "+inputNameFile+"");
        VerifyTestOrUser("Test","cd ..");
        VerifyTestOrUser("Test","ls");
        list=dd.testLs();
        System.out.print(list);
        if (list.contains(inputNameFile)) {
            assert true;
        } else {
            assert false;
        }
    }
    @Test(priority = 1)
    public static void VerifySeveralDirs() throws Exception {
        for(int i=2;i<=20;i++){
            VerifyTestOrUser("Test","touch Test"+i+".png");

        }
        VerifyTestOrUser("Test","ls");}
    @AfterTest
    public void CloseCli(){
        Log.endTestCase("CloseCli And complete the Test");
        closeCli.killProcess();

    }
}