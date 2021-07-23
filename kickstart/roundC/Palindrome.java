package roundC;

import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Palindrome {
    static int mod = (int) (Math.pow(10, 9) + 7);

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        for (int run = 1; run <= t; run++) {
            int n = input.nextInt();
            int k = input.nextInt();
            String s = input.next();
            long ans = 0;
            int realLen = (int) (Math.ceil(n / 2.0));

            int index = 0;
            while (index < realLen) {
                int numLess = Math.min(s.charAt(index) - 'a', k);
                int letsRemaining = realLen - index - 1;

                BigInteger base = new BigInteger("" + k);
                BigInteger exp = new BigInteger("" + letsRemaining);
                BigInteger result = base.modPow(exp, new BigInteger("" + mod));
                result = result.multiply(new BigInteger("" + numLess));
                ans = (ans + result.longValue()) % mod;
                index++;
            }

            String pal = s.substring(0, realLen);
            if (n % 2 == 0){
                boolean another = false;
                for (int i = 0; i < pal.length(); i++){
                    char me = pal.charAt(pal.length() - i - 1);
                    char other = s.charAt(i + pal.length());
                    if (me < other){
                        another = true;
                        break;
                    }
                    if(me > other){
                        break;
                    }
                }
                if (another){
                    ans++;
                    ans %= mod;
                }
            }
            else if (n != 1){
                boolean another = false;
                for (int i = 0; i < pal.length() - 1; i++) {
                    char me = pal.charAt(pal.length() - i - 2);
                    char other = s.charAt(i + pal.length());
                    if (me < other) {
                        another = true;
                        break;
                    }
                    if (me > other) {
                        break;
                    }
                }
                if (another) {
                    ans++;
                    ans %= mod;
                }
            }
            System.out.println("Case #" + run + ": " + ans);
        }
    }
}
