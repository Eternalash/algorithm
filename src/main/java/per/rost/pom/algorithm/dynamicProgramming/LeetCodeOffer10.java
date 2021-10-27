package per.rost.pom.algorithm.dynamicProgramming;

/**
 * Author:bryan.c
 * Date:2021/10/26
 */
public class LeetCodeOffer10 {
    private static final LeetCodeOffer10 INSTANCE = new LeetCodeOffer10();
    public static void main(String... args) {
        System.out.println(INSTANCE.fib(5));
    }

    public int fib(int n) {
        final int MOD = 1000000007;
        if (n < 2) {
            return n;
        }
        int p, q = 0, r = 1;
        for (int i = 2; i <= n; ++i) {
            p = q;
            q = r;
            r = (p + q) % MOD;
        }
        return r;
    }
}
