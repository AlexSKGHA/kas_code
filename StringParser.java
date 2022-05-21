package venom.kascode;

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
     * 5/21/2022 Edit: Java 1.8 is class written for.
     * The class is used to deal with strings in a particular manner.
     * The idea of implementing this code was to get additional tools when writing a console-like programs,
     * to parse commands, arguments and so on.
     * Attributes of this class might be modified or deprecated in the future. And new ones will be added til I run out
     * of ideas or get skilled enough to use built-in libraries.
     * */

    public static void main(String[] args) {
    }

    public static final String SPACE = " ";

    @Deprecated
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

    @Deprecated
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

//    @Deprecated
//    public static String[] getBalancedEnumeration (int start, int end) {
//
//        int maxLength = NumberParser.getNumOfDigits(end);
//        int arrayLength = end - start;
//        String[] enums = new String[arrayLength];
//        int size;
//        int num;
//        for (int i = 0; i < arrayLength; i++) {
//            num = i + start;
//            size = NumberParser.getNumOfDigits(num);
//            enums[i] = num + SPACE.repeat(maxLength - size);
//        }
//        return enums;
//    }
    @Deprecated
    public static int obtainNumberOfWords(String str) {

        int numberOfSpaces = obtainNumberOfSpaces(str);
		int endSpaces = 1;

		for (int i = 0; i < str.length(); i += str.length() - 1) {
			if (str.charAt(i) == ' ') {
				endSpaces--;
			}
		}

		return numberOfSpaces + endSpaces;
	}

    @Deprecated
	private static int obtainNumberOfSpaces(String str) {
		int numberOfSpaces = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				numberOfSpaces++;
				for (; i < str.length(); i++) {
					if (str.charAt(i) != ' ') {
						i--;
						break;
					}
				}
			}
		}
		return numberOfSpaces;
	}

    @Deprecated
	private static int[][] findStringSubstringMethodWordCoordinates(String str) {

		int[][] cords = new int[obtainNumberOfWords(str)][2];
		int wordIndex = -1;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ' ') {
				wordIndex++;
				cords[wordIndex][0] = i;

				for (; i < str.length(); i++) {
					if (str.charAt(i) == ' ') {
						break;
					}
				}
				cords[wordIndex][1] = i;
			}
		}
		return cords;
	}

	public static String[] getWords(String str) {
		int[][] cords = findStringSubstringMethodWordCoordinates(str);
		String[] words = new String[cords.length];
		for (int i = 0; i < words.length; i++) {
			words[i] = str.substring(cords[i][0], cords[i][1]);
		}
		return words;
	}

    /**
     * Counts segments comprised of non-space characters.
     */
    public static int countWords(String line) {

        String trimmedLine = trimLine(line);
        int length = trimmedLine.length();

        if (length < 1) {
            return 0;
        }

        int gapOccurrences = 0;
        boolean isSpaceDetected = false;
        char currentChar;

        for (int i = 0; i < length; i++) {
            currentChar = trimmedLine.charAt(i);
            if (currentChar != ' ') {
                isSpaceDetected = false;
            }
            if ((currentChar == ' ') && !isSpaceDetected) {
                isSpaceDetected = true;
                gapOccurrences++;
            }
        }
        return gapOccurrences + 1;
    }

    /**
     * Removes spaces up to a character that is not space.
     * Applied to both ends of a string.
     */
    public static String trimLine(String line) {

        int length = line.length();
        int startIndex = 0;
        int endIndex = 0;
        boolean isStartLocked = false;
        boolean isEndLocked = false;
        for (int i = 0; i < length; i++) {
            if (!isStartLocked) {
                if (line.charAt(i) != 32) {
                    isStartLocked = true;
                    startIndex = i;
                }
            }
            if (!isEndLocked) {
                if (line.charAt(length - 1 - i) != 32) {
                    isEndLocked = true;
                    endIndex = length - i;
                }
            }
            if(isStartLocked && isEndLocked) {
                break;
            }
        }
        return line.substring(startIndex, endIndex);
    }

    /**
     * Returns an array where each element holds one single word.
     * line parameter value is split into words that then are represented as an array.
     * Parameter line could be empty string which returns an array of a size 0.
     */
    public static String[] intoWords(String line) {

        String trimmedLine = trimLine(line);
        int length = trimmedLine.length();
        if (length < 1) {
            return new String[0];
        }
        String[] words = new String[countWords(trimmedLine)];

        int startIndex = 0;
        int wordCount = 0;
        boolean isInWord = true;
        char currentChar;
        for (int i = 0; i < length; i++) {
            currentChar = trimmedLine.charAt(i);
            if ((currentChar != 32) && !isInWord) {
                isInWord = true;
                startIndex = i;
            }
            if ((currentChar == 32) && isInWord) {
                isInWord = false;
                words[wordCount] = trimmedLine.substring(startIndex, i);
                wordCount++;
            }
        }
        words[wordCount] = trimmedLine.substring(startIndex, length);

        return words;
    }
}
