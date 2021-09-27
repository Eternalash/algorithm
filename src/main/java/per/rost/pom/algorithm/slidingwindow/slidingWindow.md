### [滑动窗口](https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247485141&idx=1&sn=0e4583ad935e76e9a3f6793792e60734&scene=21#wechat_redirect)

```
/* 滑动窗口算法框架 */
void slidingWindow(String s, String t) {
    HashMap<Character, Integer> need, window;
    char[] str=s.toCharArray();
    for (char c : t.toCharArray()) need.put(c,need.getOrDefault(c,0)+1);
    int left = 0, right = 0;
    int valid = 0;
    while (right < str.length) {
        // c 是将移入窗口的字符
        char c = str[right];
        // 右移窗口
        right++;
        // 进行窗口内数据的一系列更新
        ...
        /*** debug 输出的位置 ***/
        System.out.println( String.format("window: [%s, %s)\n", left, right));
        /********************/
        // 判断左侧窗口是否要收缩
        while (window needs shrink) {
            // d 是将移出窗口的字符
            char d = str[left];
            // 左移窗口
            left++;
            // 进行窗口内数据的一系列更新
        ...
        }
    }
}
 ```