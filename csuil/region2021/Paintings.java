package region2021;

import java.util.*;
import java.io.*;

class Paintings {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new File("region2021/paintings.dat"));
        int runs = input.nextInt();
        input.nextLine();
        for (int run = 1; run <= runs; run++) {
            int n = input.nextInt();
            int k = input.nextInt();
            int[] vals = new int[n];
            int[] probs = new int[n];
            for (int i = 0; i < n; i++) {
                vals[i] = input.nextInt();
                probs[i] = input.nextInt();
            }

            double[][] ans = new double[n + 1][k + 1]; // p not to get caught
            for (int i = 1; i <= k; i++) {
                ans[0][i] = -1;
            }

            for (int i = 0; i <= n; i++) { // maybe start at 1
                ans[i][0] = 1;
            }

            for (int numPaintings = 1; numPaintings <= n; numPaintings++) {
                for (int goal = 1; goal <= k; goal++) {
                    int newVal = vals[numPaintings - 1];
                    double newProb = 1 - probs[numPaintings - 1] / 100.0;

                    double oldProb = ans[numPaintings - 1][goal];

                    int remaining = goal - newVal;
                    if (remaining < 0) {
                        remaining = 0;
                    }

                    double otherProb = ans[numPaintings - 1][remaining];

                    double useIt = newProb * otherProb;

                    double best = -1;
                    if (useIt >= 0 && oldProb < 0) {
                        best = useIt;
                    } else if (oldProb >= 0 && useIt < 0) {
                        best = oldProb;
                    } else if (oldProb >= 0 && useIt >= 0) {
                        best = Math.max(useIt, oldProb);
                    }
                    ans[numPaintings][goal] = best;
                }
            }
            double print = 100.0 - ans[n][k] * 100.0;
            if (ans[n][k] == -1) {
                print = 100.0;
            }

            // for (double [] ray : ans){
            // System.out.println(Arrays.toString(ray));
            // }
            System.out.println("Case #" + run + ": " + String.format("%.6f", print));
        }
    }
}