package OsOperation;
import Log.Log;
//class that Initializing the parameters and send to the relevant class for the process
public class OSCommand extends OsOperationAbstract {

    private OsOperationAbstract osQuery;
    // constructor for command + systemParams
    public OSCommand(String input) throws InstantiationException, ClassNotFoundException,
            IllegalAccessException{
        String command = OSCommand.extractCommand(input);
        String systemParams = OSCommand.extractParameters(command, input);

        this.osQuery = this.getCommand(command);

        this.osQuery.setSystemParams(systemParams);
    }
    // constructor for query
    public OsOperationAbstract getOsOpertion() {
        return osQuery;
    }
    // this methods take the command and sen to the relevant class (cd/mkdir/ls/touch)
    private OsOperationAbstract getCommand(String command) throws InstantiationException,
            ClassNotFoundException, IllegalAccessException
             {
        Log.info("send the command to relevant class") ;
        command = this.capitalize(command);
        Class<?> c = Class.forName("OsClasses." + command);
        return (OsOperationAbstract) c.newInstance();
    }


}