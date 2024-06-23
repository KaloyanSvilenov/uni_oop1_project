package ConsoleCommands.XMLManagment;

import ConsoleCommands.Interface.Command;
import ConsoleCommands.Interface.GlobalParameters;

public class Text implements Command
{
    public void execute(String[] args)
    {
        if (args.length < 2) System.out.println("Too few arguments! This command takes 1 argument!");
        else if (args.length > 2) System.out.println("Too many arguments! This command takes 1 argument!");
        else {
            if (GlobalParameters.checkIfFileIsOpened) {
                printElementText(args[1]);
            }
            else {
                System.out.println("No open file! Need an open file to select from!");
            }
        }
    }

    private void printElementText(String arg1)
    {
        String result = GlobalParameters.nodeRoot.getContentById(arg1);
        if (result == null) {
            System.out.println("No results found!");
        }
        else {
            System.out.println("element [" + arg1 + "] : text=\"" + result + "\"");
        }
    }
}
