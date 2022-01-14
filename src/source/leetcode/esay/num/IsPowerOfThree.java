package source.leetcode.esay.num;

/**
 * 326. 3 的幂
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 */
public class IsPowerOfThree {
    //因为在 int 范围内 3 的最大次方是 3/19 = 1162261467，如果 n 是 3 的整数次方，那么 1162261467 除以 n 的余数一定是零；
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
