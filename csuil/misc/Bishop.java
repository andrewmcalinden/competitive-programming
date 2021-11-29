package misc;

import java.util.*;
import java.io.*;

class Bishop {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("misc/bishop.dat"));
        int runs = input.nextInt();
        input.nextLine();
        for (int run = 1; run <= runs; run++) {
            int n = input.nextInt();
            int m = input.nextInt();
            int k = input.nextInt();
            boolean [][] board = new boolean[n][m];
            //boolean[][] danger = new boolean[n][m];
            for (int i = 0; i < k; i++)
            {
                int r = input.nextInt();
                int c = input.nextInt();
                board[r][c] = true;
                //danger[r][c] = true;
            }

            boolean[] diag1 = new boolean[n + m - 1];
            boolean [] diag2 = new boolean[n + m];
            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++){
                    if (board[i][j]){
                        diag1[i + j] = true;
                        diag2[i - j + m] = true;
                    }
                }
            }

            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (diag1[i + j] || diag2[i - j + m] || board[i][j]){
                        //do nothing
                    }
                    else{
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}