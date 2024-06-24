package ConsoleCommands.XMLManagment;

import ConsoleCommands.Interface.Command;
import ConsoleCommands.Interface.GlobalParameters;

/**
 * Внедряване на командния интерфейс, който обработва отпечатването на съдържанието на XML файла.
 */
public class Print implements Command
{
    /**
     * Изпълнява командата за печат въз основа на предоставените аргументи.
     * Ако не са предоставени аргументи, отпечатва съдържанието на текущо отворения XML файл.
     * Ако са предоставени твърде много аргументи, отпечатва съобщение за грешка.
     *
     * @param args Командни аргументи (не се очакват).
     */
    public void execute(String[] args)
    {
        if (args.length > 1) {
            System.out.println("Too many arguments! This command does NOT take arguments!");
        }
        else {
            if (GlobalParameters.checkIfFileIsOpened) {
                System.out.println(GlobalParameters.nodeRoot);
            }
            else {
                System.out.println("No file to print! Need an open file to print!");
            }
        }
    }
}
