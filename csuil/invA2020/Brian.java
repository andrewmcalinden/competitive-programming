package invA2020;

import java.util.*;
import java.io.*;

public class Brian {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("brian.dat"));
        int runs = input.nextInt();
        input.nextLine();

        for (int run = 1; run <= runs; run++) {
            int currentYear = input.nextInt();
            int yearDiff = currentYear - 1995;

            int javaEdition = yearDiff / 2;
            System.out.println("In the year " + currentYear + ", Brian will be coding in Java " + javaEdition + "!");
        }
    }
}
