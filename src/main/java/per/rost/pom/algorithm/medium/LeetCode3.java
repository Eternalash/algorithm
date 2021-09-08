package per.rost.pom.algorithm.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Author:bryan.c
 * Date:2021/9/8
 */
public class LeetCode3 {
    private static final LeetCode3 INSTANCE = new LeetCode3();

    public static void main(String... args) {
        System.out.println(INSTANCE.lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        int rk = 0, ans = 0;
        for (int i = 0; i < n && i < n - ans; i++) {
            if (i != 0) {
                occ.remove(s.charAt(i - 1));
            }
            while (rk < n && !occ.contains(s.charAt(rk))) {
                occ.add(s.charAt(rk));
                rk++;
            }
            ans = Math.max(ans, rk - i);
        }
        return ans;
    }
}
