package invA2020;

import java.util.*;
import java.io.*;

public class Jose {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("jose.dat"));

        HashMap<String, Integer> values = new HashMap<>();
        for (int i = 0; i < 23; i++) {
            String let = input.next();
            int val = input.nextInt();
            values.put(let, val);
        }

        System.out.println(values);

        input.nextLine();
        input.nextLine();

        HashMap<Integer, Integer> weights = new HashMap<>();
        for (int i = 0; i < 17; i++) {
            int pos = input.nextInt();
            int val = input.nextInt();
            weights.put(pos, val);
        }

        System.out.println(weights);

        input.nextLine();
        input.nextLine();

        int runs = input.nextInt();
        input.nextLine();
        for (int run = 1; run <= runs; run++) {
            int total = 0;
            String vin = input.next();
            // System.out.println(vin);
            for (int i = 1; i <= 17; i++) {
                if (i == 9)
                    continue;
                int weight = weights.get(i);
                char current = vin.charAt(i - 1);
                // System.out.println(current);
                int val = 0;
                if (current >= '0' && current <= '9') {
                    val = current - '0';
                } else {
                    val = values.get("" + current);
                }
                total += weight * val;
                // System.out.println(total);
            }

            int remainder = total % 11;
            String check = "X";
            if (remainder < 10) {
                check = "" + remainder;
            }

            String ans = vin.substring(0, 8) + check + vin.substring(9);
            System.out.println(ans);
        }
    }
}
