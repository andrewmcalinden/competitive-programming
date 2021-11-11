import java.util.*;
import java.io.*;

public class Bayani {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("bayani.dat"));
        double sum = 0;
        while (s.hasNextDouble()) {
            double d = s.nextDouble();
            System.out.print(" ".repeat(8));
            System.out.printf("$%7.2f%n", d);
            sum += d;
        }
        System.out.printf("Total = $%7.2f%n", sum);
    }
}
