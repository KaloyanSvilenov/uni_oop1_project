package ConsoleCommands.XMLManagment;

import ConsoleCommands.Interface.Command;
import ConsoleCommands.Interface.GlobalParameters;
import Parser.Node;

/**
 * Класът Child имплементира командния интерфейс и обработва командата 'child'.
 * Отпечатва n-то дъщерно дете на елемент, идентифициран чрез неговия ID от current
 * отворен XML файл.
 */
public class Child implements Command
{

    /**
     * Executes the 'child' command to print the n-th child of an element.
     *
     * @param args the command arguments. Should contain the ID of the element and the index of the child.
     */
    public void execute(String[] args)
    {
        if (args.length < 3) System.out.println("Too few arguments! This command takes 2 arguments!");
        else if (args.length > 3) System.out.println("Too many arguments! This command takes 2 arguments!");
        else {
            if (GlobalParameters.checkIfFileIsOpened)
            {
                try {
                    printChild(args[1], args[2]);
                }
                catch (NumberFormatException e) {
                    System.out.println("Invalid 2nd argument! The argument should be an integer!");
                }

            } else
            {
                System.out.println("No open file! Need an open file to select from!");
            }
        }
    }

    /**
     * Отпечатва n-то дете на елемент, идентифициран чрез неговия ID.
     *
     * @param arg1 ID на елемента, чийто дъщерен елемент трябва да бъде отпечатан.
     * @param arg2 индексът на детето за печат (базиран на 1).
     */
    private void printChild(String arg1, String arg2)
    {
        Node childNode = GlobalParameters.nodeRoot.findNodeByIdAndIndex(arg1, Integer.parseInt(arg2)-1);
        if (childNode == null) {
            System.out.println("Child not found.");
        }
        else {
            System.out.println(childNode.toString());
        }
    }
}
