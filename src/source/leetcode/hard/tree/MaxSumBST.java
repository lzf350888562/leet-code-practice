package source.leetcode.hard.tree;

import source.leetcode.esay.tree.TreeNode;

/**
 * 1373. 二叉搜索子树的最大键值和
 * 给你一棵二叉树，请你返回 任意二叉搜索子树的最大键值和。
 */
public class MaxSumBST {
    /**
     * 需要的信息:
     * 1、左右子树是否是 BST。
     * 2、左子树的最大值和右子树的最小值。
     * 3、左右子树的节点值之和。
     * 采用后续遍历
     */
    // 全局变量，记录 BST 最大节点之和
    int maxSum = 0;
    /* 主函数 */
    public int maxSumBST(TreeNode root) {
        traverse(root);
        return maxSum;
    }
    // 函数返回 int[]{ isBST, min, max, sum}
    private int[] traverse(TreeNode root) {
        // base case
        if (root == null) { //空节点也算BST
            return new int[] {1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }
        // 递归计算左右子树
        int[] left = traverse(root.left);
        int[] right = traverse(root.right);

        int[] res = new int[4];
        // 左右子树是BST 且左边最大小于自己小于右边最小 即该节点为BST
        if (left[0] == 1 && right[0] == 1 && root.val > left[2] && root.val < right[1]) {
            res[0] = 1;
            res[1] = Math.min(left[1], root.val);   //不能直接使用left[1]做最小, 因为有空节点情况,最小值为max int
//            res[1] = left[1];
            res[2] = Math.max(right[2], root.val);  //不能直接使用right[2]做最大, 因为有空节点情况,最大值为min int
//            res[2] = right[2];
            res[3] = left[3] + right[3] + root.val;
            maxSum = Math.max(maxSum, res[3]);
        } else {
            res[0] = 0; //其他值用不到
        }
       return res;
    }
}
