package OsOperation;
import Log.Log;
/*
In this class I Concentrate several methods, like capitalize, extract command and extractParameters.
 */
abstract public class OsOperationAbstract {
    private String systemParams;
    public void setSystemParams(String sp) {
        systemParams = sp;
    }
    public String getSystemParams() {
        return systemParams == null ? "" : systemParams;
    }
   //In this methods, we send a message to the user to write the correct command
    public void executeQuery() throws Exception {
        System.out.println("Please, send the correct Directory/ Folder/File");
    }
    // This methods take the the first character and capitalize, like "cd" to "Cd"
    public String capitalize(String command) {
        String sh="ffff";
        return command.substring(0, 1).toUpperCase() + command.substring(1);
    }
    /* This methods take the the  command name like "mkdir fff" and remove from the space till the end.
    from "mkdir sharon" to "mkdir" only.
    */
    public static String extractCommand(String command) {
        int spaceIndex = command.indexOf(" ");
        if (spaceIndex > -1) {
            command = command.substring(0, command.indexOf(" ")).trim();
        }

        return command;
    }
    // this method get command and the input(mkdir and the mkdir+dir name) and remove the command
    public static String extractParameters(String command, String input) {
        Log.info("return parameter");
        int afterCommand = input.indexOf(command) + command.length();
        String parameters = input.substring(afterCommand).trim();
        return parameters;
    }

}