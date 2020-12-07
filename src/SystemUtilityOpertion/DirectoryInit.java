package SystemUtilityOpertion;
// Class for initialization the directories
public class DirectoryInit extends FileInitialization {
    // Constructor for directory
    public DirectoryInit() {
        super("root", (DirectoryInit) null);
    }
    // Constructor for directory(name,parent)
    public DirectoryInit(String name, DirectoryInit parent) {
        super(name, parent);
    }

    }