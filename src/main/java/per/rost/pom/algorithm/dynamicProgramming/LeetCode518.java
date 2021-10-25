package per.rost.pom.algorithm.dynamicProgramming;

/**
 * Author:bryan.c
 * Date:2021/9/7
 */
public class LeetCode518 {
    private static final LeetCode518 INSTANCE = new LeetCode518();

    public static void main(String... args) {
        System.out.println(INSTANCE.change(5, new int[]{1, 2, 5}));
    }

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        //base case
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
