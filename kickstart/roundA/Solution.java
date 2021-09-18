import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int run = 1; run <= t; run++) {
            int n = input.nextInt();

            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = input.nextInt();
                }
            }

            int[][] b = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    b[i][j] = input.nextInt();
                }
            }

            int[] rCheck = new int[n];
            for (int i = 0; i < n; i++) {
                rCheck[i] = input.nextInt();
            }

            int[] cCheck = new int[n];
            for (int i = 0; i < n; i++) {
                cCheck[i] = input.nextInt();
            }

            ArrayList<Integer>[] numUnknownRow = new ArrayList[n];
            ArrayList<Integer>[] numUnknownCol = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                numUnknownRow[i] = new ArrayList<Integer>();
                numUnknownCol[i] = new ArrayList<Integer>();
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (a[i][j] == -1) {
                        numUnknownRow[i].add(j);
                        numUnknownCol[j].add(i);
                    }
                }
            }

            int totalUnknown = 0;
            for (int i = 0; i < n; i++) {
                if (numUnknownRow[i].size() == 1) {
                    int c = numUnknownRow[i].get(0);
                    a[i][c] = 1;
                    numUnknownRow[i].remove(0);
                }
                if (numUnknownCol[i].size() == 1) {
                    int r = numUnknownCol[i].get(0);
                    a[r][i] = 1;
                    numUnknownCol[i].remove(0);
                }
                totalUnknown += numUnknownRow[i].size();
            }

            int ans = 0;
            while (totalUnknown > 0) {
                int min = Integer.MAX_VALUE;
                int row = -1;
                int col = -1;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (b[i][j] < min && a[i][j] == -1) {
                            min = b[i][j];
                            row = i;
                            col = j;
                        }
                    }
                }
                //System.out.println(min);
                ans += min;
                a[row][col] = 1; // uncover it
                numUnknownRow[row].remove(Integer.valueOf(col));
                numUnknownCol[col].remove(Integer.valueOf(row));

                // System.out.println(Arrays.toString(numUnknownRow));
                // System.out.println(Arrays.toString(numUnknownCol));

                boolean changed = false;
                do{
                    totalUnknown = 0;
                    changed = false;
                    for (int i = 0; i < n; i++) {
                        if (numUnknownRow[i].size() == 1) {
                            int c = numUnknownRow[i].get(0);
                            a[i][c] = 1;
                            numUnknownRow[i].remove(0);
                            numUnknownCol[c].remove(Integer.valueOf(i));
                            changed = true;
                        }
                        if (numUnknownCol[i].size() == 1) {
                            int r = numUnknownCol[i].get(0);
                            a[r][i] = 1;
                            numUnknownCol[i].remove(0);
                            numUnknownRow[r].remove(Integer.valueOf(i));
                            changed = true;
                        }
                        totalUnknown += numUnknownRow[i].size();
                    }
                } while(changed);
                // System.out.println(Arrays.toString(numUnknownRow));
                // System.out.println(Arrays.toString(numUnknownCol));
                // System.out.println("unknown: " + totalUnknown);
                // for (int [] y : a){
                //     System.out.println(Arrays.toString(y));
                // }
                
            }
            System.out.println("Case #" + run + ": " + ans);
        }
    }
}
