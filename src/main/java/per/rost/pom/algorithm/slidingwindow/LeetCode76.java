package per.rost.pom.algorithm.slidingwindow;

import java.util.HashMap;

/**
 * Author:bryan.c
 * Date:2021/9/26
 */
public class LeetCode76 {
    private static final LeetCode76 INSTANCE= new LeetCode76();

    public static void main(String... args){
        System.out.println(INSTANCE.slidingWindow("ADOBECODEBANC","ABC"));
    }
    String slidingWindow(String s, String t) {
        HashMap<Character, Integer> need=new HashMap<>(), window=new HashMap<>();
        char[] str=s.toCharArray();
        for (char c : t.toCharArray()) need.put(c,need.getOrDefault(c,0)+1);

        int left = 0, right = 0;
        int valid = 0;
        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < str.length) {
            // c 是将移入窗口的字符
            char c = str[right];
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c,window.getOrDefault(c,0)+1);
                if (window.get(c).compareTo(need.get(c))==0)
                    valid++;
            }

            /*** debug 输出的位置 ***/
            System.out.println( String.format("window: [%s, %s)\n", left, right));
            /********************/

            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                // 在这里更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d 是将移出窗口的字符
                char d = str[left];
                // 左移窗口
                left++;
                /*** debug 输出的位置 ***/
                System.out.println( String.format("---move left window: [%s, %s)\n", left, right));
                /********************/
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).compareTo(need.get(d))==0)
                        valid--;
                    window.put(d,window.getOrDefault(d,0)-1);
                }
            }
        }
        // 返回最小覆盖子串
        return len == Integer.MAX_VALUE ?
                "" : s.substring(start, right);
    }

}
