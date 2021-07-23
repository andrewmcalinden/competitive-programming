package misc;

import java.util.ArrayList;
import java.util.Scanner;

public class Ina {
    static int maxDist = 0;
    static int numMaxDist = 0;
    static ArrayList<Integer> [] adjList;
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();

        for (int runs = 0; runs < t; runs++){
            int n = input.nextInt();
            int s = input.nextInt();
            int l = input.nextInt();

            adjList = new ArrayList[n + 1];
            for (int i = 0; i < n + 1; i++){
                adjList[i] = new ArrayList<>();
            }

            for (int i = 0; i < n-1; i++){
                int c1 = input.nextInt();
                int c2 = input.nextInt();

                adjList[c1].add(c2);
                adjList[c2].add(c1);
            }

            boolean[] visited = new boolean[n + 1];
            dfs(s, visited, -1);
            System.out.println("answer: " + (maxDist + numMaxDist - 1) * l);
            maxDist = 0;
            numMaxDist = 0;
        }
    }

    private static void dfs(int computer, boolean [] visited, int dist){
        if (!visited[computer]){
            visited[computer] = true;
            if (++dist > maxDist){
                maxDist = dist;
                numMaxDist = 0;
            }
            if (dist == maxDist) {
                numMaxDist++;
            }
            for (int adj : adjList[computer]){
                dfs(adj, visited, dist);
            }
        }
    }
}
