package SystemUtilityOpertion;
import java.util.ArrayList;
//Adding the Files/ Directory to the tree
public class AddDirectoryAndFolder {

    private static ArrayList<DirectoryInit> tree = new ArrayList<>();
    private static AddDirectoryAndFolder self;
    private static DirectoryInit current;
    private static DirectoryInit root;
    private static DirectoryInit virtualCurrent;
    private CreateListAndTree fileTree;
    //Constructor the tree
    public AddDirectoryAndFolder(DirectoryInit root) {
        AddDirectoryAndFolder.current = root;
        AddDirectoryAndFolder.virtualCurrent = root;
        AddDirectoryAndFolder.root = root;
        //adding root folder to the directory tree
        fileTree = CreateListAndTree.create(root);
      // DirectoryTree.add(root);
    }

    public AddDirectoryAndFolder() {

    }
    //Creating the Directory Tree
    public static AddDirectoryAndFolder createDirectoryTree (DirectoryInit root) {
        if (! (self instanceof AddDirectoryAndFolder)) {
            self = new AddDirectoryAndFolder(root);
        }

        return self;
    }

    //methods to verify if (tree.contains(directory))
    public static void setCurrent(DirectoryInit directory) {
        {
        virtualCurrent = directory;
        current = directory;
        }
    }

    public static DirectoryInit getCurrent() {
        return AddDirectoryAndFolder.current;
    }

    public static void setVirtualCurrent(DirectoryInit directory) {
        virtualCurrent = directory;
    }

    public static DirectoryInit getVirtualCurrent() {
        return AddDirectoryAndFolder.virtualCurrent;
    }

    public static ArrayList<DirectoryInit> getFoldersOn(DirectoryInit target) {
        ArrayList<DirectoryInit> directories = new ArrayList<>();
        for (DirectoryInit directory : tree) {
            if (directory.getParent() == target) {
                directories.add(directory);
            }
        }

        return directories;
    }
    //List of the folders
    public static ArrayList<DirectoryInit> getFoldersOnCurrent() {
        return getFoldersOn(current);
    }
    //Found the name of the Directory
    public static DirectoryInit findDirOn(DirectoryInit current, String directoryName) {
        for (FileInitialization d : CreateListAndTree.getFilesOf(current)) {
            if (d.getName().equals(directoryName)) {
                return (DirectoryInit) d;
            }
        }
        return null;
    }

    /*
      Setting path to current if exists

     */
    public static boolean setPath(String path) {
        DirectoryInit directory = AddDirectoryAndFolder.getDirectory(path);

        if (directory != null) {
            AddDirectoryAndFolder.setCurrent(directory);

            return true;
        }

        return false;
    }

    /*
      Getting directory of path
     */
    public static DirectoryInit getDirectory(String path) {

        if (path.charAt(0) == '/') {
            AddDirectoryAndFolder.setVirtualCurrent(root);
            path = path.substring(1);
        }

        String[] directories = path.split("/");

        for (String directory : directories) {
            DirectoryInit virtual = AddDirectoryAndFolder.getVirtualCurrent();
            DirectoryInit parent = virtual.getParent();

            if (directory.equals("..")) {

                if (parent == null) {
                    AddDirectoryAndFolder.setVirtualCurrent(AddDirectoryAndFolder.getCurrent());
                    return null;
                }

                AddDirectoryAndFolder.setVirtualCurrent(parent);
            } else {
                DirectoryInit currentDirectory;
                currentDirectory = AddDirectoryAndFolder.findDirOn(virtual, directory);

                if (currentDirectory == null) {
                    AddDirectoryAndFolder.setVirtualCurrent(AddDirectoryAndFolder.getCurrent());
                    return null;
                }

                AddDirectoryAndFolder.setVirtualCurrent(currentDirectory);
            }

        }

        DirectoryInit directoryFound = AddDirectoryAndFolder.getVirtualCurrent();
        AddDirectoryAndFolder.setVirtualCurrent(AddDirectoryAndFolder.getCurrent());

        return directoryFound;
    }

    //checks if path exists and if it does it sets a virtual current directory
    public static Boolean pathExists(String path) {

        String[] directories = path.split("/");

        for (String directory : directories) {
            DirectoryInit virtual = AddDirectoryAndFolder.getVirtualCurrent();
            DirectoryInit parent = virtual.getParent();

            if (directory.equals("..")) {

                if (parent == null) {
                    return false;
                }

                AddDirectoryAndFolder.setVirtualCurrent(parent);
            } else {
                DirectoryInit currentDirectory;
                currentDirectory = AddDirectoryAndFolder.findDirOn(virtual, directory);

                if (currentDirectory == null) {
                    return false;
                }

                AddDirectoryAndFolder.setVirtualCurrent(currentDirectory);
            }

        }

        return true;
    }
    //killProcess
    public static void killProcess () {
        self = null;
        tree = new ArrayList<>();
        current = null;
        virtualCurrent = null;
    }

}