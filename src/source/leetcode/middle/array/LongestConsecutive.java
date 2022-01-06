package source.leetcode.middle.array;

import java.util.HashSet;
import java.util.Set;

/**
 * no.128 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 */
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        //hash查询时间复杂度为o1, 用它来记录一个整数是否存在
        Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }
        int longestStreak = 0;
        for (int num : num_set) {
            //如果整数前面一个数存在, 则不用遍历, 留给其最前面那个去遍历
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}
