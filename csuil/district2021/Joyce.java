package district2021;

import java.util.*;
import java.io.*;

class Joyce {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("joyce.dat"));
        int runs = input.nextInt();
        input.nextLine();
        for (int run = 1; run <= runs; run++) {
            String line = input.nextLine().toLowerCase();
            HashSet<Character> letters = new HashSet<>();
            boolean perfect = true;
            for (char c : line.toCharArray()){
                if ('a' <= c && c <= 'z'){
                    if (letters.contains(c)){
                        perfect = false;
                    }
                    letters.add(c);
                }
            }
            if (letters.size() == 26){
                if (perfect){
                    System.out.println("perfect panagram");
                }
                else{
                    System.out.println("panagram");
                }
            }
            else{
                String missing = "";
                for (char c = 'a'; c <= 'z'; c++){
                    if (!letters.contains(c)){
                        missing += c;
                    }
                }
                System.out.println("missing " + missing);
            }
        }
    }
}