package ConsoleCommands.XMLManagment;

import ConsoleCommands.Interface.Command;
import ConsoleCommands.Interface.GlobalParameters;
//import Parser.XPathQuery;
//import java.util.List;

public class XPath implements Command
{
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
