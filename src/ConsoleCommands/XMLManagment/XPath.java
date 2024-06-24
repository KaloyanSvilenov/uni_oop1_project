package ConsoleCommands.XMLManagment;

import ConsoleCommands.Interface.Command;
import ConsoleCommands.Interface.GlobalParameters;
//import Parser.XPathQuery;
//import java.util.List;

/**
 * Внедряване на командния интерфейс, който обработва XPath заявки в XML документ.
 * В момента функционалността не е внедрена и ще отпечата съобщение, което го посочва.
 */
public class XPath implements Command
{
    /**
     * Изпълнява командата XPath въз основа на предоставените аргументи.
     * Потвърждава броя на аргументите и проверява дали даден файл е отворен.
     * Ако е валидно, в момента се отпечатва съобщение, което показва, че функцията не е внедрена.
     * Веднъж внедрен, той ще изпълни XPath заявка за текущо отворения XML файл.
     *
     * @param args Аргументи на командата, състоящи се от командата XPath и параметрите на заявката.
     */
    public void execute(String[] args)
    {
        if (args.length < 3) System.out.println("Too few arguments! This command takes 2 arguments!");
        else if (args.length > 3) System.out.println("Too many arguments! This command takes 2 arguments!");
        else {
            if (GlobalParameters.checkIfFileIsOpened)
            {
                System.out.println("Function not implemented!");
                //performQuery(args[1], args[2]);
            } else
            {
                System.out.println("No open file! Need an open file to select from!");
            }
        }
    }

    /**
     * Извършва XPath заявка върху XML документа въз основа на предоставения XPath израз.
     * Този метод в момента е коментиран, тъй като функционалността не е внедрена.
     *
     * @param arg1 ИД на елемент, върху който трябва да се изпълни XPath заявката.
     * @param arg2 XPath израз на заявка за изпълнение.
     */
    private void performQuery(String arg1, String arg2)
    {
//        XPathQuery xpathQuery = new XPathQuery(GlobalParameters.nodeRoot);
//        List<String> result = xpathQuery.performXPathQuery(arg1, arg2);
//        System.out.println("Query: " + arg2);
//        for (String item : result) {
//            System.out.println(item);
//        }
    }
}
