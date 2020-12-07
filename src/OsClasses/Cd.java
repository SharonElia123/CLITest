package OsClasses;

import SystemUtilityOpertion.AddDirectoryAndFolder;
import OsOperation.OsOperationAbstract;
import Log.Log;
/*
  The command cd changes to directory passed as an argument. cd.. or cd dir
 */
public class Cd extends OsOperationAbstract {

     public boolean run () throws Exception {
        Log.info("run cd command");
        return AddDirectoryAndFolder.setPath(getSystemParams());
    }
    @Override
    public void executeQuery () {
        try {
            if (!this.run()) {
                System.out.println("Directory couldn't be found or doesn't exist");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}

