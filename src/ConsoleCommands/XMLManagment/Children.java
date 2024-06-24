package ConsoleCommands.XMLManagment;

import ConsoleCommands.Interface.Command;
import ConsoleCommands.Interface.GlobalParameters;

import java.util.List;

/**
 * Класът Children имплементира командния интерфейс и обработва командата 'children'.
 * Той изброява атрибутите на вложените елементи по техния идентификатор на родителски елемент от текущото
 * отворен XML файл.
 */
public class Children implements Command
{
    /**
     * Изпълнява командата 'children', за да изброи атрибутите на вложените елементи по техния родителски ID.
     *
     * @param args аргументите на командата. Трябва да съдържа идентификатора на родителския елемент.
     */
    public void execute(String[] args)
    {
        if (args.length < 2) System.out.println("Too few arguments! This command takes 1 argument!");
        else if (args.length > 2) System.out.println("Too many arguments! This command takes 1 argument!");
        else {
            if (GlobalParameters.checkIfFileIsOpened) {
                searchForAttributeValue(args[1]);
            }
            else {
                System.out.println("No open file! Need an open file to select from!");
            }
        }
    }

    /**
     * Изброява атрибутите на вложените елементи по ID на техния родителски елемент.
     *
     * @param arg1 идентификационният номер на родителския елемент, чиито дъщерни атрибути трябва да бъдат изброени.
     */
    private void searchForAttributeValue(String arg1)
    {
        List<String> childAttributes = GlobalParameters.nodeRoot.getChildAttributesById(arg1);
        if (!childAttributes.isEmpty()) {
            for (String attributes : childAttributes)
            {
                System.out.println(attributes);
            }
        }
        else {
            System.out.println("No results found!");
        }
    }
}
