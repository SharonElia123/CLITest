package SystemUtilityOpertion;
import java.util.ArrayList;

 // Class created to handle the tree with directory list

public class CreateListAndTree {
    private static ArrayList<DirectoryInit> tree;
    private static CreateListAndTree self;
    public CreateListAndTree(DirectoryInit root) {
        tree = new ArrayList<>();
    }

    public CreateListAndTree() {

    }

    public static CreateListAndTree create(DirectoryInit root) {
        if (!(self instanceof CreateListAndTree)) {
            self = new CreateListAndTree(root);
        }
        return self;
    }
    public static ArrayList<DirectoryInit> getTree() {
        return tree;
    }
    public static boolean addDirectory(DirectoryInit newDir) {
        for (FileInitialization file : getFilesOf(newDir.getParent())) {
            if (file.getName().equals(newDir.getName())) {
                return false;
            }
        }
        return tree.add(newDir);
    }

    public static ArrayList<FileInitialization> getFilesOf(DirectoryInit parent) {
        ArrayList<FileInitialization> files = new ArrayList<>();
        for (DirectoryInit d : getTree()) {
            DirectoryInit dParent = d.getParent();
            if (dParent == null) {
                continue;
            }

            if (d.getParent().getName().equals(parent.getName())) {
                files.add(d);
            }
        }
        return files;
    }


}
