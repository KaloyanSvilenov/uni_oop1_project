package ConsoleCommands.FileManagment;

import ConsoleCommands.Interface.Command;
import ConsoleCommands.Interface.GlobalParameters;
import Parser.SimpleXMLParser;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Objects;

/**
 * Класът Open имплементира командния интерфейс и управлява отварянето на файлове
 * въз основа на въвеждане от потребителя. Поддържа отваряне на текстови и XML файлове, проверява за валидни типове файлове,
 * и управлява състоянието на отворения файл в GlobalParameters.
 */
public class Open implements Command
{
    /**
     * Изпълнява командата за отваряне въз основа на предоставените аргументи.
     *
     * @param args аргументите на командата. Очаква args[1] да бъде името на файла или пътя за отваряне.
     */
    public void execute(String[] args)
    {

        try
        {
            if (args.length == 1) {
                System.out.println("No file to open! Provide a name or path to a file!");
            }
            else if (args.length == 2) {
                if (!GlobalParameters.checkIfFileIsOpened) {
                    saveAsImplementation(args[1]);
                }
                else {
                    System.out.println("Close the current file before opening another!");
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
            System.out.println("Error while trying to open file: " + args[1]);
        }
    }

    /**
     * Извлича файловото разширение от предоставеното име на файл или път.
     *
     * @param file името на файла или пътя, от който да се извлече разширението.
     * @return на файловото разширение (напр. "txt", "xml").
     * @throws FileNotFoundException, ако типът на файла липсва или е невалиден.
     */
    private String getFileExtension(String file) throws FileNotFoundException
    {
        int i = file.lastIndexOf('.');
        if (i >= 0) { return file.substring(i+1); }
        throw new FileNotFoundException("Missing file type! Valid types: txt, xml;");
    }

    /**
     * Потвърждава типа на файла въз основа на неговото разширение.
     *
     * @param type файловото разширение за проверка.
     * @return true, ако типът на файла е валиден ("txt" или "xml"), false в противен случай.
     * @throws FileNotFoundException, ако типът на файла е невалиден.
     */
    private boolean validateFileType(String type) throws FileNotFoundException
    {
        if (Objects.equals(type, "txt") || Objects.equals(type, "xml")) return true;
        else throw new FileNotFoundException("Invalid file type! Valid types: txt, xml;");
    }

    /**
     * Внедрява функционалността за отваряне и анализиране на файл с помощта на SimpleXMLParser.
     * Ако е успешно, задава анализирания основен възел в GlobalParameters, маркира файла
     * както е отворен и отпечатва съобщение за успех.
     *
     * @param file името или пътя на файла за отваряне.
     * @throws IOException, ако възникне грешка по време на анализ на файл.
     */
    private void saveAsImplementation(String file) throws IOException
    {
        if (validateFileType(getFileExtension(file)))
        {
            SimpleXMLParser parser = new SimpleXMLParser();
            GlobalParameters.nodeRoot = parser.parse(file);
            GlobalParameters.file = file;
            GlobalParameters.checkIfFileIsOpened = true;
            System.out.println("Successfully opened file: " + file);
        }
        else {
            throw new FileNotFoundException();
        }
    }
}
