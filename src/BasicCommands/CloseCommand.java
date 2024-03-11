package BasicCommands;

public class CloseCommand implements Command
{
    public void execute(String[] args)
    {
        System.out.println("Success! " + args[0]);
    }
}
