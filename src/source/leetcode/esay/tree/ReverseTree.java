package source.leetcode.esay.tree;

/**
 * 226. 翻转二叉树
 * 即左边移动到右边 右边移动到左边 根节点不变
 */
public class ReverseTree {
    /**
     * 递归交换节点 或者 广度优先交换值?
     */
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode t1 = invertTree(root.left);
        TreeNode t2 = invertTree(root.right);
        root.right = t1;
        root.left = t2;
        return root;
    }

}
