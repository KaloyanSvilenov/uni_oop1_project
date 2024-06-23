package ConsoleCommands.XMLManagment;

import ConsoleCommands.Interface.Command;
import ConsoleCommands.Interface.GlobalParameters;

import java.util.List;

public class Children implements Command
{
    public void execute(String[] args)
    {
        if (args.length < 2) System.out.println("Too few arguments! This command takes 1 argument!");
        else if (args.length > 2) System.out.println("Too many arguments! This command takes 1 argument!");
        else {
            if (GlobalParameters.checkIfFileIsOpened) {
                searchForAttributeValue(args[1]);
            }
            else {
                System.out.println("No open file! Need an open file to select from!");
            }
        }
    }

    private void searchForAttributeValue(String arg1)
    {
        List<String> childAttributes = GlobalParameters.nodeRoot.getChildAttributesById(arg1);
        if (!childAttributes.isEmpty()) {
            for (String attributes : childAttributes)
            {
                System.out.println(attributes);
            }
        }
        else {
            System.out.println("No results found!");
        }
    }
}
