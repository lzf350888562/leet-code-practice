package source.leetcode.type.dp;

import source.leetcode.esay.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 打家劫舍
 */
public class Rob {
    /**
     * 198打家劫舍
     * 数组 取不连续元素 求最大和
     *
     * 状态: 房子索引  选择: 是否抢  值:当前最大结果
     * dp[i]只与dp
     */
    public int rob(int[] nums) {
        int n = nums.length;
        // 记录 dp[i-1] 和 dp[i-2]
        int dp_i_2 = 0, dp_i_1 = 0;
        // 记录 dp[i]
        int dp_i = 0;
        for (int i = 0; i < n; i++) {
            dp_i = Math.max(dp_i_1, nums[i] + dp_i_2);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i;
    }
    /**
     * 213. 打家劫舍 II
     * 在上面的条件下增加: 这些房子不是一排，而是围成了一个圈。所以首尾房子不可同时抢
     * 首尾房间不能同时被抢，那么只可能有三种不同情况：要么都不被抢；要么第一间房子被抢最后一间不抢；要么最后一间房子被抢第一间不抢。
     * 后面两种情况包括了第一种情况
     */
    public int rob1(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(doRob(nums, 0, n - 1),
                doRob(nums, 1, n ));
    }
    private int doRob(int[] nums,int start,int end){
        int n = nums.length;
        // 记录 dp[i-1] 和 dp[i-2]
        int dp_i_2 = 0, dp_i_1 = 0;
        // 记录 dp[i]
        int dp_i = 0;
        for (int i = start ; i < end; i++) {
            dp_i = Math.max(dp_i_1, nums[i] + dp_i_2);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i;
    }
    /**
     * 337. 打家劫舍 III
     * 不是一排 不是圈 换成了二叉树
     */
    private Map<TreeNode, Integer> forget = new HashMap<>();
    public int rob(TreeNode root) {
        if(root == null) return 0;
        if (forget.containsKey(root)){      //已执行过的
            return forget.get(root);
        }
        //抢当前节点的情况 去下孙节点
        int doRob = root.val;
        if(root.left!=null){
            doRob += rob(root.left.left) + rob(root.left.right);
        }
        if(root.right!=null){
            doRob += rob(root.right.left) + rob(root.right.right);
        }
        //不抢当前节点的情况 去子节点
        int notDoRot = rob(root.left) + rob(root.right);
        int res = Math.max(doRob, notDoRot);
        forget.put(root,res);
        return res;
    }
}
