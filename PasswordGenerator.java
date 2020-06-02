import java.util.Random;

public class PasswordGenerator {

    public static final String[] symbols = {
            "%*)?@#$~\"'",
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
            "abcdefghijklmnopqrstuvwxyz",
            "0123456789"
    };

    private final Random random = new Random();

    public String make(byte length, boolean[] args) {
        StringBuilder password = new StringBuilder();
        StringBuilder symbolsToUse = new StringBuilder();

        byte symbolLength = (byte) symbols.length;

        for (byte i = 0; i < symbolLength; i++) {
            if (args[i]) {
                symbolsToUse.append(symbols[i]);
            }
        }

        byte selectedSymbolsLength = (byte) symbolsToUse.length();

        for (int i = 0; i < length; i++) {
            password.append(symbolsToUse.charAt(random.nextInt(selectedSymbolsLength)));
        }

        return password.toString();
    }
}
