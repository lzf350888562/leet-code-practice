package source.leetcode.middle.tree;

import source.leetcode.esay.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 */
public class BuildTree {
//    private Map<Integer,Integer> inMap = new HashMap<>();
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        return doBuild(preorder,0,preorder.length,inorder,0,inorder.length);
//    }
//
//    public TreeNode doBuild(int[] preorder, int preStart, int preEnd, int[] inorder,int inStart, int inEnd){
//        if(preStart > preEnd || inStart > inEnd) return null;
//        TreeNode root = new TreeNode(preorder[preStart]);
//        int inRoot = inMap.get(root.val);
//        int numsLeft = inRoot - inStart;
//        root.left = doBuild(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1);
//        root.right = doBuild(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd);
//        return root;
//    }
}
