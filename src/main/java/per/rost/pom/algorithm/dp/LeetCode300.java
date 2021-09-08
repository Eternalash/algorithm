package per.rost.pom.algorithm.dp;

import java.util.Arrays;

/**
 * Author:bryan.c
 * Date:2021/9/8
 * 最长上升子序列
 */
public class LeetCode300 {
    private static final LeetCode300 INSTANCE = new LeetCode300();

    public static void main(String... args) {
        System.out.println(INSTANCE.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }

    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        for (int i=0;i<n;i++){
            for (int j=0;j<i;j++){
                if (nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int res =0;
        for (int i=0;i<n;i++){
            res=Math.max(res,dp[i]);
        }
        return res;
    }

    public int lengthOfLISV2(int[] nums) {
        int[] top = new int[nums.length];
        // 牌堆数初始化为 0
        int piles = 0;
        for (int i = 0; i < nums.length; i++) {
            // 要处理的扑克牌
            int poker = nums[i];

            /***** 搜索左侧边界的二分查找 *****/
            int left = 0, right = piles;
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] > poker) {
                    right = mid;
                } else if (top[mid] < poker) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            /*********************************/

            // 没找到合适的牌堆，新建一堆
            if (left == piles) piles++;
            // 把这张牌放到牌堆顶
            top[left] = poker;
        }
        // 牌堆数就是 LIS 长度
        return piles;
    }
}
