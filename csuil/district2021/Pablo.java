package district2021;

import java.util.*;
import java.io.*;

class Pablo {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("pablo.dat"));
        int runs = input.nextInt();
        input.nextLine();
        for (int run = 1; run <= runs; run++) {
            double lat1Orig = input.nextDouble();
            double long1Orig = input.nextDouble();
            double lat2Orig = input.nextDouble();
            double long2Orig = input.nextDouble();

            double lat1 = lat1Orig * (Math.PI / 180.0);
            double long1 = long1Orig * (Math.PI / 180.0);
            double lat2 = lat2Orig * (Math.PI / 180.0);
            double long2 = long2Orig * (Math.PI / 180.0);

            double deltaSigma = lat1 - lat2;
            double deltaLamda = long1 - long2;

            double a = 
            Math.pow(Math.sin(deltaSigma / 2.0), 2) +
            Math.cos(lat1) * Math.cos(lat2) * 
            Math.pow(Math.sin(deltaLamda / 2.0), 2);

            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

            double distance = 6371000 * c;

            String coord1 = "(" + String.format("%.5f", lat1Orig) + ", " + String.format("%.5f", long1Orig) + ")";
            String coord2 = "(" + String.format("%.5f", lat2Orig) + ", " + String.format("%.5f", long2Orig) + ")";

            long dist = Math.round(distance);

            System.out.println("The distance between " + coord1 + " and " + coord2 + " is " + dist + " meters.");
        }
    }
}