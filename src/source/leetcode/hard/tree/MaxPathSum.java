package source.leetcode.hard.tree;

import source.leetcode.esay.tree.TreeNode;

/**
 * 124. 二叉树中的最大路径和
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。
 * 注意 本质为后序遍历
 */
public class MaxPathSum {
    private int max;
    public int maxPathSum(TreeNode root) {
        max = root.val;
        oneSideMax(root);
        return max;
    }
    public int oneSideMax(TreeNode root){
        if(root == null) return 0;
        int left = Math.max(0, maxPathSum(root.left));
        int right = Math.max(0, maxPathSum(root.right));
        max = Math.max(max, left+right+root.val);
        return Math.max(left,right) + root.val;
    }
}
