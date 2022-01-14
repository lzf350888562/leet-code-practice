package source.leetcode.type;

/**
 * 二进制数
 * 461. 汉明距离
 * 190. 颠倒二进制位
 * 136. 只出现一次的数字
 * 342. 4的幂
 * 338. 比特位计数
 * 268. 丢失的数字
 * 693. 交替位二进制数
 * 476. 数字的补数
 * 260. 只出现一次的数字 III
 */
public class BinaryNum {
    /**
     * 461. 汉明距离
     * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
     */
    public int hammingDistance(int x, int y) {
        //对两个数进行按位异或操作，统计有多少个 1 即可。
        int diff = x ^ y, ans = 0;
        while (diff != 0) {
            ans += diff & 1;
            diff >>= 1;
        }
        return ans;
    }
    /**
     * 190. 颠倒二进制位
     * 前后翻转
     */
    public int reverseBits(int n) {
        //用算术左移和右移
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            //每次将 n的最后一位 放到左移一位后的ans最后一位
            ans <<= 1;
            ans += n & 1;
            n >>= 1;
        }
        return ans;
    }

    /**
     * 136. 只出现一次的数字
     * 其他数字都出现了两次
     */
    int singleNumber(int[] nums) {
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
            }
        }
        return ans;
    }

    /**
     * 342. 4的幂
     * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
     *
     * 如果 n & (n - 1) 为 0，那么这个数是 2 的次方。
     *  4 的次方二进制表示中 1 的位置为奇数位。
     *  可以把 n 和二进制的 10101...101（即十进制下的 1431655765）做按位与，如果结果不为 0，那么说明这个数是 4 的次方。
     */
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) ==0 && (n & 1431655765) !=0;
    }


}
