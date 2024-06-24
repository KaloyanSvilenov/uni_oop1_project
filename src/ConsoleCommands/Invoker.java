package ConsoleCommands;

import ConsoleCommands.Enum.CommandEnum;
import ConsoleCommands.Interface.Command;
import ConsoleCommands.FileManagment.*;
import ConsoleCommands.XMLManagment.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Класът Invoker отговаря за съпоставянето на потребителските команди към съответните им действия.
 * Той инициализира набор от предварително дефинирани команди и предоставя метод за слушане и изпълнение на конзолни команди.
 */
public class Invoker
{
    /**
     * Слуша за конзолни команди от потребителя, анализира входа и изпълнява съответната команда.
     * Ако командата не бъде разпозната, се показва съобщение за грешка.
     */
    public void ConsoleCommands()
    {
        Scanner scanner = new Scanner(System.in);

        // Безкраен цикъл за непрекъснато слушане за въвеждане от потребителя
        for (; true; )
        {
            System.out.print("user:~$ ");
            String[] parts = scanner.nextLine().split(" ");
            Command command = CommandEnum.getCommandByName(parts[0]);

            // Изпълнете командата, ако съществува, в противен случай отпечатайте съобщение за грешка
            if (command != null) command.execute(parts);
            else System.out.println("Invalid command. Type 'help' for available commands.");
        }
    }
}
