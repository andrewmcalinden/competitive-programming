import java.util.*;
import java.io.*;

public class Lshaped {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int run = 1; run <= t; run++) {
            int rows = input.nextInt();
            int cols = input.nextInt();

            int[][] grid = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    grid[i][j] = input.nextInt();
                }
            }

            int ans = 0;
            for (int r = 0; r < rows; r++) {
                int curLength = -1;
                int start = -1;
                boolean good = false;
                for (int c = 0; c < cols; c++) {
                    if (grid[r][c] == 1) {
                        if (good) {
                            curLength++;
                        } else {
                            curLength = 1;
                            start = c;
                            good = true;
                        }
                    }
                    if (grid[r][c] != 1 || (c == cols - 1 && good)) {
                        if (curLength >= 2) {
                            int end = c - 1; // value of c - 1 is end of a good segment
                            if (grid[r][c] == 1) { // went into this loop because we were at end of row
                                end = c;
                            }

                            int[][] upDown = new int[2][curLength];
                            for (int i = start; i <= end; i++) {
                                int row = r - 1;
                                int len = 1;
                                while (row >= 0 && row < rows && grid[row][i] == 1) {
                                    row--;
                                    len++;
                                }
                                upDown[0][i - start] = len;

                                row = r + 1;
                                len = 1;
                                while (row >= 0 && row < rows && grid[row][i] == 1) {
                                    row++;
                                    len++;
                                }
                                upDown[1][i - start] = len;
                            }
                            // System.out.println(Arrays.toString(upDown[0]));
                            // System.out.println(Arrays.toString(upDown[1]));
                            // System.out.println("row: " + r + "\tstart: " + start + "\tend: " + end);
                            for (int startCol = start; startCol < end; startCol++) {
                                for (int endCol = startCol + 1; endCol <= end; endCol++) {
                                    int base = endCol - startCol + 1;
                                    if (base < 2) {
                                        continue;
                                    }
                                    int height1 = base * 2;
                                    int height2 = Integer.MAX_VALUE;

                                    if (base % 2 == 0 && base / 2 >= 2) { // this might be the longer segment
                                        height2 = base / 2;
                                    }

                                    int upLeft = upDown[0][startCol - start];
                                    int upRight = upDown[0][endCol - start];

                                    int downLeft = upDown[1][startCol - start];
                                    int downRight = upDown[1][endCol - start];

                                    if (upLeft >= height1) {
                                        ans++;
                                        // System.out.println("upleft, row = " + r + " col = " + startCol + " " +
                                        // endCol);
                                    }
                                    if (upLeft >= height2) {
                                        ans++;
                                    }
                                    if (upRight >= height1) {
                                        ans++;
                                        // System.out.println("upleft, row = " + r + " col = " + startCol + " " +
                                        // endCol);
                                    }
                                    if (upRight >= height2) {
                                        ans++;
                                    }
                                    if (downLeft >= height1) {
                                        ans++;
                                        // System.out.println("upleft, row = " + r + " col = " + startCol + " " +
                                        // endCol);
                                    }
                                    if (downLeft >= height2) {
                                        ans++;
                                    }
                                    if (downRight >= height1) {
                                        ans++;
                                        // System.out.println("upleft, row = " + r + " col = " + startCol + " " +
                                        // endCol);
                                    }
                                    if (downRight >= height2) {
                                        ans++;
                                    }
                                }
                            }
                        }
                        good = false;
                        curLength = -1;
                    }
                }
            }
            System.out.println("Case #" + run + ": " + ans);
        }
    }
}
