package ConsoleCommands.FileManagment;

import ConsoleCommands.Interface.Command;
import ConsoleCommands.Interface.GlobalParameters;
import Parser.SimpleXMLParser;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Objects;

public class Open implements Command
{
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

    private String getFileExtension(String file) throws FileNotFoundException
    {
        int i = file.lastIndexOf('.');
        if (i >= 0) { return file.substring(i+1); }
        throw new FileNotFoundException("Missing file type! Valid types: txt, xml;");
    }

    private boolean validateFileType(String type) throws FileNotFoundException
    {
        if (Objects.equals(type, "txt") || Objects.equals(type, "xml")) return true;
        else throw new FileNotFoundException("Invalid file type! Valid types: txt, xml;");
    }

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
