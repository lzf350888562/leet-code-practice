package source.leetcode.type;

/**
 * 二分
 * 69. Sqrt(x)
 * 34. 在排序数组中查找元素的第一个和最后一个位置 重要
 */
public class Binary {
    /**
     * 69. Sqrt(x)
     * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
     * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
     *
     * 转换为求 f (x) = x^2 − a = 0 的解, 对[0,a]区间(单调递增)使用二分
     */
    public int mySqrt(int a) {
        //先排除0
        if (a == 0) return a;
        int left = 1,right=a, mid,sqrt;
        while (left <= right){
//            mid = (left+right)/2
            mid = left + (right-left)/2; //防止溢出
            sqrt = a/mid;
            if(sqrt == mid){
                return mid;
            }else if(sqrt > mid){   //结果太大, 需要加大除数
                left = mid+1;
            }else{ //结果太小, 需要减小除数
                right = mid -1;
            }
        }
        //如果循环不能找出结果, 返回更小的right
        return right;
    }
    /**
     * 34. 在排序数组中查找元素的第一个和最后一个位置
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     *
     * 如果数组中不存在目标值 target，返回[-1, -1]。
     * 此题二分效率很高, 重点
     */
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0 ){
            return new int[]{-1,-1};
        }
        //------------二分查找左侧边界 闭
        int l1 = 0, r1 = nums.length, mid1;
        while (l1 < r1) {
            mid1 = (l1 + r1) / 2;
            if (nums[mid1] >= target) {
                r1 = mid1;
            } else {
                l1 = mid1 + 1;
            }
        }
        //----------二分查找右侧边界   开 需要减一
        int l2 = 0, r2 = nums.length, mid2;
        while (l2 < r2) {
            mid2 = (l2 + r2) / 2;
            if (nums[mid2] > target) {
                r2 = mid2;
            } else {
                l2 = mid2 + 1;
            }
        }
        if(l1 == nums.length ||nums[l1] != target){  //验证一下
            return new int[]{-1,-1};
        }
        return new int[]{l1,l2-1};
    }
}
