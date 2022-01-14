package source.leetcode.esay.tree;

/**
 * 404. 左叶子之和
 * 计算给定二叉树的所有左叶子之和。
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        return doSearch(root.left,true)+doSearch(root.right,false);
    }
    //在函数里多传一个参数，表示当前节点是不是父节点的左节点。
    private int doSearch(TreeNode node,Boolean isLeft){
        if(node == null){
            return 0;
        }
        if(isLeft && node.left == null && node.right == null){
            return node.val;
        }
        return doSearch(node.left,true)+doSearch(node.right,false);
    }
}
