package misc;
import java.util.*;
import java.io.*;

public class Diya {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(new File("diya.dat"));
        while (s.hasNextInt()) {
            int dim = s.nextInt();
            int[][] grid = new int[dim][dim];
            int num = 0;

            int r = 0;
            int c = 0;

            int stopRight = dim - 1;
            int stopBottom = dim - 1;
            int stopLeft = 0;
            int stopTop = 1;

            while ((stopRight > stopLeft) || (stopTop < stopBottom)) {
                while (c <= stopRight) {
                    grid[r][c] = ++num;
                    c++;
                }
                stopRight--;
                c--;
                num--;

                while (r <= stopBottom) {
                    grid[r][c] = ++num;
                    r++;
                }
                stopBottom--;
                r--;
                num--;

                while (c >= stopLeft) {
                    grid[r][c] = ++num;
                    c--;
                }
                stopLeft++;
                c++;
                num--;

                while (r >= stopTop) {
                    grid[r][c] = ++num;
                    r--;
                }
                r++;
                stopTop++;
                num--;

                // System.out.println("ran");
            }

            if (dim % 2 == 1) {
                grid[dim / 2][dim / 2] = num + 2;
            }

            int longestNum = (dim * dim + "").length() + 1;
            System.out.println(longestNum);

            for (int[] ray : grid) {
                for (int el : ray) {
                    System.out.printf("%-" + longestNum + "d", el);
                }
                System.out.println();
            }
            System.out.println("=====");
        }
    }
}
