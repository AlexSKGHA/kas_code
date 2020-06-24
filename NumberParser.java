package kascode;

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
        //represents number of digits of the number argument.
        int num = 0;

        //checks if the number is negative.
        if (number < 0) {
            //minus as a digit to num variable if addMinusToNum is
            //true.
            if (addMinusToNum) {
                num++;
            }
        }

        //if number less than 10 or greater that -10 then
        //this if clause returns num variable adding one to it
        //because this number consist exactly of one digit.
        //if addMinusToNum would be true than minus is considered as
        //a digit.
        if ((number < 10) && (number > -10)) {
            return ++num;
        }

        //this block of code removes each left digit from
        //the number variable and adds one to num each iteration.
        while (number != 0) {
            //this expression removes a last digit of the number
            //each iteration.
            number = (number - (number % 10)) / 10;
            num += 1;
        }
        
        return num;
    }

    //shortcut of getNumOfDigits of 2 parameters.
    public static int getNumOfDigits (int number) {
        return getNumOfDigits(number, true);
    }
}
