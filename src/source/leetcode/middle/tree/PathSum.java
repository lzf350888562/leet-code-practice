package source.leetcode.middle.tree;

import source.leetcode.esay.tree.TreeNode;

/**
 * 437. 路径总和 III
 * 给定一个二叉树的根节点 root，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）
 */
public class PathSum {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        //递归对数中每个节点统计
        return pathSumStartWithRoot(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    //表示以root为起点进行计算 ,返回以该节点为起点的满足条件的路径数量
    private int pathSumStartWithRoot(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int count = root.val == sum ? 1 : 0;
        count += pathSumStartWithRoot(root.left, sum - root.val);
        count += pathSumStartWithRoot(root.right, sum - root.val);
        return count;
    }

}
