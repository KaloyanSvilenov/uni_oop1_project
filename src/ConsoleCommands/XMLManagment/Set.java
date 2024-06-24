package ConsoleCommands.XMLManagment;

import ConsoleCommands.Interface.Command;
import ConsoleCommands.Interface.GlobalParameters;

/**
 * Внедряване на командния интерфейс, който управлява настройката на стойностите на атрибути чрез идентификатор на елемент и ключ на атрибута.
 */
public class Set implements Command
{
    /**
     * Изпълнява зададената команда въз основа на предоставените аргументи.
     * Потвърждава броя на аргументите и проверява дали даден файл е отворен.
     * Ако е валиден, задава стойността на атрибута за посочения идентификатор на елемент и ключ на атрибута.
     * Отпечатва актуализираната стойност на атрибута, ако е успешна; в противен случай отпечатва съобщение, че няма резултати.
     *
     * @param args Командни аргументи, състоящи се от ID на елемент, ключ на атрибут и стойност на атрибут.
     */
    public void execute(String[] args)
    {
        if (args.length < 4) System.out.println("Too few arguments! This command takes 3 arguments!");
        else if (args.length > 4) System.out.println("Too many arguments! This command takes 3 arguments!");
        else {
            if (GlobalParameters.checkIfFileIsOpened)
            {
                setAttributeValue(args[1], args[2], args[3]);
            } else
            {
                System.out.println("No file open! Need an open file to set attribute values!");
            }
        }
    }

    /**
     * Задава стойността на атрибута за посочения идентификатор на елемент и ключ на атрибута.
     * Отпечатва актуализираната стойност на атрибута, ако е успешна; в противен случай отпечатва съобщение, че няма резултати.
     *
     * @param arg1 ИД на елемент, където трябва да бъде зададена стойността на атрибута.
     * @param arg2 Ключ на атрибут, за който трябва да бъде зададена стойността.
     * @param arg3 Нова стойност за задаване на атрибута.
     */
    private void setAttributeValue(String arg1, String arg2, String arg3)
    {
        boolean result = GlobalParameters.nodeRoot.setAttributeValueById(arg1, arg2, arg3);
        if (result) {
            System.out.println("No results found!");
        }
        else {
            System.out.println("element [" + arg1 + "] : " + arg2 + "=\"" + arg3 + "\"");
        }
    }
}
