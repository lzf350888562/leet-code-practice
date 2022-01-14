package source.leetcode.esay.tree;

/**
 * 617. 合并二叉树
 * 值合并 而不是节点合并
 */
public class MergeTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        //只要有一个为空 直接返回即可 不用计算
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        // 如果两个节点都不为空的情况
        root1.val += root2.val;
        // 再递归合并左右子树
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }
}
