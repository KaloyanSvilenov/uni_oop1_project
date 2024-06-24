package ConsoleCommands.FileManagment;

import ConsoleCommands.Interface.Command;
import ConsoleCommands.Interface.GlobalParameters;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

/**
 * Класът SaveAs имплементира командния интерфейс и управлява запазването на текущото
 * отворен XML файл към нов файл, посочен от потребителя. Той потвърждава типа на файла,
 * записва XML съдържанието в новия файл и предоставя обратна връзка за успеха или
 * провал на операцията.
 */
public class SaveAs implements Command
{
    /**
     * Изпълнява командата saveas, за да запише текущо отворения XML файл в нов файл.
     *
     * @param args аргументите на командата. Трябва да съдържа името или пътя на новия файл.
     */
    public void execute(String[] args)
    {
        try {
            if (args.length == 1) {
                System.out.println("No file to save! Provide a name or path to file!");
            }
            else if (args.length == 2) {
                if (!GlobalParameters.checkIfFileIsOpened) {
                    System.out.println("No file to save! Need an open file to save!");
                }
                else {
                    saveAsImplementation(args[1]);
                }
            }
            else if (args.length > 2) {
                System.out.println("Too many arguments! Provide only a name or path to a file!");
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Couldn't find file: " + args[1] + ";\n" + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("Error while trying to save file: " + args[1]);
        }
    }

    /**
     * Извлича файловото разширение от предоставеното име на файл.
     *
     * @param file името на файла или пътя, от който да се извлече разширението.
     * @return разширението на файла.
     * @throws FileNotFoundException, ако типът на файла липсва или е невалиден.
     */
    private String getFileExtension(String file) throws FileNotFoundException
    {
        int i = file.lastIndexOf('.');
        if (i >= 0) { return file.substring(i+1); }
        throw new FileNotFoundException("Missing file type! Valid types: txt, xml;");
    }

    /**
     * Проверява дали типът файл е "txt" или "xml".
     *
     * @param type типа файл за проверка.
     * @return true, ако типът файл е валиден, false в противен случай.
     * @throws FileNotFoundException, ако типът на файла е невалиден.
     */
    private boolean validateFileType(String type) throws FileNotFoundException
    {
        if (Objects.equals(type, "txt") || Objects.equals(type, "xml")) return true;
        else throw new FileNotFoundException("Invalid file type! Valid types: txt, xml;");
    }

    /**
     * Реализира запазването на текущо отворения XML файл в посочения файл.
     *
     * @param file името или пътя на файла, в който да се запише XML съдържанието.
     * @throws FileNotFoundException, ако указаният файл не е намерен или не може да бъде създаден.
     */
    private void saveAsImplementation(String file) throws FileNotFoundException
    {
        if (validateFileType(getFileExtension(file)))
        {
            PrintWriter out = new PrintWriter(file);
            out.println(GlobalParameters.nodeRoot);
            out.close();
            System.out.println("Successfully saved file: " + file);
        }
        else {
            throw new FileNotFoundException();
        }
    }
}
