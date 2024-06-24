package ConsoleCommands.Interface;

/**
 * Командният интерфейс представлява команда, която може да бъде изпълнена с дадени аргументи.
 */
public interface Command
{
    /**
     * Изпълнява командата с посочените аргументи.
     *
     * @param args аргументите за командата
     */
    void execute(String[] args);
}
