package kascode;

import java.util.Random;

public class PasswordGenerator {

    public static byte DEFAULT_PASSWORD_LENGTH = 16;

    public static boolean[] DEFAULT_CONDITIONS = {
      false, true, true, true
    };

    public static final String[] symbols = {
            "%*)?@#$~\"'",
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
            "abcdefghijklmnopqrstuvwxyz",
            "0123456789"
    };

    private final Random random;

    public PasswordGenerator(Random random) {
        this.random = random;
    }

    public PasswordGenerator() {
        this(new Random());
    }

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
    
    public String make() {
        return make(DEFAULT_PASSWORD_LENGTH,DEFAULT_CONDITIONS);
    }
}
