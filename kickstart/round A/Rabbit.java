import java.util.*;
import java.io.*;

public class Rabbit {
    static long ans;
    static int[][] grid;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int run = 1; run <= t; run++) {
            int rows = input.nextInt();
            int cols = input.nextInt();
            grid = new int[rows][cols];
            ans = 0;

            PriorityQueue<Square> q = new PriorityQueue<>();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    grid[i][j] = input.nextInt();
                    q.add(new Square(i, j, grid[i][j]));
                }
            }

            while (!q.isEmpty()) {
                // System.out.println(q.size());
                Square max = q.remove();
                int r = max.row;
                int c = max.col;
                int centerVal = max.val;
                if (centerVal != grid[r][c]) {
                    continue;
                }

                if (!(r - 1 >= grid.length || r - 1 < 0 || c >= grid[r - 1].length || c < 0
                        || Math.abs(grid[r - 1][c] - centerVal) <= 1)) {
                    int topVal = grid[r - 1][c];
                    grid[r - 1][c] = centerVal - 1;
                    ans += Math.abs(topVal - grid[r - 1][c]);
                    // q.remove(new Square(r - 1, c, topVal));
                    q.add(new Square(r - 1, c, grid[r - 1][c]));
                }
                if (!(r + 1 >= grid.length || r + 1 < 0 || c >= grid[r + 1].length || c < 0
                        || Math.abs(grid[r + 1][c] - centerVal) <= 1)) {
                    int bottomVal = grid[r + 1][c];
                    grid[r + 1][c] = centerVal - 1;
                    ans += Math.abs(bottomVal - grid[r + 1][c]);
                    // q.remove(new Square(r + 1, c, bottomVal));
                    q.add(new Square(r + 1, c, grid[r + 1][c]));
                }
                if (!(r >= grid.length || r < 0 || c + 1 >= grid[r].length || c + 1 < 0
                        || Math.abs(grid[r][c + 1] - centerVal) <= 1)) {
                    int rightVal = grid[r][c + 1];
                    grid[r][c + 1] = centerVal - 1;
                    ans += Math.abs(rightVal - grid[r][c + 1]);
                    // q.remove(new Square(r, c + 1, rightVal));
                    q.add(new Square(r, c + 1, grid[r][c + 1]));
                }
                if (!(r >= grid.length || r < 0 || c - 1 >= grid[r].length || c - 1 < 0
                        || Math.abs(grid[r][c - 1] - centerVal) <= 1)) {
                    int leftVal = grid[r][c - 1];
                    grid[r][c - 1] = centerVal - 1;
                    ans += Math.abs(leftVal - grid[r][c - 1]);
                    // q.remove(new Square(r, c - 1, leftVal));
                    q.add(new Square(r, c - 1, grid[r][c - 1]));
                }
                // for (int[] y : grid) {
                // System.out.println(Arrays.toString(y));
                // }
            }

            System.out.println("Case #" + run + ": " + ans);
            // for (int [] y : grid){
            // System.out.println(Arrays.toString(y));
            // }
        }
    }

    private static class Square implements Comparable<Square> {
        public int row;
        public int col;
        public int val;

        public Square(int y, int x, int v) {
            row = y;
            col = x;
            val = v;
        }

        public int compareTo(Square other) {
            return other.val - val;
        }

        public boolean equals(Object other) {
            Square s = (Square) other;
            return this.row == s.row && this.col == s.col && this.val == s.val;
        }
    }
}
