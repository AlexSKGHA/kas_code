package applications;

import kascode.Time;
import java.util.Random;
import java.util.Scanner;

public class PMAM {

    public void start() {
        Scanner scanner = new Scanner(System.in);
        String[] time;
        String answer;

        while (true) {
            time = generateTime(new Random());
            System.out.print(time[0] +" is ");
            answer = scanner.next();

            if (answer.equals("out")) {break;}

            if ((answer.equals(time[1])) || (answer.equals(time[2]))) {
                System.out.println("You're right!");
            } else {
                System.out.println("Wrong... The answer is " + time[2]);
            }
        }
    }

    public String[] generateTime (Random random) {
        String[] timeStr = new String[4];
        byte hours = (byte) random.nextInt(24);
        byte minutes = (byte) random.nextInt(60);
        Time time = new Time(hours, minutes);
        timeStr[0] = time.getHour12(true) + ":" +
                time.getMinutes(true) + " " + time.getPeriod();
        timeStr[1] = time.getHour(false) + ":" + time.getMinutes(true);
        timeStr[2] = time.getHour(true) + ":" + time.getMinutes(true);
        return timeStr;
    }
}
