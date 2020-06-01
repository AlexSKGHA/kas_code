public class PrimitiveTypeParsing {
    
    public static int toInt (long number) {
        if (Math.abs(number) < 2147483648L) {
            int count = 0;
            for (long i = 0; i < number; i++) {
                count++;
            }
            return count;
        } else {
            return 0;
        }
    }
}
