package region2019;

import java.io.*;
import java.util.*;

public class Kavya {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("kavya.dat"));
        //int runs = input.nextInt();
        //input.nextLine();
        while(input.hasNextLine()){
            String line = input.nextLine().toUpperCase();
            HashMap<Character, Integer> frq = new HashMap<>();
            for (char c : line.toCharArray()){
                if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)){
                    if (c >= 97) {
                        c -= 32;
                    }

                    if (!frq.containsKey(c)){
                        frq.put(c, 1);
                    }
                    else{
                        frq.put(c, frq.get(c) + 1);
                    }
                }
            }

            String s = "";
            while(frq.size() > 0){
                char k = 'a';
                int max = 0;
                for (char key : frq.keySet()){
                    if (frq.get(key) == max){
                        if (line.indexOf("" + key) < line.indexOf("" + k)){
                            k = key;
                        }
                    }
                    if (frq.get(key) > max){
                        max = frq.get(key);
                        k = key;
                    }
                }

                for (int i = 0; i < max; i++){
                    s += "" + k;
                }

                frq.remove(k);
            }
            System.out.println(s);
        }
    }
}
