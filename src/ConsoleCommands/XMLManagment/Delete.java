package ConsoleCommands.XMLManagment;

import ConsoleCommands.Interface.Command;
import ConsoleCommands.Interface.GlobalParameters;

/**
 * Класът Delete имплементира интерфейса Command и обработва командата 'delete'.
 * Изтрива атрибут от XML елемент по идентификатор на елемент и ключ на атрибут от текущото
 * отворен XML файл.
 */
public class Delete implements Command
{
    /**
     * Изпълнява командата 'delete' за изтриване на атрибут от XML елемент по ID на елемент и ключ на атрибута.
     *
     * @param args аргументите на командата. Трябва да съдържа идентификатора на елемента и ключа на атрибута.
     */
    public void execute(String[] args)
    {
        if (args.length < 3) System.out.println("Too few arguments! This command takes 2 arguments!");
        else if (args.length > 3) System.out.println("Too many arguments! This command takes 2 arguments!");
        else {
            if (GlobalParameters.checkIfFileIsOpened)
            {
                searchForAttributeValue(args[1], args[2]);
            } else
            {
                System.out.println("No open file! Need an open file to delete from!");
            }
        }
    }

    /**
     * Изтрива атрибут от XML елемент по идентификатор на елемент и ключ на атрибута.
     *
     * @param arg1 идентификаторът на XML елемента, от който атрибутът трябва да бъде изтрит.
     * @param arg2 ключът на атрибута, който ще бъде изтрит.
     */
    private void searchForAttributeValue(String arg1, String arg2)
    {
        boolean result = GlobalParameters.nodeRoot.deleteAttributeById(arg1, arg2);
        if (!result) {
            System.out.println("No results found!");
        }
        else {
            System.out.println("Attribute [" + arg2 + "] of element [" + arg1 + "] successfully deleted!");
        }
    }
}
