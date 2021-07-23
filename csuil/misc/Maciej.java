package misc;

import java.util.*;
import java.io.*;

public class Maciej {
    public static void main(String [] args) throws FileNotFoundException{
        Scanner input = new Scanner(new File("maciej.dat"));

        int t = input.nextInt();
        for (int test = 1; test <= t; test++){
            String num1 = input.next();
            String num2 = input.next();

            int r1 = Integer.parseInt(num1.substring(1, 3), 16);
            int g1 = Integer.parseInt(num1.substring(3, 5), 16);
            int b1 = Integer.parseInt(num1.substring(5, 7), 16);

            int r2 = Integer.parseInt(num2.substring(1, 3), 16);
            int g2 = Integer.parseInt(num2.substring(3, 5), 16);
            int b2 = Integer.parseInt(num2.substring(5, 7), 16);

            int rAvg = (r1 + r2) / 2;
            int gAvg = (g1 + g2) / 2;
            int bAvg = (b1 + b2) / 2;

            String ans = Integer.toString(rAvg, 16) + Integer.toString(gAvg, 16) + Integer.toString(bAvg, 16);
            System.out.println("Case #" + test + ": #" + ans.toUpperCase());
        }
    }
}