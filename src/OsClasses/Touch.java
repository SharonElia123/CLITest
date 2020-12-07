package OsClasses;
import OsOperation.OsOperationAbstract;
import SystemUtilityOpertion.DirectoryInit;
import SystemUtilityOpertion.CreateListAndTree;
import SystemUtilityOpertion.AddDirectoryAndFolder;
import Log.Log;
/*
  The command Touch changes to directory passed as an argument. touch file.png
 */
public class Touch extends OsOperationAbstract {

    private Object Exception;

    @Override
    public void executeQuery () throws Exception {
        Log.info("Start make files");
        if (! this.run()) {
            System.out.println("File already exist");
        }
    }

    private DirectoryInit getParentDirectory() {
        String pathFile = getSystemParams();
        return AddDirectoryAndFolder.getCurrent();
    }
   //Methods to create files, verify user write the correct format
    private String getDirectoryTarget() throws Exception {
        Log.info("Creating files");
        String file = getSystemParams();
        if ((file.contains("."))){
            System.out.println("Great! you create a file");
            return file;
        }
         else{
            System.out.println("Create file with the correct format");
            throw new Exception();
        }

    }
   //Creating a new file
    public boolean run () throws Exception {
        String directoryTarget = getDirectoryTarget();
        DirectoryInit parentDirectory = getParentDirectory();
        DirectoryInit newFile = new DirectoryInit(directoryTarget, parentDirectory);
        return CreateListAndTree.addDirectory(newFile);
    }

}