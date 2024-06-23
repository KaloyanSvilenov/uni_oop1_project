package ConsoleCommands.XMLManagment;

import ConsoleCommands.Interface.Command;
import ConsoleCommands.Interface.GlobalParameters;

public class Select implements Command
{
    public void execute(String[] args)
    {
        if (args.length < 3) System.out.println("Too few arguments! This command takes 2 arguments!");
        else if (args.length > 3) System.out.println("Too many arguments! This command takes 2 arguments!");
        else {
            if (GlobalParameters.checkIfFileIsOpened)
            {
                searchForAttributeValue(args[1], args[2]);
            } else
            {
                System.out.println("No open file! Need an open file to select from!");
            }
        }
    }

    private void searchForAttributeValue(String arg1, String arg2)
    {
        String result = GlobalParameters.nodeRoot.getAttributeValueById(arg1, arg2);
        if (result == null) {
            System.out.println("No results found!");
        }
        else {
            System.out.println("element [" + arg1 + "] : " + arg2 + "=\"" + result + "\"");
        }
    }
}
