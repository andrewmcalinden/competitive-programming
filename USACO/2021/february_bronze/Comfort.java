import java.util.*;
import java.io.*;

public class Comfort {
    static boolean[][] grid = new boolean[1001][1001];

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int x = s.nextInt();
            int y = s.nextInt();

            int numBefore = 0;
            if (x + 1 < 1001 && isComfort(x + 1, y) && grid[x + 1][y]) {
                numBefore++;
            }
            if (x - 1 >= 0 && isComfort(x - 1, y) && grid[x - 1][y]) {
                numBefore++;
            }
            if (y + 1 < 1001 && isComfort(x, y + 1) && grid[x][y + 1]) {
                numBefore++;
            }
            if (y - 1 >= 0 && isComfort(x, y - 1) && grid[x][y - 1]) {
                numBefore++;
            }

            grid[x][y] = true;

            int numAfter = 0;
            if (x + 1 < 1001 && isComfort(x + 1, y) && grid[x + 1][y]) {
                numAfter++;
            }
            if (x - 1 >= 0 && isComfort(x - 1, y) && grid[x - 1][y]) {
                numAfter++;
            }
            if (y + 1 < 1001 && isComfort(x, y + 1) && grid[x][y + 1]) {
                numAfter++;
            }
            if (y - 1 >= 0 && isComfort(x, y - 1) && grid[x][y - 1]) {
                numAfter++;
            }
            if (isComfort(x, y)) {
                numAfter++;
            }

            ans += (numAfter - numBefore);
            System.out.println(ans);
        }
    }

    static boolean isComfort(int r, int c) {
        int num = 0;
        if (r > 0 && grid[r - 1][c]) {
            num++;
        }
        if (r < 1000 && grid[r + 1][c]) {
            num++;
        }
        if (c > 0 && grid[r][c - 1]) {
            num++;
        }
        if (c < 1000 && grid[r][c + 1]) {
            num++;
        }
        return num == 3;
    }
}
