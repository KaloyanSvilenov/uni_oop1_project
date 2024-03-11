import BasicCommands.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main
{
    private static Map<String, Command> commands = new HashMap<>();

    static {
        commands.put("open", new OpenCommand());
        commands.put("close", new CloseCommand());
        commands.put("save", new SaveCommand());
        commands.put("saveAs", new SaveAsCommand());
        commands.put("help", new HelpCommand());
        commands.put("exit", new ExitCommand());
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        for (;true;)
        {
            System.out.print("user:~$ ");

            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            String commandName = parts[0];
            Command command = commands.get(commandName);

            if (command != null) command.execute(parts);
            else System.out.println("Invalid command. Type 'help' for available commands.");
        }
    }
}
