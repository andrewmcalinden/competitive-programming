import java.util.*;
import java.io.*;

public class Alien {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int run = 1; run <= t; run++) {
            long g = input.nextLong();
            long ans = 0;

            for (long k = 1; k <= g; k++) {
                ans += numWork(k, g);
            }
            System.out.println("Case #" + run + ": " + ans);
        }
    }

    public static int numWork(long k, long g) {
        double a = 1;
        double b = 2 * k - 1;
        double c = -2 * g;
        int ans = 0;
        double ans1 = (-b + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
        if (ans1 % 1 == 0 && ans1 >= 0) {
            ans++;
        }

        double ans2 = (-b - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
        if (ans2 % 1 == 0 && ans2 >= 0) {
            ans++;
        }
        return ans;
    }

    // public static long totalProduced(long k, long g){
    //     double a = 1;
    //     double b = 2 * k - 1;
    //     double c = -2 * g;
    //     double ans1 = (-b + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
    //     if (ans1 >= 0) { //positive solution
    //         double realDays = Math.floor(ans1);
    //         double produced = (k * realDays) + (realDays) * (realDays - 1) / 2.0;
    //         return (long)produced;
    //     }

    //     double ans2 = (-b - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
    //     if (ans2 >= 0) { // positive solution
    //         double realDays = Math.floor(ans2);
    //         double produced = (k * realDays) + (realDays) * (realDays - 1) / 2.0;
    //         return (long) produced;
    //     }
    //     return -1;
    // }
}
