package source.leetcode.middle.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * no.46  全排列
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> tmp = new LinkedList<>();
        doPermute(nums, res, tmp);
        return res;
    }
    // 参数1表示源数组  参数2表示结果集 参数3表示路径 (不需要随机访问, 需要删除最后一个节点,可用双向链表)
    public void doPermute(int[] nums, List<List<Integer>> res, LinkedList<Integer> tmp) {
        if (tmp.size() == nums.length) {
            List<Integer> item = new ArrayList<>(tmp);
            res.add(item);
        }
        for (int i = 0; i < nums.length; i++) {
            //路径中不存在的其他节点为可选路径
            if (!tmp.contains(nums[i])) {  //O(N)  可优化
                tmp.add(nums[i]);
                doPermute(nums, res, tmp);
                tmp.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Permute().permute(new int[]{1, 2, 3}));
    }
}
