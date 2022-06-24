package source.leetcode.middle.array;

import java.util.*;

/**
 * 15
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * @author lzf
 * @date 2021/10/5
 */
public class ThreeSum {
    //排序+双指针
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            if(i!=0&&nums[i]==nums[i-1]){
                continue;
            }
            //因为b+c唯一 所以优化二重循环  使得此循环复杂度为O(n)
            for (int j = i + 1,k=nums.length-1; j < k; j++) {
                if(j!=i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                while (j<k-1 && nums[i]+nums[j]+nums[k]>0){
                    k--;
                }
                if(nums[i]+nums[j]+nums[k] == 0){
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Date());
        System.out.println(new ThreeSum().threeSum(new int[]{1,2,-2,-1}));
//        System.out.println(new ThreeSum().threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(new Date());
    }
}
