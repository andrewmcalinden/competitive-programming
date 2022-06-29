import java.util.Arrays;

public class LCS {
    public static void main(String[] args) {
        String a = "WIN", b = "UIL";
        System.out.println(rec(a, b, 0, 0) + " " + dp(a, b));
        a = "Door";
        b = "Ford";
        System.out.println(rec(a, b, 0, 0) + " " + dp(a, b));
        a = "Bored";
        b = "Tired";
        System.out.println(rec(a, b, 0, 0) + " " + dp(a, b));
        a = "trying";
        b = "realign";
        System.out.println(rec(a, b, 0, 0) + " " + dp(a, b));
    }

    public static int rec(String a, String b, int ai, int bi) {
        if (ai == a.length() || bi == b.length())
            return 0;
        if (a.charAt(ai) == b.charAt(bi))
            return 1 + rec(a, b, ai + 1, bi + 1);
        int x = rec(a, b, ai + 1, bi);
        int y = rec(a, b, ai, bi + 1);
        return Math.max(x, y);
    }

    public static int dp(String a, String b) {
        int al = a.length();
        int bl = b.length();
        int[][] dp = new int[al + 1][bl + 1];
        for (int i = 0; i < al; i++) {
            for (int j = 0; j < bl; j++) {
                if (a.charAt(i) == b.charAt(j))
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                else {
                    int x = dp[i][j + 1];
                    int y = dp[i + 1][j];
                    dp[i + 1][j + 1] = Math.max(x, y);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[al][bl];
    }
}
