package per.rost.pom.algorithm.dp;

import java.util.Arrays;

/**
 * @author: bryan.c
 * @date: 2021/9/6 下午9:35
 * @package: per.rost.pom.algorithm.dp
 */
public class LeetCode322 {
    private static final LeetCode322 INSTANCE=new LeetCode322();

    public static void main(String... args) {
        System.out.println(INSTANCE.coinChange(new int[]{2},3 ));
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        Arrays.fill(dp,amount+1);
        //总金额为0，需要0枚硬币
        dp[0]=0;

        for (int i=0;i<amount+1;i++){
            for(int coin:coins){
                if (i-coin<0){
                    continue;
                }
                dp[i]=Math.min(dp[i],dp[i-coin]+1);
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }
}
