package ConsoleCommands.FileManagment;

import ConsoleCommands.Interface.Command;
import ConsoleCommands.Interface.GlobalParameters;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Класът Save имплементира интерфейса Command и управлява запазването на текущото
 * отворен XML файл. Той проверява дали даден файл е отворен в момента, записва XML съдържанието
 * към файла и предоставя обратна връзка за успеха или неуспеха на операцията.
 */
public class Save implements Command
{
    /**
     * Изпълнява командата за запазване, за да запази текущо отворения XML файл.
     *
     * @param args аргументите на командата. Тази команда не очаква никакви аргументи.
     */
    public void execute(String[] args)
    {
        try {
            if (args.length > 1) {
                System.out.println("Too many arguments! This command does NOT take arguments!");
            }
            else {
                if (!GlobalParameters.checkIfFileIsOpened) {
                    System.out.println("No file to save! Need an open file to save!");
                }
                else {
                    PrintWriter out = new PrintWriter(GlobalParameters.file);
                    out.println(GlobalParameters.nodeRoot);
                    out.close();
                    System.out.println("Successfully saved file: " + GlobalParameters.file);
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Couldn't find file: " + GlobalParameters.file);
        }
        catch (IOException e) {
            System.out.println("Error while trying to save file: " + GlobalParameters.file);
        }
    }
}
