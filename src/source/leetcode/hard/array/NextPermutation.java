package source.leetcode.hard.array;

/**
 * no31. 下一个排列
 * [1,2,3]、[1,3,2]、[2,1,3]、[2,3,1]、[3,1,2]、[3,2,1]
 * 题目的测试用例包含重复数字 并且 会有不连续的 因此需要考虑情况
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        boolean flag = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                flag = false;
            }
        }
        if (flag) {
            // 如果是倒序, 说明下一个序列是正序, 翻转数组即可
            reverseArray(nums);
        } else if (nums[nums.length - 2] < nums[nums.length - 1]) {
            // 如果倒数两个是顺序, 翻转两个即可
            reverse(nums, nums.length - 2, nums.length - 1);
        } else {
            // 从后往前依次找到第一个nums[i] < nums[i+1]
            int i = nums.length - 3;
            for (; i >= 0; i--) {
                if(nums[i] < nums[i+1]){
                    // 找到i后对i后面的元素升序排序
                    for (int j = i+1; j < nums.length-1; j++) {
                        int min = nums[j], index = j;
                        for (int k = j+1; k < nums.length; k++) {
                            if(nums[k] < min){
                                min = nums[k];
                                index = k;
                            }
                        }
                        if( index != j ){
                            reverse(nums, index, j);
                        }
                    }
                    // 然后将后面第一个大于nums[i]的元素(即大于nums[i]的最小元素)与nums[i]交换
                    for (int j = i+1; j < nums.length; j++) {
                        if(nums[j] > nums[i]){
                            reverse(nums, j, i);
                            break;
                        }
                    }
                    break;
                }
            }
        }
    }

    private void reverseArray(int[] nums) {
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            reverse(nums, i, j);
        }
    }

    private void reverse(int[] nums, int i, int j) {
        int tmp;
        tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        int[] nums = new int[]{1,3,2};
        nextPermutation.nextPermutation(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }


}
