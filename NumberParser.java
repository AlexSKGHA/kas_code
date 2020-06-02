public class NumberParser {

    public static int[] split (int number) {
        
        int[] digitsOfNumber = new int[getNumOfDigits(number)];
        int lengthOfArray = digitsOfNumber.length;

        if (digitsOfNumber.length == 1) {
            digitsOfNumber[0] = number;
            return digitsOfNumber;
        }

        if (number < 0) {
            number = -number;
        }

        for (int i = lengthOfArray - 1; i >= 0; i--) {
            int digit = number % 10;
            digitsOfNumber[i] = digit;
            number = (number - digit) / 10;
        }

        return digitsOfNumber;
    }

    public static int getNumOfDigits (int number,
                                      boolean addMinusToNum) {
        int num = 0;

        if (number < 0) {
            if (addMinusToNum) {
                num++;
            }
        }

        if ((number < 10) && (number > -10)) {
            return ++num;
        }

        while (number != 0) {
            number = (number - (number % 10)) / 10;
            num += 1;
        }
        
        return num;
    }

    public static int getNumOfDigits (int number) {
        return getNumOfDigits(number, true);
    }
}
