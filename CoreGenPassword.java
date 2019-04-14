import java.util.Random;

class CoreGenPassword {
    //Объявление переменных.
    String password;
    static String Symbols = "%*)?@#$~ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"; //Из этих символов делается пароль.
    int i;
    int randomnum;
    
    public String CoreGenPassword(int sizePassword, boolean useSings, boolean useBigLetters,boolean useSmallLetters, boolean useNumbers) {
        //Обнуление переменных для повторного их использования.
        Random random = new Random();
        password = "";
        i = 0;
        randomnum = 0;
        ///////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////Великолепное Ядро генерации паролей/////////////////////////////////   
        ///////////////////////////////////////////////////////////////////////////////////////////
        //В цикле выбирается случайное число (для переменной randomnum) и проверяется по условиям ядра. 
        //Если число не попадает ни под одно условие,
        //то оно является пригодным и используется для вытаскивания символов из переменной Symbols. (Symbols.ChatAt(randomnum)).
        //После эти символы присваиваются к перменной password. В конце цикла получается готовый пароль.
        while (i != sizePassword) {
            i++;
            randomnum = random.nextInt(Symbols.length()); 
            
            //              Условия ядра.             //
            
            if (useSings == false && randomnum < 8) {
                i -= 1;
                continue;
            }
            if (useBigLetters == false && randomnum > 7 && randomnum < 34) {
                i -= 1;
                continue;
            }
            if (useSmallLetters == false && randomnum > 33 && randomnum < 60) {
                i -= 1;
                continue;
            }
            if (useNumbers == false && randomnum > 59) {
                i -= 1;
                continue;
            }
            //Формирование пароля.
            password += Symbols.charAt(randomnum);
        }
        return password; //Возвращение переменной password как готовый пароль.
    }
}
