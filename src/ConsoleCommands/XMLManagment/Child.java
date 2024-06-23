package ConsoleCommands.XMLManagment;

import ConsoleCommands.Interface.Command;
import ConsoleCommands.Interface.GlobalParameters;
import Parser.Node;

public class Child implements Command
{
    public void execute(String[] args)
    {
        if (args.length < 3) System.out.println("Too few arguments! This command takes 2 arguments!");
        else if (args.length > 3) System.out.println("Too many arguments! This command takes 2 arguments!");
        else {
            if (GlobalParameters.checkIfFileIsOpened)
            {
                try {
                    printChild(args[1], args[2]);
                }
                catch (NumberFormatException e) {
                    System.out.println("Invalid 2nd argument! The argument should be an integer!");
                }

            } else
            {
                System.out.println("No open file! Need an open file to select from!");
            }
        }
    }

    private void printChild(String arg1, String arg2)
    {
        Node childNode = GlobalParameters.nodeRoot.findNodeByIdAndIndex(arg1, Integer.parseInt(arg2)-1);
        if (childNode == null) {
            System.out.println("Child not found.");
        }
        else {
            System.out.println(childNode.toString());
        }
    }
}
