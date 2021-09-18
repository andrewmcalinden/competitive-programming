import java.util.*;
import java.io.*;

public class Longest {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int run = 1; run <= t; run++) {
            int n = input.nextInt();
            int [] a = new int[n];
            for (int i = 0; i < n; i++){
                a[i] = input.nextInt();
            }

            HashMap<Integer, Integer> map = new HashMap<>();
            int lastD = Integer.MAX_VALUE;
            int count = 1;
            for (int i = 0; i < n - 1; i++){
                int val1 = a[i];
                int val2 = a[i + 1];
                int d = val2 - val1;
                if (d != lastD && i > 0){
                    map.put(lastD, count);
                    count = 1;
                }
                else{
                    count++;
                }
                lastD = d;
            }

            Set<Integer> keysBad = map.keySet();
            int [] keys = new int[keysBad.size()];
            keys = keysBad.toArray(keys);

            for (int i = 1; i < keys.length - 1; i++){
                int first = keys[i - 1];
                int mid = keys[i];
                int last = keys[i + 1];
                
                
            }
        }

        //d = difference between current term and next
        //map where key is d and val is how long d is repeated for
        //find longest sum of any 2 adjacent values
        //answer is that +1
    }
}
