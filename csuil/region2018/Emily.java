package region2018;

import java.util.*;
import java.io.*;

public class Emily {
    public static void main(String [] args) throws IOException{
        Scanner input = new Scanner(new File("emily.dat"));
        int n = input.nextInt();
        input.nextLine();
        String [][] nums = new String[n][n];
        for (int i = 0; i < n; i++){
            for (int j  = 0; j < n; j++){
                nums[i][j] = "" + input.nextInt();
            }
        }

        while(input.hasNextInt()){
            String check = "" + input.nextInt();
            System.out.println("<" + check + ">");
            boolean found = false;

            //N
            for (int r = 0; r < n; r++){
                for (int c = 0; c < n; c++){
                    boolean same = true;
                    for (int i = 0; i < check.length(); i++){
                        String currentCheck = check.substring(i, i + 1);
                        int row = r - i;
                        if (row < 0){
                            row += n;
                        }
                        if (!nums[row][c].equals(currentCheck)){
                            same = false;
                            break;
                        }
                    }
                    if (same){
                        found = true;
                        System.out.println("(" + (r + 1) + "," + (c + 1) + ") N");
                    }
                }
            }

            // NE
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    boolean same = true;
                    for (int i = 0; i < check.length(); i++) {
                        String currentCheck = check.substring(i, i + 1);
                        int row = r - i;
                        int col = c + i;
                        if (row < 0) {
                            row += n;
                        }
                        if (col >= n) {
                            col -= n;
                        }
                        if (!nums[row][col].equals(currentCheck)) {
                            same = false;
                            break;
                        }
                    }
                    if (same) {
                        found = true;
                        System.out.println("(" + (r + 1) + "," + (c + 1) + ") NE");
                    }
                }
            }

            //E
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    boolean same = true;
                    for (int i = 0; i < check.length(); i++) {
                        String currentCheck = check.substring(i, i + 1);
                        int col = c + i;
                        if (col >= n) {
                            col -= n;
                        }
                        if (!nums[r][col].equals(currentCheck)) {
                            same = false;
                            break;
                        }
                    }
                    if (same) {
                        found = true;
                        System.out.println("(" + (r + 1) + "," + (c + 1) + ") E");
                    }
                }
            }

            // SE
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    boolean same = true;
                    for (int i = 0; i < check.length(); i++) {
                        String currentCheck = check.substring(i, i + 1);
                        int row = r + i;
                        int col = c + i;
                        if (row >= n) {
                            row -= n;
                        }
                        if (col >= n) {
                            col -= n;
                        }
                        if (!nums[row][col].equals(currentCheck)) {
                            same = false;
                            break;
                        }
                    }
                    if (same) {
                        found = true;
                        System.out.println("(" + (r + 1) + "," + (c + 1) + ") SE");
                    }
                }
            }

            //S
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    boolean same = true;
                    for (int i = 0; i < check.length(); i++) {
                        String currentCheck = check.substring(i, i + 1);
                        int row = r + i;
                        if (row >= n) {
                            row -= n;
                        }
                        if (!nums[row][c].equals(currentCheck)) {
                            same = false;
                            break;
                        }
                    }
                    if (same) {
                        found = true;
                        System.out.println("(" + (r + 1) + "," + (c + 1) + ") S");
                    }
                }
            }

            // SW
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    boolean same = true;
                    for (int i = 0; i < check.length(); i++) {
                        String currentCheck = check.substring(i, i + 1);
                        int row = r + i;
                        int col = c - i;
                        if (row >= n) {
                            row -= n;
                        }
                        if (col < 0) {
                            col += n;
                        }
                        if (!nums[row][col].equals(currentCheck)) {
                            same = false;
                            break;
                        }
                    }
                    if (same) {
                        found = true;
                        System.out.println("(" + (r + 1) + "," + (c + 1) + ") SW");
                    }
                }
            }

            // W
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    boolean same = true;
                    for (int i = 0; i < check.length(); i++) {
                        String currentCheck = check.substring(i, i + 1);
                        int col = c - i;
                        if (col < 0) {
                            col += n;
                        }
                        if (!nums[r][col].equals(currentCheck)) {
                            same = false;
                            break;
                        }
                    }
                    if (same) {
                        found = true;
                        System.out.println("(" + (r + 1) + "," + (c + 1) + ") W");
                    }
                }
            }

            // NW
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    boolean same = true;
                    for (int i = 0; i < check.length(); i++) {
                        String currentCheck = check.substring(i, i + 1);
                        int row = r - i;
                        int col = c - i;
                        if (row < 0) {
                            row += n;
                        }
                        if (col < 0) {
                            col += n;
                        }
                        if (!nums[row][col].equals(currentCheck)) {
                            same = false;
                            break;
                        }
                    }
                    if (same) {
                        found = true;
                        System.out.println("(" + (r + 1) + "," + (c + 1) + ") NW");
                    }
                }
            }




            if (!found) {
                System.out.println("NOT FOUND");
            }
        }
    }
}
