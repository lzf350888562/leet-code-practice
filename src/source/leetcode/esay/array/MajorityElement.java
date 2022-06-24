package source.leetcode.esay.array;

/**
 * 169 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 n/2 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * @author lzf
 * @date 2021/10/4
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 1;
        int maj = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (maj == nums[i])
                count++;
            else {
                count--;
                if (count == 0) {
                    maj = nums[i + 1];
                }
            }
        }
        return maj;
    }
}