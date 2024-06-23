package ConsoleCommands.XMLManagment;

import ConsoleCommands.Interface.Command;
import ConsoleCommands.Interface.GlobalParameters;

public class Print implements Command
{
    public void execute(String[] args)
    {
        if (args.length > 1) {
            System.out.println("Too many arguments! This command does NOT take arguments!");
        }
        else {
            if (GlobalParameters.checkIfFileIsOpened) {
                System.out.println(GlobalParameters.nodeRoot);
            }
            else {
                System.out.println("No file to print! Need an open file to print!");
            }
        }
    }
}
