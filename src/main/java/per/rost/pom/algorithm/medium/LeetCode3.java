package per.rost.pom.algorithm.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: bryan.c
 * @date: 2021/9/7 下午9:06
 * @package: per.rost.pom.algorithm.medium
 * 无重复字符的最长子串
 */
public class LeetCode3 {
    public static final LeetCode3 INSTANCE=new LeetCode3();

    public static void main(String... args){
        System.out.println(INSTANCE.lengthOfLongestSubstring("abcdefagh"));
        System.out.println(INSTANCE.lengthOfLongestSubstringV2("abcabcdade"));
    }

    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (n-i+1<=ans) break;
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }


    public int lengthOfLongestSubstringV2(String s) {
        //a b c a b c d a d e
        //0 1 2 3 4 5 6 7 8 9
        int maxSize = 0;
        //记录ASCII 码字符出现的位置，以字符作为下标
        int[] dict = new int[128];
        //为了方便理解，这里把数组内容全部设为 -1，之后在记录的时候就可以从 0 开始，方便理解
        Arrays.fill(dict, -1);
        //用于记录重复 ASCII 码字符出现的位置的值
        int repeatValue = -1;
        // 当前下标
        int i = 0;
        int ASCII;
        while (i < s.length()) {
            ASCII = s.charAt(i);
            //如果当前位置的值 > repeatValue，证明当前位置已经赋过一次值了，证明字符重复
            if (dict[ASCII] > repeatValue)
                //更新 repeatValue 为之前赋值的下标
                repeatValue = dict[ASCII];
            //将当前下标赋值到数组相应位置
            dict[ASCII] = i;
            //i - repeatValue(去除重复部分)
            // 比如 abcabcdade 中的三个 a 的计算  abca - a(3 - 0)=bca   abcabcda - abca(7 - 3)=bcda
            maxSize = Math.max(maxSize, i - repeatValue);
            //s.length() - repeatValue - 1 判断剩下的数有没有必要继续循环
            //比如 abcabcdade 最后的 a(当 i = 7 repeatValue = 3) ，abcabcdade - abca(10-3-1) = bcdade  剩下最多有六位
            //比如 abcabcdade 最后的 d(当 i = 8 repeatValue = 6) ，abcabcdade - abcabcd(10-6-1) = ade  剩下最多也是三位
            if (maxSize >= s.length() - repeatValue - 1) {
                return maxSize;
            }
            i++;
        }
        return maxSize;
    }
}
