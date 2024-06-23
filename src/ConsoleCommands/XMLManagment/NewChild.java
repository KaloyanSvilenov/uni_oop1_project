package ConsoleCommands.XMLManagment;

import ConsoleCommands.Interface.Command;
import ConsoleCommands.Interface.GlobalParameters;

public class NewChild implements Command
{
    public void execute(String[] args)
    {
        if (args.length < 2) System.out.println("Too few arguments! This command takes 1 argument!");
        else if (args.length > 2) System.out.println("Too many arguments! This command takes 1 argument!");
        else {
            if (GlobalParameters.checkIfFileIsOpened) {
                newChildById(args[1]);
            }
            else {
                System.out.println("No open file! Need an open file to add to!");
            }
        }
    }

    private void newChildById(String arg1)
    {
        boolean result = GlobalParameters.nodeRoot.addNewChildById(arg1);
        if (!result) {
            System.out.println("Error adding child! Possibly wrong id!");
        }
        else {
            System.out.println("New child element [" + arg1 + "] created successfully!");
        }
    }
}
