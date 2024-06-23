package ConsoleCommands.FileManagment;

import ConsoleCommands.Interface.Command;
import ConsoleCommands.Interface.GlobalParameters;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Save implements Command
{
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
