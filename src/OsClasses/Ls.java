package OsClasses;
import OsOperation.OsOperationAbstract;
import SystemUtilityOpertion.DirectoryInit;
import SystemUtilityOpertion.FileInitialization;
import SystemUtilityOpertion.CreateListAndTree;
import SystemUtilityOpertion.AddDirectoryAndFolder;
import Log.Log;
import java.util.ArrayList;
import java.util.List;
/*
  The command lc changes to directory passed as an argument. ls
 */
public class Ls extends OsOperationAbstract {
    AddDirectoryAndFolder directoryTree;
    static List<String> list=new ArrayList<String>();
    @Override
    public void executeQuery() {
        try {
            Log.info("Start Ls command");
            this.run();
        } catch (Exception ex) {
            System.out.println("Pleas, write correct ls or there is not found the files");
        }

    }

    public void run () {
        listOn(AddDirectoryAndFolder.getCurrent());
        Log.info("Get the results(Dirs/Files");

    }
    // Listing both directories and files
    public void listOn(DirectoryInit targetDirectory) {
            for (FileInitialization file : CreateListAndTree.getFilesOf(targetDirectory)) {
            list.add(file.getName());
            if (!(file.getName().contains("Test"))){
                System.out.println(file.getName());
            }}}
    //Use for test, hold the list of files/ Dirs
    public List<String> testLs () {
            return list;
                }

            }





