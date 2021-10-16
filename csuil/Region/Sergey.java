package region;

import java.util.*;
import java.io.*;

class Sergey {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("sergey.dat"));
        int runs = input.nextInt();
        input.nextLine();
        for (int run = 1; run <= runs; run++) {
            int l = input.nextInt();
            int d = input.nextInt();
            input.nextLine();

            char [][] orig = new char[l][l];
            for (int i = 0; i < l; i++){
                orig[i] = input.nextLine().toCharArray();
            }

            int numRotate = d / 90;
            char [][] rotated = orig;
            for (int i = 0; i < numRotate; i++){
                rotated = rotate90(rotated);
            }
            
            for (char [] c : rotated){
                for (int i = 0; i < c.length; i++){
                    System.out.print(c[i]);
                }
                System.out.println();
            }
            System.out.println("DONE");
        }
    }

    public static char [][] rotate90(char [][] orig){
        char [][] output = new char[orig.length][orig.length];
        for (int c = 0; c < orig.length; c++){
            for (int r = orig.length - 1; r >= 0; r--){
                char current = orig[r][c];
                output[c][(orig.length - r - 1)] = current;
            }
        }
        return output;
    }
}