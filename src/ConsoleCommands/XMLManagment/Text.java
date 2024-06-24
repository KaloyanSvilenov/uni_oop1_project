package ConsoleCommands.XMLManagment;

import ConsoleCommands.Interface.Command;
import ConsoleCommands.Interface.GlobalParameters;

/**
 * Внедряване на командния интерфейс, който обработва отпечатването на текстовото съдържание на XML елемент по ID.
 */
public class Text implements Command
{
    /**
     * Изпълнява текстовата команда въз основа на предоставения аргумент.
     * Потвърждава броя на аргументите и проверява дали даден файл е отворен.
     * Ако е валидно, отпечатва текстовото съдържание на посочения идентификатор на XML елемент.
     * Отпечатва съобщение, ако няма отворен файл или ако ID на елемента не съществува.
     *
     * @param args Аргумент на командата, състоящ се от ID на елемента, чието текстово съдържание трябва да бъде отпечатано.
     */
    public void execute(String[] args)
    {
        if (args.length < 2) System.out.println("Too few arguments! This command takes 1 argument!");
        else if (args.length > 2) System.out.println("Too many arguments! This command takes 1 argument!");
        else {
            if (GlobalParameters.checkIfFileIsOpened) {
                printElementText(args[1]);
            }
            else {
                System.out.println("No open file! Need an open file to select from!");
            }
        }
    }

    /**
     * Отпечатва текстовото съдържание на XML елемента, идентифициран от посочения ID.
     * Отпечатва съобщение, ако не бъдат намерени резултати за дадения идентификатор на елемент.
     *
     * @param arg1 ID на елемент, за който трябва да се отпечата текстовото съдържание.
     */
    private void printElementText(String arg1)
    {
        String result = GlobalParameters.nodeRoot.getContentById(arg1);
        if (result == null) {
            System.out.println("No results found!");
        }
        else {
            System.out.println("element [" + arg1 + "] : text=\"" + result + "\"");
        }
    }
}
