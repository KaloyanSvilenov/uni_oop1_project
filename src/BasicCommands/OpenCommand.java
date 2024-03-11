package BasicCommands;

public class OpenCommand implements Command
{
    public void execute(String[] args)
    {
        System.out.println("Success! " + args[1]);
    }
}
