public class ByteConverter {
    public static String[] byteStringArr(String[] stringArr) {
        int sizeArr = stringArr.length;
        String[] returnArr = new String[sizeArr];
        for (int i = 0; i < sizeArr; i++) {
            returnArr[i] = getByteLine(stringArr[i]);
        }
        return returnArr;
    }
    public static String[] stringArr(String[] byteStirngArr) {
        int sizeArr = byteStirngArr.length;
        String[] returnArr = new String[sizeArr];
        for (int i = 0; i < sizeArr; i++) {
            returnArr[i] = getStringLine(byteStirngArr[i]);
        }
        return returnArr;
    }
    private static String getByteLine(String str) {
        byte[] preArr = str.getBytes();
        int sizePreArr = preArr.length;
        String returnString = "";
        for (int i = 0; i < sizePreArr; i++) {
            returnString += preArr[i] + " ";
        }
        returnString = returnString.substring(0, returnString.length() - 1);
        return returnString;
    }
    private static String getStringLine(String byteStringLine) {
        String preparedLine = "space " + byteStringLine;
        String[] args = StringParser.getArguments(preparedLine);
        byte[] byteArr = new byte[args.length];
        for (int i = 0; i < args.length; i++) {
            byteArr[i] = (byte) Integer.parseInt(args[i]);
        }
        String returnLine = new String(byteArr);
        return returnLine;
    }
}
