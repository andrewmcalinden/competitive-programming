package region2019;

import java.io.*;
import java.util.*;

public class Lucie {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("lucie.dat"));
        int runs = input.nextInt();
        input.nextLine();
        for (int run = 1; run <= runs; run++) {
            Scanner line = new Scanner(input.nextLine());
            line.useDelimiter(",");
            int programs = line.nextInt();
            int teams = line.nextInt();
            int[][] scores = new int[programs][teams];
            for (int i = 0; i < programs; i++) {
                Scanner currentLine = new Scanner(input.nextLine());
                currentLine.useDelimiter(",");
                for (int j = 0; j < teams; j++) {
                    int score = currentLine.nextInt();
                    scores[i][j] = score;
                }
            }

            int [][] flipped = new int[teams + 1][programs + 1];
            for (int i = 0; i < teams; i++){
                for (int j = 0; j < programs; j++){
                    flipped[i][j] = scores[j][i];
                }
            }

            for(int i = 0; i < teams; i++){
                for (int j = 0; j < programs; j++){
                    flipped[i][programs] += flipped[i][j];
                    flipped[teams][j] += flipped[i][j];
                }
            }

            for (int row = 0; row < teams; row++){
                int [] current = flipped[row];
                for (int i = 0; i < current.length - 1; i++){
                    System.out.print(current[i] + ",");
                }
                System.out.println(current[current.length - 1]);
            }

            for (int i = 0; i < programs - 1; i++){
                System.out.print(flipped[teams][i] + ",");
            }
            System.out.println(flipped[teams][programs - 1]);
            System.out.println("************");
        }
    }
}
