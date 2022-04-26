package source.leetcode.type;

import java.util.PriorityQueue;

/**
 * 215. 数组中的第K个最大元素
 */
public class FindKthLargest {
    /**
     * 1) 二叉堆  PriorityQueue 默认实现是小顶堆
     * ；当堆大小超过 k 的时候，我们就删掉堆顶的元素，因为这些元素比较小
     */
    int findKthLargest(int[] nums, int k) {
        // 小顶堆，堆顶是最小元素
        PriorityQueue<Integer>
                pq = new PriorityQueue<>();
        for (int e : nums) {
            // 每个元素都要过一遍二叉堆
            pq.offer(e);
            // 堆中元素多于 k 个时，删除堆顶元素, 因为这些元素比较小
            if (pq.size() > k) {
                pq.poll();
            }
        }
        // pq 中剩下的是 nums 中 k 个最大元素，
        // 堆顶是最小的那个，即第 k 个最大元素
        return pq.peek();
    }

    /**
     * 2)快速选择算法 与快速排序类似
     */
    int findKthLargest2(int[] nums, int k) {
        if(nums.length == 1 && k ==1 )return 1;
        int first = 0, last = nums.length - 1;
        k = nums.length - k; //第k个最大的元素在有序数组中的下标
        while (first <= last) {//这里必须等于
            int p = partition(nums, first, last);
            if(k==p){
                return nums[p];
            }else if(p>k){  //在左边
                last = p-1;
            }else{  //在右边
                first = p+1;
            }
        }
        return -1;
    }
    // 快速排序中返回中间下标的片段
    int partition(int[] nums, int first, int last) {
        int key = nums[first];
        while (first < last) {
            while (first < last && nums[last] >= key) {
                --last;
            }
            nums[first] = nums[last];   //中间值已经通过key保存, 这里可直接替换掉
            while (first < last && nums[first] <= key) {
                ++first;
            }
            nums[last] = nums[first];
        }
        nums[first] = key;
        return first;
    }
}
