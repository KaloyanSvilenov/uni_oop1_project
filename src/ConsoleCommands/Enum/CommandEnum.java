package ConsoleCommands.Enum;

import ConsoleCommands.FileManagment.*;
import ConsoleCommands.Interface.Command;
import ConsoleCommands.XMLManagment.*;

/**
 * Преброяването {@code CommandEnum} дефинира набор от команди, използвани в конзолното приложение.
 * Всяка enum константа представлява конкретна команда заедно със съответното й действие.
 */
public enum CommandEnum {
    OPEN("open", new Open()),
    CLOSE("close", new Close()),
    SAVE("save", new Save()),
    SAVEAS("saveas", new SaveAs()),
    HELP("help", new Help()),
    EXIT("exit", new Exit()),
    PRINT("print", new Print()),
    SELECT("select", new Select()),
    SET("set", new Set()),
    CHILDREN("children", new Children()),
    CHILD("child", new Child()),
    TEXT("text", new Text()),
    DELETE("delete", new Delete()),
    NEWCHILD("newchild", new NewChild()),
    XPATH("xpath", new XPath());

    private final String commandName;
    private final Command command;

    /**
     * Конструира {@code CommandEnum} с посоченото име на команда и съответното действие.
     *
     * @param commandName името на командата.
     * @param command действието, свързано с командата.
     */
    CommandEnum(String commandName, Command command) {
        this.commandName = commandName;
        this.command = command;
    }

    /**
     * Получава името на командата.
     *
     * @return името на командата.
     */
    public String getCommandName() {
        return commandName;
    }


    /**
     * Получава действието, свързано с командата.
     *
     * @return действието, свързано с командата.
     */
    public Command getCommand() {
        return command;
    }

    /**
     * Извлича действието на командата въз основа на предоставеното име на команда.
     *
     * @param name името на командата.
     * @return действието, свързано с командата, или {@code null}, ако не бъде намерена съответстваща команда.
     */
    public static Command getCommandByName(String name) {
        for (CommandEnum commandEnum : values()) {
            if (commandEnum.getCommandName().equalsIgnoreCase(name)) {
                return commandEnum.getCommand();
            }
        }
        return null;
    }
}

