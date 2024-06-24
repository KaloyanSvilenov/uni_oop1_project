package ConsoleCommands.XMLManagment;

import ConsoleCommands.Interface.Command;
import ConsoleCommands.Interface.GlobalParameters;

/**
 * Класът NewChild имплементира командния интерфейс и обработва командата 'newchild'.
 * Добавя нов дъщерен елемент към съществуващ XML елемент чрез неговия идентификатор от текущия отворен XML файл.
 */
public class NewChild implements Command
{
    /**
     * Изпълнява командата 'newchild' за добавяне на нов дъщерен елемент към съществуващ XML елемент по ID.
     *
     * @param args аргументите на командата. Трябва да съдържа идентификатора на XML елемента.
     */
    public void execute(String[] args)
    {
        if (args.length < 2) System.out.println("Too few arguments! This command takes 1 argument!");
        else if (args.length > 2) System.out.println("Too many arguments! This command takes 1 argument!");
        else {
            if (GlobalParameters.checkIfFileIsOpened) {
                newChildById(args[1]);
            }
            else {
                System.out.println("No open file! Need an open file to add to!");
            }
        }
    }

    /**
     * Добавя нов дъщерен елемент към съществуващ XML елемент чрез неговия ID.
     *
     * @param arg1 идентификаторът на XML елемента, към който трябва да се добави ново дете.
     */
    private void newChildById(String arg1)
    {
        boolean result = GlobalParameters.nodeRoot.addNewChildById(arg1);
        if (!result) {
            System.out.println("Error adding child! Possibly wrong id!");
        }
        else {
            System.out.println("New child element [" + arg1 + "] created successfully!");
        }
    }
}
