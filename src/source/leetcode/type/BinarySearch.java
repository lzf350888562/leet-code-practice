package source.leetcode.type;

import sun.security.provider.Sun;

/**
 * 细节最多的 二分法 适用于以下模板:
 * for (int i = 0; i < n; i++)
 * if (isOK(i))
 * return answer;
 * 69. Sqrt(x)
 * 34. 在排序数组中查找元素的第一个和最后一个位置 重要
 * 33. 搜索旋转排序数组
 * 81. 搜索旋转排序数组 II
 * 154. 寻找旋转排序数组中的最小值 II
 * 540. 有序数组中的单一元素
 * 4. 寻找两个正序数组的中位数  两个数组同时二分
 */
public class BinarySearch {
    /**
     * 寻找左侧边界
     */
    int left_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length; // 注意

        while (left < right) { // 注意
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid; // 注意
            }
        }
        return left;
    }

    /**
     * 寻找右侧边界的二分
     */
    int right_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1; // 注意
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left - 1; // 注意
    }

    /**
     * 69. Sqrt(x)
     * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
     * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
     * <p>
     * 转换为求 f (x) = x^2 − a = 0 的解, 对[0,a]区间(单调递增)使用二分
     */
    public int mySqrt(int a) {
        //先排除0
        if (a == 0) return a;
        int left = 1, right = a, mid, sqrt;
        while (left <= right) {
//            mid = (left+right)/2
            mid = left + (right - left) / 2; //防止溢出
            sqrt = a / mid;
            if (sqrt == mid) {
                return mid;
            } else if (sqrt > mid) {   //结果太大, 需要加大除数
                left = mid + 1;
            } else { //结果太小, 需要减小除数
                right = mid - 1;
            }
        }
        //如果循环不能找出结果, 返回更小的right
        return right;
    }

    /**
     * 34. 在排序数组中查找元素的第一个和最后一个位置
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * <p>
     * 如果数组中不存在目标值 target，返回[-1, -1]。
     * 此题二分效率很高, 重点
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
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
        if (l1 == nums.length || nums[l1] != target) {  //验证一下
            return new int[]{-1, -1};
        }
        return new int[]{l1, l2 - 1};
    }

    /**
     * no33. 搜索旋转排序数组 升序数组,无重复
     */
    public int search1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                int res1 = binarySearch(nums, 0, i, target);
                int res2 = binarySearch(nums, i + 1, nums.length - 1, target);
                if (res1 != -1) return res1;
                if (res2 != -1) return res2;
            }
        }
        return binarySearch(nums, 0, nums.length - 1, target);

    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 81. 搜索旋转排序数组 II
     * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
     * [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
     * 判断给定的目标值是否存在于数组中
     * 强制二分...
     *
     * @param nums   旋转过后的数组
     * @param target 目标值
     * @return 目标值是否存在
     */
    public boolean search(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return doBinarySearch(nums, 0, i, target) || doBinarySearch(nums, i + 1, nums.length - 1, target);
            }
        }
        //处理其他情况
        return doBinarySearch(nums, 0, nums.length - 1, target);
    }

    private boolean doBinarySearch(int[] nums, int start, int end, int target) {
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    /**
     * 154. 寻找旋转排序数组中的最小值 II
     * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组
     * 数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
     * 给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。
     * 请你找出并返回数组中的 最小元素 。
     */
    public int findMin(int[] nums) {
//        for (int i = 0; i < nums.length-1; i++) {
//            if(nums[i] > nums[i+1]){
//                return nums[i+1];
//            }
//        }
//        return nums[0];
        /**
         * 主角 二分
         */
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right])
                left = mid + 1;
            else if (nums[mid] < nums[right])
                right = mid;
            else
                right--;
        }
        return nums[left];
    }

    /**
     * 540. 有序数组中的单一元素
     * 给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
     * 请你找出并返回只出现一次的那个数。
     * <p>
     * 考虑在出现独立数之前和之后，奇偶位数的值发生的变化
     */
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid % 2 == 0) {     //如果在奇数位(偶数索引)上表明在可能存在答案的索引上
                if (mid != 0 && nums[mid] == nums[mid - 1]) {           //说明在前面
                    right = mid - 2;
                } else if (nums[mid] == nums[mid + 1]) {     //说明在后面
                    left = mid + 2;
                } else {
                    return nums[mid];
                }
            } else {      //这里只能移1位
                if (nums[mid] == nums[mid - 1]) {           //说明在后面
                    left = mid + 1;
                } else if (nums[mid] == nums[mid + 1]) {     //说明在前面
                    right = mid - 1;
                } else {
                    return nums[mid];
                }
            }
        }
        return nums[left];      //这个好像没有用,通用返回
    }

    /**
     * 4. 寻找两个正序数组的中位数
     * todo
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return 0;
    }

    public static void main(String[] args) {
//        System.out.println(new Binary().search(new int[]{1, 0, 1, 1, 1}, 0));
        System.out.println(new BinarySearch().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    /**
     * 875. 爱吃香蕉的珂珂
     * 每小时最多吃一堆香蕉，如果吃不下的话留到下一小时再吃；如果吃完了这一堆还有胃口，也只会等到下一小时才会吃下一堆。
     * 确定 Koko 吃香蕉的最小速度（根/小时）
     * 可从速度1开始从小到大遍历到最大值(最大堆香蕉个数), 如果遍历到可吃完即最小速度
     * 可通过二分改善
     */
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int n : piles) max = Math.max(n, max);
        int left = 1, right = max;
        while (left < right) {
            int speed = left + (right - left) / 2;
            int time = 0;
            for (int pile : piles) {
                // 吃完这一堆需要的时间
                int timeN = (pile / speed) + ((pile % speed == 0) ? 0 : 1);
                time += timeN;
            }
            if (time <= h) {   //能吃完, 继续提升速度, 防止漏掉这种情况不能减一
                right = speed;
            } else {          //不能吃完, 放慢速度
                left = speed + 1;
            }
        }
        return right;//right也可以 left==right时结束
    }

    /**
     * 第 i个包裹的重量为weights[i]。每一天按给出重量（weights）的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
     * 返回能在 days 天内将传送带上的所有包裹送达的船的最低运载能力。
     * 与吃香蕉题类似, 但货物不可拆分, 最大值最小值也不同
     */
    public int shipWithinDays(int[] weights, int days) {
        int maxWeight = 0;
        int sumWeight = 0;
        for (int weight : weights) {
            //最小边界为最大货物重量
            maxWeight = Math.max(weight, maxWeight);
            //最大边界为所有货物重量的和
            sumWeight += weight;
        }
        int left = maxWeight, right = sumWeight;
        while (left < right) {
            int capacity = left + (right - left) / 2;
            boolean isOk = false;
            int i = 0;
            for (int day = 0; day < days; day++) {
                int maxCap = capacity;
                while ((maxCap -= weights[i]) >= 0) {
                    i++;
                    if (i == weights.length) {
                        isOk = true;
                        break;
                    }
                }
                if (isOk) break;     // i满了需要跳出该循环
            }
            if (isOk) {   //能装完, 继续减少容量, 防止漏掉这种情况不能减一
                right = capacity;
            } else {          //不能装完, 增加容量
                left = capacity + 1;
            }
        }
        return right;
    }
}
