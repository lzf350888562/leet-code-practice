package source.leetcode.middle.tree;
import source.leetcode.esay.tree.TreeNode;

/**
 * 543. 二叉树的直径  二叉树的最长路径  与124类似
 * 给定一棵二叉树，你需要计算它的直径长度。
 * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 */
public class DiameterOfBinaryTree {
    private int max;
    public int diameterOfBinaryTree(TreeNode root) {
       doTrace(root);
       return max;
    }
    //后序遍历 排除负数路径 选出最大路径
    private  int doTrace(TreeNode node){
        if (node == null) return 0;
        int left = doTrace(node.left);
        int right = doTrace(node.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}
