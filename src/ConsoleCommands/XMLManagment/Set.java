package ConsoleCommands.XMLManagment;

import ConsoleCommands.Interface.Command;
import ConsoleCommands.Interface.GlobalParameters;

public class Set implements Command
{
    public void execute(String[] args)
    {
        if (args.length < 4) System.out.println("Too few arguments! This command takes 3 arguments!");
        else if (args.length > 4) System.out.println("Too many arguments! This command takes 3 arguments!");
        else {
            if (GlobalParameters.checkIfFileIsOpened)
            {
                setAttributeValue(args[1], args[2], args[3]);
            } else
            {
                System.out.println("No file open! Need an open file to set attribute values!");
            }
        }
    }

    private void setAttributeValue(String arg1, String arg2, String arg3)
    {
        boolean result = GlobalParameters.nodeRoot.setAttributeValueById(arg1, arg2, arg3);
        if (result) {
            System.out.println("No results found!");
        }
        else {
            System.out.println("element [" + arg1 + "] : " + arg2 + "=\"" + arg3 + "\"");
        }
    }
}
