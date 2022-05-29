package lcb.kascode;

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
    
    /**
     * Converts long type decimal to base 2.
     */
    public static String toBase2(long number) {
		
		StringBuilder binary = new StringBuilder();
		int power = 0;
		int previousPower = 0;
		while (number > 1) {
			previousPower = power;
			for (int i = 1; Math.pow(2, i) <= number; i++) {
				power = i;
			}
			
			for (int i = previousPower - 1; i > power; i--) {
				binary.append('0');
			}
			
			binary.append('1');
			number = number - (long) Math.pow(2, power);
		}
		
		for (int i = power; i > 1; i--) {
			binary.append('0');
		}
		
		binary.append(number);
		return binary.toString();
	}
}
