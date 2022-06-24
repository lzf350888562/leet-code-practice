package source.leetcode.middle.event;

import java.util.Arrays;

/**
 * 204. 计数质数(素数)
 * 统计所有小于非负整数 n 的质数的数量。
 * 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class CountPrimes {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        boolean[] prime = new boolean[n];
        Arrays.fill(prime,true);
        int count = n - 2; // 去掉不是素数的1
        for (int i = 2; i <= Math.sqrt(n); ++i) {
            if (prime[i]) {
                for (int j = 2 * i; j < n; j += i) {     //偶数不是素数,直接排除
                    if (prime[j]) {
                        prime[j] = false;
                        --count;
                    }
                }
            }
        }
        return count;
    }
}
