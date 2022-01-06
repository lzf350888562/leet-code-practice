package source.leetcode.middle.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * no.46  全排列
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        for (int i=0 ; i<nums.length;i++) {
            doPermute(i, nums,res,tmp);
        }
        return res;
    }

    public void doPermute(int index, int[] nums, List<List<Integer>> res, List<Integer> tmp){
        tmp.add(nums[index]);
        if(tmp.size() == nums.length){
            List<Integer> item = new ArrayList<>(tmp);
            res.add(item);
        }
        for (int i = 0; i < nums.length; i++) {
            if(!tmp.contains(nums[i])){
                doPermute(i,nums,res,tmp);
            }
        }
        tmp.remove((Integer) nums[index]);
    }

    public static void main(String[] args) {
        System.out.println(new Permute().permute(new int[]{1, 2, 3}));
    }
}
