package district2021;

import java.util.*;
import java.io.*;
import java.math.*;

class Reka {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("district2021/reka.dat"));
        int runs = input.nextInt();
        input.nextLine();
        for (int run = 1; run <= runs; run++) {
            long length = input.nextLong();
            long clues = input.nextLong();

            HashMap<Long, Character> word = new HashMap<>();
            for (long i = 0; i < clues; i++) {
                long pos = input.nextLong() - 1;
                char let = input.next().charAt(0);
                word.put(pos, let);
            }

            boolean go = true;
            for (long i : word.keySet()) {
                long reflected = length - i - 1;
                if (!word.containsKey(reflected)) {
                    clues++;
                } else if (word.get(reflected) != word.get(i)) {
                    System.out.println("Case #" + run + ": " + 0);
                    go = false;
                    break;
                }
            }
            if (!go)
                continue;

            BigInteger count = new BigInteger("" + ((length - clues) / 2));

            BigInteger numWays = new BigInteger("26");
            numWays = numWays.modPow(new BigInteger("" +count), new BigInteger("" + 1000000000));

            if (length % 2 == 1 && !word.containsKey(length / 2)) {
                numWays = numWays.multiply(new BigInteger("26"));
            }
            String num = numWays.toString();
            if (num.length() > 9){
                num = num.substring(num.length() - 9);
            }
            else if(num.length() == 8 && Integer.parseInt(count.toString()) >= 7){
                num = "0" + num;
            }
            System.out.println("Case #" + run + ": " + num);
        }
    }
}