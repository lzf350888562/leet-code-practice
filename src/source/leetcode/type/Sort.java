package source.leetcode.type;

/**
 * 排序
 * 215. 数组中的第K个最大元素
 * 347. 前 K 个高频元素
 * 451. 根据字符出现频率排序
 */
public class Sort {
    /**
     * 快排
     */
    void quick_sort(int[] nums, int l, int r) {
        if (l + 1 >= r) {
            return;
        }
        int first = l, last = r - 1, key = nums[first];
        while (first < last){
            while(first < last && nums[last] >= key) {
                --last;
            }
            nums[first] = nums[last];   //中间值已经通过key保存, 这里可直接替换掉
            while (first < last && nums[first] <= key) {
                ++first;
            }
            nums[last] = nums[first];
        }
        nums[first] = key;
        quick_sort(nums, l, first);
        quick_sort(nums, first + 1, r);
    }

    /**
     * 归并
     */
    void merge_sort(int[] nums, int l, int r, int[] temp) {
        if (l + 1 >= r) {
            return;
        }
        // divide
        int m = l + (r - l) / 2;
        merge_sort(nums, l, m, temp);
        merge_sort(nums, m, r, temp);
        // conquer
        int p = l, q = m, i = l;
        while (p < m || q < r) {
            if (q >= r || (p < m && nums[p] <= nums[q])) {
                temp[i++] = nums[p++];
            } else {
                temp[i++] = nums[q++];
            }
        }
        for (i = l; i < r; ++i) {
            nums[i] = temp[i];
        }
    }

    /**
     * 215. 数组中的第K个最大元素
     * 快速排序 - 快速选择
     * todo
     */
    public int findKthLargest(int[] nums, int k) {
        return 0;
    }

    /**
     * 347. 前 K 个高频元素
     * 桶排序 -- 为每个值设立一个桶，桶内记录这个值出现的次数，然后对桶进行排序。
     * todo
     */
    public int[] topKFrequent(int[] nums, int k) {
        return null;
    }

    /**
     * 451. 根据字符出现频率排序
     * 桶排序
     * todo
     */
    public String frequencySort(String s) {
        return null;
    }

    /**
     * 75. 颜色分类
     * 给定一个包含红色、白色和蓝色，一共n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * 此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
     * todo
     */
    public void sortColors(int[] nums) {

    }
}
