package source.leetcode.middle.tree;

import source.leetcode.esay.tree.TreeNode;

import java.util.*;

/**
 * 1110. 删点成林
 * 给出二叉树的根节点root，树上每个节点都有一个不同的值。
 * 如果节点值在to_delete中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。
 * 返回森林中的每棵树。你可以按任意顺序组织答案。
 */
public class DelNodes {
    LinkedList<TreeNode> stack = new LinkedList<>();
    Set<Integer> set = new HashSet<>();

    //后序遍历
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null) return new ArrayList<>();
        for (int i = 0; i < to_delete.length; i++) {
            set.add(to_delete[i]);
        }
        stack.push(root);
        List<TreeNode> res1 = delsChild(root.left, to_delete);
        List<TreeNode> res2 = delsChild(root.right, to_delete);
        List<TreeNode> res = new ArrayList<>();
        res.addAll(res1);
        res.addAll(res2);
        stack.pop();
        if (set.contains(root.val)) {
            if (root.left != null) {
                res.add(root.left);
            }
            if (root.right != null) {
                res.add(root.right);
            }
        }else{
            res.add(root);
        }
        return res;
    }

    private List<TreeNode> delsChild(TreeNode root, int[] to_delete) {
        if (root == null) return new ArrayList<>();
        stack.push(root);
        List<TreeNode> res = new ArrayList<>();
        res.addAll(delsChild(root.left, to_delete));
        res.addAll(delsChild(root.right, to_delete));
        stack.pop();
        if (set.contains(root.val)) {
            TreeNode peek = stack.peek();
            if (peek.left == root) {
                peek.left = null;
            } else {
                peek.right = null;
            }
            if (root.left != null) {
                res.add(root.left);
            }
            if (root.right != null) {
                res.add(root.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = null;
        t2.right = null;
        t3.left = null;
        t3.right = t4;
        System.out.println(new DelNodes().delNodes(t1, new int[]{2, 1}));
    }
}
