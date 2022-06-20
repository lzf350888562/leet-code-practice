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

    // 堆排 有亿点点难 不会





}
