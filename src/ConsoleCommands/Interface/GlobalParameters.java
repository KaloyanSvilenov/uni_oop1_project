package ConsoleCommands.Interface;

import Parser.Node;
import java.util.ArrayList;
import java.util.List;

/**
 * Класът GlobalParameters съдържа глобални параметри, които се използват в приложението.
 */
public class GlobalParameters
{
    /**
     * Основният възел на анализираната XML структура.
     */
    public static Node nodeRoot;

    /**
     * Флаг за проверка дали даден файл е отворен в момента.
     */
    public static boolean checkIfFileIsOpened;

    /**
     * Името на текущо отворения файл.
     */
    public static String file;

    /**
     * Списък на всички уникални идентификатори в XML структурата.
     */
    public static List<String> id = new ArrayList<>();
}
