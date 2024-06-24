package ConsoleCommands.FileManagment;

import ConsoleCommands.Interface.Command;

/**
 * Класът Help имплементира командния интерфейс и предоставя списък с налични команди
 * и техните описания при изпълнение.
 */
public class Help implements Command
{
    /**
     * Изпълнява командата help. Ако са предоставени твърде много аргументи, ще се покаже подходящо съобщение.
     * Ако командата е изпълнена правилно, тя отпечатва списък с наличните команди и техните описания.
     *
     * @param args аргументите на командата (не се използват в тази команда)
     */
    public void execute(String[] args)
    {
        if (args.length > 1) {
            System.out.println("Too many arguments! This command does NOT take arguments!");
        }
        else
        {
            System.out.println
                    (
                            """

                                    -----[ List of commands ]-----
                                    open <file>             opens <file>
                                    close                   closes currently opened file
                                    save                    saves the currently open file
                                    saveas <file>           saves the currently open file in <file>
                                    help                    prints this list
                                    exit                    exists the program
                                                                    
                                    print                   outputs the contents of the file
                                    select <id> <key>       outputs the value of an attribute by element id and attribute key
                                    set <id> <key> <value>  assigns a value to an attribute by element id and attribute key
                                    children <id>           lists the attributes of the nested elements by element id
                                    child <id> <n>          prints the n-th child of an element by element id
                                    text <id>               outputs the text of an element by element id
                                    delete <id> <key>       deletes an attribute of an element by element id and attribute key
                                    newchild <id>           adds a new element nested in an existing element by element id
                                    xpath <id> <XPath>      supports XPath 2.0 expressions for the operators: / [] @ =
                                    """
                    );
        }
    }
}
