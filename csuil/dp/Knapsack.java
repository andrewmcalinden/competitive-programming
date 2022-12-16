package dp;
import java.util.*;

public class Knapsack {
    public static void main(String[] args) {
        int[] values = { 1, 2, 3 };
        int[] weights = { 4, 5, 1 };
        System.out.println(solve(4, values, weights));
        System.out.println(coinChange(4, values, weights));
    }

    public static int solve(int w, int[] vals, int[] weights){
        int [][] ans = new int[vals.length + 1][w + 1];
        for (int i = 1; i <= vals.length; i++){
            for (int j = 1; j <= w; j++){
                int newVal = vals[i - 1];
                int newWeight = weights[i - 1];
                int same = ans[i - 1][j];
                if (newWeight <= j){ //consider using new item
                    int total = newVal + ans[i - 1][j - newWeight];
                    ans[i][j] = Math.max(total, same);
                }
                else{ //use old case
                    ans[i][j] = same;
                }

            }
        }
        for (int[] r : ans) {
            System.out.println(Arrays.toString(r));
        }
        return ans[vals.length][w];
    }

    static int coinChange(int w, int[] vals, int[] weights) {
        int [] ans = new int[w + 1];
        ans[0] = 0;
        for(int i = 1; i <= w; i++){
            int maxVal = Integer.MIN_VALUE;
            for(int j = 0; j < vals.length; j++){
                int curVal = vals[j];
                int curWeight = weights[j];
                int extraWeight = i - curWeight;
                if(extraWeight >= 0 && extraWeight < i){
                    int can = curVal + ans[extraWeight];
                    maxVal = Math.max(maxVal, can);
                }
            }
            ans[i] = maxVal;
        }
        System.out.println(Arrays.toString(ans));
        return ans[w];
    }
}
