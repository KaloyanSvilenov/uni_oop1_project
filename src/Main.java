import ConsoleCommands.Invoker;

/**
 * Основният клас е входната точка на приложението.
 * Инициализира класа Invoker и започва да слуша за конзолни команди.
 */
public class Main
{
    /**
     * Основният метод, който служи като входна точка на приложението.
     * Създава екземпляр на Invoker и извиква метода ConsoleCommands, за да стартира интерфейса на командния ред.
     *
     * @param args аргументи от командния ред (не се използват в това приложение)
     */
    public static void main(String[] args)
    {
        Invoker invoker = new Invoker();
        invoker.ConsoleCommands();
    }
}
