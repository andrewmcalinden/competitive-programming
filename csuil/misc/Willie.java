package misc;

import java.util.*;
import java.util.function.IntPredicate;
import java.io.*;

class Willie {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("misc/willie.dat"));
        int runs = input.nextInt();
        input.nextLine();
        for (int run = 1; run <= runs; run++) {
            int n = input.nextInt();
            boolean[][] board = new boolean[n][n];
            input.nextLine();
            input.nextLine();
            for (int i = 0; i < n; i++) {
                String line = input.nextLine();
                Scanner lineScan = new Scanner(line);
                int col = -1;
                while (lineScan.hasNext()) {
                    if (lineScan.next().equals("Q")) {
                        board[i][col] = true;
                    }
                    else{
                        col++;
                    }
                }
                input.nextLine();
            }
            input.nextLine();

            boolean works = true;

            int count = 0;
            boolean[] rowsUsed = new boolean[n];
            boolean[] columnsUsed = new boolean[n];
            boolean[] diag1 = new boolean[n * 2];
            boolean[] diag2 = new boolean[n * 2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j]){
                        if (rowsUsed[i])
                            works = false;
                        rowsUsed[i] = true;
                        if (columnsUsed[j])
                            works = false;
                        columnsUsed[j] = true;
                        if (diag1[i + j])
                            works = false;
                        diag1[i + j] = true;
                        if (diag2[i + n - 1 - j])
                            works = false;
                        diag2[i + n - 1 - j] = true;
                        count++;
                    }
                }
            }
            if (count != n) {
                works = false;
            }
            if (works){
                System.out.println("valid solution");
            }
            else{
                System.out.println("incorrect attempt");
            }
        }
    }
}