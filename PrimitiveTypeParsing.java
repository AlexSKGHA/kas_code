package kascode;

public class PrimitiveTypeParsing {

    public static int toInt (long number) {

        if (isLongNumberOfIntRange(number)) {

            int increment;
            if (number >= 0) {
                increment = 1;
            } else {
                increment = -1;
            }
            int i = 0;
            do {
                i += increment;
            } while (i != number);
            return i;
        } else {
            return 0;
        }
    }

    public static boolean isLongNumberOfIntRange(long num) {
        return (num >= -2147483648L) && (num <= 2147483647L);
    }
}
