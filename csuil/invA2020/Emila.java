package invA2020;

import java.util.*;
import java.io.*;

public class Emila {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        int runs = input.nextInt();
        input.nextLine();

        for (int run = 1; run <= runs; run++) {
            double hour = input.nextDouble();
            double minute = input.nextDouble();

            double hoursFrom3 = (hour / 30.0);

            int currentHour = 3 - (int)hoursFrom3;
            if (currentHour <= 0){
                currentHour += 11;
            }

            double minsFrom3 = (minute / 30.0); //in 5 minutes
            int currentMin = 15 - (int) minsFrom3;
            if (currentMin <= 0) {
                currentMin += 60;
            }

            System.out.println(currentHour + ":" + currentMin);
        }
    }
}
