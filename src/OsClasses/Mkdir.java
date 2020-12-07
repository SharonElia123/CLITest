package OsClasses;

import SystemUtilityOpertion.CreateListAndTree;
import OsOperation.OsOperationAbstract;
import SystemUtilityOpertion.DirectoryInit;
import SystemUtilityOpertion.AddDirectoryAndFolder;
import Log.Log;
/*
  The command mkdir changes to directory passed as an argument. mkdir table
 */
public class Mkdir extends OsOperationAbstract {

    @Override
    public void executeQuery () throws Exception {
        Log.info("start the mkdir");
        if (! this.run()) {
            System.out.println("Directory already exist");
        }
    }

    private DirectoryInit getParentDirectory() {
        String path = getSystemParams();
        if (path.lastIndexOf("/") > -1) {
            path = path.substring(0, path.lastIndexOf("/"));
            return AddDirectoryAndFolder.getDirectory(path);
        }

        return AddDirectoryAndFolder.getCurrent();
    }
    //Methods to create dirs, verify user write the correct format
    private String getDirectoryTarget() throws Exception {
        Log.info("Creating dirs");
        String path = getSystemParams();
        if (!(path.contains("."))){
            System.out.println("Great! you create a Directory");
            return path;
        }
        else{
            System.out.println("Create Directory with the correct format");
            throw new Exception();
        }
    }
    //Creating a new directory
    public boolean run () throws Exception {
        String directoryTarget = getDirectoryTarget();
        DirectoryInit parentDirectory = getParentDirectory();
        DirectoryInit newdir = new DirectoryInit(directoryTarget, parentDirectory);
        return CreateListAndTree.addDirectory(newdir);

    }



}

