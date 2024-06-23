package ConsoleCommands.FileManagment;

import ConsoleCommands.Interface.Command;
import ConsoleCommands.Interface.GlobalParameters;

public class Close implements Command
{
    public void execute(String[] args)
    {
        if (args.length > 1) {
            System.out.println("Too many arguments! This command does NOT take arguments!");
        }
        else
        {
            if (GlobalParameters.checkIfFileIsOpened)
            {
                GlobalParameters.nodeRoot.deleteTree();
                GlobalParameters.nodeRoot = null;
                GlobalParameters.checkIfFileIsOpened = false;
                System.out.println("Successfully closed file!");
            } else
            {
                System.out.println("No file to close! Need an open file to close!");
            }
        }
    }
}
