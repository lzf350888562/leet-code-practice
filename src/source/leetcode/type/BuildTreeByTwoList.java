package source.leetcode.type;

import source.leetcode.esay.stack.MinStack;
import source.leetcode.esay.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据任意两个序列构造二叉树
 * 该题有个例子一看就能做出来, 考虑好边界就行
 */
public class BuildTreeByTwoList {


    /**
     * 前中 时过一年, 再写一遍
     */
    public TreeNode buildTree4(int[] preorder, int[] inorder) {
        return doBuild4(preorder, 0, preorder.length - 1, inorder,0, preorder.length - 1);
    }
    // start 中序起点 end 中序终点 rootIndex 前序根节点下标
    private TreeNode doBuild4(int[] preorder, int preStart, int preEnd,int[] inorder,int midStart, int midEnd) {
        if(preStart > preEnd || midStart > midEnd ) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int indexInMid = midStart;
        while(inorder[indexInMid] != preorder[preStart]) indexInMid++;
        // preStart+1开始
        root.left = doBuild4(preorder, preStart+1, preStart+ (indexInMid - midStart), inorder, midStart, indexInMid-1);
        root.right = doBuild4(preorder, preStart+ (indexInMid - midStart + 1) , preEnd, inorder, indexInMid+1, midEnd);
        return root;
    }

    /**
     * 后中 时过一年 再写一遍
     */
    public TreeNode buildTree3( int[] inorder,int[] postorder) {
        return doBuild3(postorder, 0, postorder.length - 1, inorder,0, inorder.length - 1);
    }
    // start 中序起点 end 中序终点 rootIndex 前序根节点下标
    private TreeNode doBuild3(int[] postorder, int postStart, int postEnd,int[] inorder,int midStart, int midEnd) {
        if(postStart > postEnd || midStart > midEnd ) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int indexInMid = midStart;
        while(indexInMid <= midEnd && inorder[indexInMid] != postorder[postEnd]) indexInMid++;  //需要考虑下标溢出
        // postEnd减一结束
        root.left = doBuild3(postorder, postStart, postStart + (indexInMid - midStart - 1), inorder, midStart, indexInMid-1);
        root.right = doBuild3(postorder, postStart + (indexInMid - midStart) , postEnd-1, inorder, indexInMid+1, midEnd);
        return root;
    }
    /**
     * 105. 从前序与中序遍历序列构造二叉树
     */
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        // 中序遍历结果保存到map, value即表示下标, 也表示前面有多少个元素
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        //每轮递归只需要知道当前 前序的根节点 和中序的区间即可
        return doBuild1(preorder, 0, 0, preorder.length - 1, inMap);
    }
    // start 中序起点 end 中序终点 rootIndex 前序根节点下标
    private TreeNode doBuild1(int[] preorder, int rootIndexInPre, int start, int end, Map<Integer, Integer> inMap) {
        if (start > end) {
            return null;
        }
        int rootVal = preorder[rootIndexInPre];     // 该轮递归的根节点 即当前前序遍历第一个
        int rootIndexInMid = inMap.get(rootVal);    //  当前根节点在当前中序遍历中的位置
        int leftLen = rootIndexInMid - start + 1;       // 下一轮的右子树前序根节点距离当前起点偏移量
        TreeNode root = new TreeNode(rootVal);
        root.left = doBuild1(preorder, rootIndexInPre + 1,start, rootIndexInMid - 1,  inMap);
        root.right = doBuild1(preorder, rootIndexInPre + leftLen,rootIndexInMid + 1, end,  inMap);
        return root;
    }

    /**
     * 106. 从中序与后序遍历序列构造二叉树
     */
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        return doBuild2(postorder, 0, postorder.length - 1, inorder,0,inorder.length - 1);
    }

    private TreeNode doBuild2(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd) {
        if( inStart > inEnd) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[postEnd]);
        int rootin = inStart;
        while (rootin <= inEnd && inorder[rootin] != postorder[postEnd]) rootin++;
        int left = rootin - inStart;
        node.left = doBuild2(postorder, postStart, postStart + left - 1, inorder, inStart, rootin - 1);
        node.right = doBuild2(postorder,postStart + left, postEnd - 1,inorder,rootin + 1, inEnd);
        return node;
    }






    /**
     * 889. 根据前序和后序遍历构造二叉树
     */
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return null;
    }

    public static void main(String[] args) {
//        TreeNode treeNode = new BuildTreeByTwoList().buildTree1(new int[]{4, 9, 20, 15, 7}, new int[]{9, 4, 15, 20, 7});
        TreeNode treeNode = new BuildTreeByTwoList().buildTree2(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        System.out.println(treeNode);
    }
}
