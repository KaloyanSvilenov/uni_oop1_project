package ConsoleCommands;

import ConsoleCommands.Interface.Command;
import ConsoleCommands.FileManagment.*;
import ConsoleCommands.XMLManagment.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Invoker
{
    private static Map<String, Command> commands = new HashMap<>();

    static
    {
        commands.put("open", new Open());
        commands.put("close", new Close());
        commands.put("save", new Save());
        commands.put("saveas", new SaveAs());
        commands.put("help", new Help());
        commands.put("exit", new Exit());
        commands.put("print", new Print());
        commands.put("select", new Select());
        commands.put("set", new Set());
        commands.put("children", new Children());
        commands.put("child", new Child());
        commands.put("text", new Text());
        commands.put("delete", new Delete());
        commands.put("newchild", new NewChild());
        commands.put("xpath", new XPath());
    }

    public void ConsoleCommands()
    {
        Scanner scanner = new Scanner(System.in);

        for (; true; )
        {
            System.out.print("user:~$ ");
            String[] parts = scanner.nextLine().split(" ");
            Command command = commands.get(parts[0]);

            if (command != null) command.execute(parts);
            else System.out.println("Invalid command. Type 'help' for available commands.");
        }
    }
}
