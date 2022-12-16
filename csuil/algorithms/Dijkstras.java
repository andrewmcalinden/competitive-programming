package algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Dijkstras {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int [][] matrix = new int[n+1][n+1];
        for(int i = 0; i <= n; i++){
            Arrays.fill(matrix[i], Integer.MAX_VALUE);
        }

        for(int i = 0; i < m; i++){
            int c1 = in.nextInt();
            int c2 = in.nextInt();
            int weight = in.nextInt();
            matrix[c1][c2] = Math.min(matrix[c1][c2], weight);
        }

        nSquared(matrix, n, 1);
    }

    //uses adjacency matrix, no priority queue. no previous array
    public static void nSquared(int [][] matrix, int n, int s){
        int[] shortest = new int[n + 1];
        HashSet<Integer> unvisited = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            shortest[i] = matrix[s][i];
            unvisited.add(i);
        }

        while (!unvisited.isEmpty()) {
            int min = Integer.MAX_VALUE;
            int node = -1;
            for (int can : unvisited) {
                if (shortest[can] <= min) {
                    min = shortest[can];
                    node = can;
                }
            }
            unvisited.remove(node);
            if(min == Integer.MAX_VALUE){
                break;
            }

            for (int j = 2; j <= n; j++) {
                if (matrix[node][j] != Integer.MAX_VALUE) {
                    int newDist = min + matrix[node][j];
                    shortest[j] = Math.min(shortest[j], newDist);
                }
            }
        }
        for(int i = 1; i <= n; i++){
            System.out.print(shortest[i] + " ");
        }
        System.out.println();
    }
}
