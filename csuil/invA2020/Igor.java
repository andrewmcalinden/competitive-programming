package invA2020;

import java.util.*;
import java.io.*;

public class Igor {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("igor.dat"));
        int runs = input.nextInt();
        input.nextLine();

        for (int run = 1; run <= runs; run++) {
            String s = input.next();

            HashMap<String, Integer> frq = new HashMap<>();
            for (int i = 0; i < s.length(); i++){
                String current = "" + s.charAt(i);
                if (frq.containsKey(current)){
                    frq.put(current, frq.get(current) + 1);
                }
                else{
                    frq.put(current, 1);
                }
            }

            int len = 0;
            int leftOvers = 0;
            for (String key : frq.keySet()){
                int num = frq.get(key);

                if (num % 2 == 0){
                    len++;
                }
                else{
                    len += (num - 1);
                    leftOvers++;
                }
            }

            int score = len * len + leftOvers;
            System.out.println(score);


        }
    }
}
