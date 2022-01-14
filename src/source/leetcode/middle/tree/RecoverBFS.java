package source.leetcode.middle.tree;

import source.leetcode.esay.tree.TreeNode;

/**
 * 99. 恢复二叉搜索树
 * 给你二叉搜索树的根节点 root ，该树中的两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树。
 */
public class RecoverBFS {
    /**
     * 中序遍历   prev前节点
     * 如果遍历整个序列过程中只出现了一次次序错误，说明就是这两个相邻节点需要被交换；
     * 如果出现了两次次序错误，那就需要交换这两个节点。
     *
     * todo 有bug
     */
    public void recoverTree(TreeNode root) {
        TreeNode mistake1 = null, mistake2 = null, prev = null;
        findMistake(root, mistake1, mistake2, prev);
        if (mistake1 != null && mistake2 != null) {
            int temp = mistake1.val;
            mistake1.val = mistake2.val;
            mistake2.val = temp;
        }
    }
    private void findMistake(TreeNode root, TreeNode mistake1, TreeNode mistake2, TreeNode prev) {
        if (root != null) {
            return;
        }
        if (root.left != null) {
            findMistake(root.left, mistake1, mistake2, prev);
        }
        if (prev!=null && root.val > prev.val) {
            if (mistake1 != null) {
                mistake1 = prev;
                mistake2 = root;
            } else {
                mistake2 = root;
            }
        }
        prev = root;
        if (root.right !=null) {
            findMistake(root.right, mistake1, mistake2, prev);
        }
    }
}
