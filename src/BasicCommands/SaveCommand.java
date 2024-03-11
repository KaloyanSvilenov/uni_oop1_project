package BasicCommands;

import BasicCommands.Command;

public class SaveCommand implements Command
{
    public void execute(String[] args)
    {
        System.out.println("Success! " + args[0]);
    }
}
