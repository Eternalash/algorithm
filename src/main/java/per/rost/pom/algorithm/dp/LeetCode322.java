package per.rost.pom.algorithm.dp;

import java.util.Arrays;

/**
 * Author:bryan.c
 * Date:2021/9/7
 */
public class LeetCode322 {
    private static final LeetCode322 INSTANCE=new LeetCode322();

    public static void main(String... args) {
        System.out.println(INSTANCE.change(11,new int[]{1,2,5}));
    }

    public int change(int amount, int[] coins) {
        int[] dp=new int[amount+1];
        //base case
        Arrays.fill(dp,amount+1);
        dp[0]=0;

        for (int i=0;i<=amount;i++){
            for (int coin:coins){
                if (i - coin >= 0) {
                    dp[i]=Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }
}
