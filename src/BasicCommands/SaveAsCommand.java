package BasicCommands;

import BasicCommands.Command;

public class SaveAsCommand implements Command
{
    public void execute(String[] args)
    {
        System.out.println("Success! " + args[1]);
    }
}
