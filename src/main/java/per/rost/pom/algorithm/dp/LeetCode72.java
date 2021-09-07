package per.rost.pom.algorithm.dp;

/**
 * @author: bryan.c
 * @date: 2021/9/6 下午8:54
 * @package: per.rost.pom.algorithm.dp
 */
public class LeetCode72 {
    private static final LeetCode72 INSTANCE = new LeetCode72();

    public static void main(String... args) {
        System.out.println(INSTANCE.minDistance("horse", "ros"));
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i) == word2.charAt(j))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i - 1][j - 1] + 1, dp[i][j - 1] + 1));
            }
        }
        return dp[m][n];
    }
}
