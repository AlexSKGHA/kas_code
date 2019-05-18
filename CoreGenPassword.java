import java.util.Random;

class CoreGenPassword {

    private Random random = new Random();
    private StringBuilder password = new StringBuilder();
    private final StringBuilder Symbols = new StringBuilder("%*)?@#$~ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789");

    public String CoreGenPassword(int sizePassword, boolean useSings, boolean useBigLetters,boolean useSmallLetters, boolean useNumbers) {

        int i = 0;
        ///////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////Великолепное Ядро генерации паролей/////////////////////////////////   
        ///////////////////////////////////////////////////////////////////////////////////////////
        //В цикле выбирается случайное число (для переменной randomnum) и проверяется по условиям ядра. 
        //Если число не попадает ни под одно условие,
        //то оно является пригодным и используется для вытаскивания символов из переменной Symbols. (Symbols.ChatAt(randomnum)).
        //После эти символы присваиваются к перменной password. В конце цикла получается готовый пароль.
        while (i != sizePassword) {
            i++;
            int randomnum = random.nextInt(Symbols.length());

            //              Условия ядра.             //

            if (!useSings && randomnum < 8) {
                i -= 1;
                continue;
            }
            if (!useBigLetters && randomnum > 7 && randomnum < 34) {
                i -= 1;
                continue;
            }
            if (!useSmallLetters && randomnum > 33 && randomnum < 60) {
                i -= 1;
                continue;
            }
            if (!useNumbers && randomnum > 59) {
                i -= 1;
                continue;
            }
            password.append(Symbols.charAt(randomnum));
        }
        return password.toString();
    }
}
