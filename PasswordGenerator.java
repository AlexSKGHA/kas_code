import java.util.Random;

public class PasswordGenerator {

    public static final String[] symbols = {
            "%*)?@#$~\"'",
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
            "abcdefghijklmnopqrstuvwxyz",
            "0123456789"
    };

    private static byte requiredArrayAmount = 4;

    private Random random = new Random();

    public String make(byte length, boolean[] args) {

        boolean validArray = checkArr(args, requiredArrayAmount);
        boolean validLength = checkPasswordLengthVariable(length);

        if ((!validArray) || (!validLength)) {
            System.err.println("Invalid arguments");
            return "Invalid arguments";
        }

        String password = "";
        String selectedSymbols = "";
        byte symbolLength = (byte) symbols.length;

        for (byte i = 0; i < symbolLength; i++) {
            if (args[i] == true) {
                selectedSymbols += symbols[i];
            }
        }

        byte selectedSymbolsLength = (byte) selectedSymbols.length();

        for (int i = 0; i < length; i++) {
            password += String.valueOf(selectedSymbols.charAt(random.nextInt(selectedSymbolsLength)));
        }

        return password;
    }

    private boolean checkPasswordLengthVariable (byte length) {
        if (length > 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkArr (boolean[] args, byte requiredAmount) {

        boolean valueCheck = false;
        boolean amountCheck = false;

        for (boolean value : args) {
            if (value == true)
                valueCheck = true;
        }

        if (args.length == requiredAmount)
            amountCheck = true;

        if ((valueCheck == true) && (amountCheck == true)) {
            return true;
        } else {
            return false;
        }
    }
}
