package ConsoleCommands.FileManagment;

import ConsoleCommands.Interface.Command;

/**
 * Класът Exit имплементира командния интерфейс и отговаря за него
 * излизане от програмата.
 */
public class Exit implements Command
{
    /**
     * Изпълнява командата за изход. Ако са предоставени твърде много аргументи, ще се покаже подходящо съобщение.
     * Ако командата е изпълнена правилно, програмата ще излезе.
     *
     * @param args аргументите на командата
     */
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
