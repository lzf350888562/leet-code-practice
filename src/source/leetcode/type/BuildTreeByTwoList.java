package source.leetcode.type;

import source.leetcode.esay.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据任意两个序列构造二叉树
 */
public class BuildTreeByTwoList {

    /**
     * 105. 从前序与中序遍历序列构造二叉树
     */
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        // 中序遍历结果保存到map, value即表示下标, 也表示前面有多少个元素
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return doBuild(preorder, 0, preorder.length - 1, 0, inMap);
    }
    // start 前序起点 end 前序终点 rootIndex 前序根节点下标
    private TreeNode doBuild(int[] preorder, int start, int end, int rootIndexInPre, Map<Integer, Integer> inMap) {
        if (start > end) {
            return null;
        }
        int rootVal = preorder[rootIndexInPre];     // 该轮递归的根节点 即当前前序遍历第一个
        int rootIndexInMid = inMap.get(rootVal);    // 当前根节点在当前中序遍历中的位置
        int leftLen = rootIndexInMid - start;       // 下一轮询右子树前序距离起点偏移量
        TreeNode root = new TreeNode(rootVal);
        root.left = doBuild(preorder, start, rootIndexInMid - 1, rootIndexInPre + 1, inMap);
        root.right = doBuild(preorder, rootIndexInMid + 1, end, rootIndexInPre + 1 + leftLen, inMap);
        return root;
    }



    public static void main(String[] args) {
        TreeNode treeNode = new BuildTreeByTwoList().buildTree1(new int[]{4, 9, 20, 15, 7}, new int[]{9, 4, 15, 20, 7});
        System.out.println(treeNode);
    }
}
