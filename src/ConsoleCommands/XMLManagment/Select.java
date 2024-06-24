package ConsoleCommands.XMLManagment;

import ConsoleCommands.Interface.Command;
import ConsoleCommands.Interface.GlobalParameters;

/**
 * Внедряване на командния интерфейс, който управлява избора на стойност на атрибут чрез идентификатор на елемент и ключ на атрибута.
 */
public class Select implements Command
{
    /**
     * Изпълнява командата select въз основа на предоставените аргументи.
     * Потвърждава броя на аргументите и проверява дали даден файл е отворен.
     * Ако е валиден, търси стойността на атрибута по даден ID на елемент и ключ на атрибута.
     * Отпечатва стойността на атрибута, ако бъде намерена; в противен случай отпечатва съобщение, че няма резултати.
     *
     * @param args Аргументи на командата, състоящи се от ID на елемент и ключ на атрибут.
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
                System.out.println("No open file! Need an open file to select from!");
            }
        }
    }

    /**
     * Търси стойността на атрибута по предоставения идентификатор на елемент и ключ на атрибута.
     * Отпечатва стойността на атрибута, ако бъде намерена; в противен случай отпечатва съобщение, че няма резултати.
     *
     * @param arg1 ID на елемент за търсене.
     * @param arg2 Ключ на атрибут за търсене.
     */
    private void searchForAttributeValue(String arg1, String arg2)
    {
        String result = GlobalParameters.nodeRoot.getAttributeValueById(arg1, arg2);
        if (result == null) {
            System.out.println("No results found!");
        }
        else {
            System.out.println("element [" + arg1 + "] : " + arg2 + "=\"" + result + "\"");
        }
    }
}
