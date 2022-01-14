package source.leetcode.esay.num;

/**
 * 172. 阶乘后的零
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 */
public class TrailingZeroes {
    /**
     * 每个尾部的 0 由 2 × 5 = 10 而来，因此我们可以把阶乘的每一个元素拆成质数相乘，统计有多少对 2 和 5。
     * 明显的，质因子 2 的数量远多于质因子 5 的数量，
     * 因此我们可以只统计阶乘结果里有多少个质因子 5。
     */
    public int trailingZeroes(int n) {
        return n == 0? 0: n / 5 + trailingZeroes(n / 5);
    }
}
