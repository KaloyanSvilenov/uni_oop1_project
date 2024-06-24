package ConsoleCommands.FileManagment;

import ConsoleCommands.Interface.Command;
import ConsoleCommands.Interface.GlobalParameters;

/**
 * Класът Close реализира командния интерфейс и отговаря за
 * затваряне на текущо отворения XML файл.
 */
public class Close implements Command
{
    /**
     * Изпълнява командата за затваряне. Ако даден файл е отворен в момента, той ще бъде затворен и дървото ще бъде изтрито.
     * Ако няма отворен файл или са предоставени твърде много аргументи, ще се покаже подходящо съобщение.
     *
     * @param args аргументите на командата
     */
    public void execute(String[] args)
    {
        if (args.length > 1) {
            System.out.println("Too many arguments! This command does NOT take arguments!");
        }
        else
        {
            if (GlobalParameters.checkIfFileIsOpened)
            {
                GlobalParameters.nodeRoot.deleteTree();
                GlobalParameters.nodeRoot = null;
                GlobalParameters.checkIfFileIsOpened = false;
                System.out.println("Successfully closed file!");
            } else
            {
                System.out.println("No file to close! Need an open file to close!");
            }
        }
    }
}
