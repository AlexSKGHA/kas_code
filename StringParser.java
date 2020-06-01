public class StringParser {

    /**
     *       ИНСТРУКЦИЯ ЭКСПЛУАТАЦИИ
     * НЕ ЛЕЗЬ НИКУДА И ВСЕ БУДЕТ РАБОТАТЬ!
     *
     * 1) ЧТОБЫ ВЫВЕСТИ КОМАНДУ ИЗ СТРОКИ (первое слово в строке),
     * НУЖНО ИСПОЛЬЗОВАТЬ МЕТОД getCommand(String str);
     * 2) ЧТОБЫ ПОЛУЧИТЬ АРГУМЕНТЫ КОМАНДЫ,
     * НУЖНО ИСПОЛЬЗОВАТЬ МЕТОД getArguments(String str);
     * ЭТОТ МЕТОД ВОЗВРАЩАЕТ МАССИВ, ПОЭТОМУ НУЖНО РЕАЛИЗОВАТЬ ПЕРЕМЕННУЮ
     * String[] И ВЕРНУТЬ В НЕГО СООТВЕТСТВЕННЫЙ МЕТОД.
     * НАПРИМЕР:
     *  StringParser sp = new StringParser();
     *  String[] example = sp.getArguments("команда аргумент\ 1 аргумент\ 2 аргумент\ 3");
     * ЧТОБЫ УКАЗАТЬ ПРОБЕЛ В АРГУМЕНТЕ, НУЖНО ПЕРЕД ПРОБЕЛОМ ПОСТАВИТЬ
     * В КОДЕ ПРОГРАММЫ СИМВОЛЫ \\ ИЛИ ПРИ ВВОДЕ С КОНСОЛИ \
     *
     * */

    public static final String SPACE = " ";

    public static String getCommand(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if (!str.substring(i,i+1).equals(" ")) {
                result += str.substring(i,i+1);
            } else {
                break;
            }
        }
        return result;
    }

    public static String[] getArguments(String str) {

        String[] arguments;

        int sizeArrayofArguments = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i,i+1).equals(" ")) {
                sizeArrayofArguments += 1;
            }
        }

        arguments = new String[sizeArrayofArguments];

        for (int i = 0; i < arguments.length; i++) {
            arguments[i] = "";
        }

        int place = -1;

        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i,i+1).equals(" ")) {
                String argument = "";
                place += 1;
                i++;
                for (; i < str.length(); i++) {
                    if (str.substring(i,i+1).equals(" ")) {
                        i--;
                        break;
                    } else if (str.substring(i,i+1).equals("\\")) {
                        i++;
                        argument += " ";
                        continue;
                    } else {
                        argument += str.substring(i,i+1);
                    }
                }
                arguments[place] = argument;
            }
        }
        return arguments;
    }

    public static String[] getBalancedEnumeration (int start, int end) {

        int maxLength = NumberParser.getNumOfDigits(end);
        int arrayLength = end - start;
        String[] enums = new String[arrayLength];
        int size;
        int num;
        for (int i = 0; i < arrayLength; i++) {
            num = i + start;
            size = NumberParser.getNumOfDigits(num);
            enums[i] = num + SPACE.repeat(maxLength - size);
        }
        return enums;
    }
}
