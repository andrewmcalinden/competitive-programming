package district2021;

import java.util.*;
import java.io.*;

class Harish {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("harish.dat"));
        int runs = input.nextInt();
        input.nextLine();
        for (int run = 1; run <= runs; run++) {
            boolean[][] archers = new boolean[5][5];
            for (int lineCount = 0; lineCount < 5; lineCount++) {
                String line = input.nextLine();
                for (int i = 0; i < 5; i++) {
                    if (line.charAt(i) == 'a') {
                        archers[lineCount][i] = true;
                    }
                }
            }

            boolean printed = false;
            int count = 0;
            outer: for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (archers[i][j] == true) {
                        count++;
                        if (i + 2 < 5 && j + 2 < 5 && archers[i + 2][j + 2] == true) {
                            System.out.println("invalid");
                            printed = true;
                            break outer;
                        }
                        if (i - 2 >= 0 && j + 2 < 5 && archers[i - 2][j + 2] == true) {
                            System.out.println("invalid");
                            printed = true;
                            break outer;
                        }
                        if (i + 2 < 5 && j - 2 >= 0 && archers[i + 2][j - 2] == true) {
                            System.out.println("invalid");
                            printed = true;
                            break outer;
                        }
                        if (i - 2 >= 0 && j - 2 >= 0 && archers[i - 2][j - 2] == true) {
                            System.out.println("invalid");
                            printed = true;
                            break outer;
                        }
                    }
                }
            }

            if (!printed) {
                if (count == 9) {
                    System.out.println("valid");
                } else {
                    System.out.println("invalid");
                }

            }
            input.nextLine();
        }
    }
}