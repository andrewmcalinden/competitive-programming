import java.util.*;
import java.io.*;

public class Kgoodness {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int run = 1; run <= t; run++) {
            int n = input.nextInt();
            int k = input.nextInt();
            String s = input.next();

            int good = 0;
            for (int i = 0; i < n / 2; i++) {
                if (s.charAt(i) != s.charAt(n - i - 1)) {
                    good++;
                }
            }
            int ans = Math.abs(good - k);
            System.out.println("Case #" + run + ": " + ans);
        }

    }
}
