package ConsoleCommands.FileManagment;

import ConsoleCommands.Interface.Command;

public class Exit implements Command
{
    public void execute(String[] args)
    {
        if (args.length > 1) {
            System.out.println("Too many arguments! This command does NOT take arguments!");
        }
        else {
            System.out.println("Exiting the program...");
            System.exit(0);
        }
    }
}
