package misc;

import java.util.*;

public class Teresa {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        for (int loop = 1; loop <= t; loop++){
            int r = input.nextInt();
            int c = input.nextInt();

            int [][] matrix = new int [r][c];
            for (int i = 0; i < r; i++){
                for (int j = 0; j < c; j++){
                    matrix[i][j] = input.nextInt();
                }
            }

            int [][] step1 = flipMatrix(matrix);
            for (int [] row : step1){
                Arrays.sort(row);
            }

            int[][] step2 = flipMatrix(step1);
            for (int[] row : step2) {
                Arrays.sort(row);
            }


            System.out.println(loop + ":");
            for (int [] row : step2){
                for (int el : row){
                    System.out.print(el + "\t");
                }
                System.out.println();
            }
            System.out.println("++++++++++++");
        }
        input.close();

    }

    public static int[][] flipMatrix(int [][] matrix){
        int [][] ans = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                ans[i][j] = matrix[j][i];
            }
        }
        return ans;
    }
}
