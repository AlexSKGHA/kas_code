import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Arrangement {

    public static void mix (String[] arr, Random random) {

        int arrLength = arr.length;

        int[] randomIndex = new int[arrLength];

        for (int i = 0; i < arrLength; i++) {
            randomIndex[i] = random.nextInt(arrLength);
        }

        for (int i = 0; i < arrLength; i++) {
            String elem1 = arr[i];
            String elem2 = arr[randomIndex[i]];
            arr[i] = elem2;
            arr[randomIndex[i]] = elem1;
        }
    }
}
