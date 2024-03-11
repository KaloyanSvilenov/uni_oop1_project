package BasicCommands;

public class HelpCommand implements Command
{
    public void execute(String[] args) {
        System.out.println
                (
                        "\n-----[ List of commands ]-----\n" +
                        "open     <file>   opens <file>\n" +
                        "close             closes currently opened file\n" +
                        "save              saves the currently open file\n" +
                        "saveAs   <file>   saves the currently open file in <file>\n" +
                        "help              prints this information\n" +
                        "exit              exists the program\n"
                );
    }
}
