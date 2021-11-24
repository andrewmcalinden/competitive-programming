package dp;
import java.util.*;

public class Coin{
    public static void main(String [] args){
        int [] coins = new int[]{7, 1, 3, 5};
        System.out.println(solve(coins, 11));
    }

    public static int solve(int [] coins, int n){
        int [] min = new int[n + 1];
        for (int i = 1; i <= n; i++){
            int currentMin = Integer.MAX_VALUE;
            for (int val : coins){
                if (val <= i){
                    int newTarget = i - val;
                    int sum = 1 + min[newTarget];
                    currentMin = Math.min(currentMin, sum);
                }
            }
            min[i] = currentMin;
        }
        System.out.println(Arrays.toString(min));
        return min[n];
    }
}