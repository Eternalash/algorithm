package per.rost.pom.algorithm.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:bryan.c
 * Date:2021/9/16
 */
public class LeetCode78 {
    private static final LeetCode78 INSTANCE=new LeetCode78();

    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public static void main(String... args) {
        System.out.println(INSTANCE.subsets(new int[]{1,2,3}));
    }


    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }
}
