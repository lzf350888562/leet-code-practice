package source.leetcode.type;

import source.leetcode.esay.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 非递归遍历二叉树
 */
public class NotRecursiveTraceTree {
    /**
     * 前序 144
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            res.add(pop.val);
            // 先右后左 保证左先遍历
            if(pop.right != null){
                stack.push(pop.right);
            }
            if(pop.left != null){
                stack.push(pop.left);
            }
        }
        return res;
    }
    /**
     * 中序  94
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null){
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            //这里必须创建新对象不能复用root
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                root = node.right;
            }
        }
        return res;
    }

    /**
     * 145 后续
     * 区别于前序 需要另外一个数组倒序记录
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            res.add(pop.val);
            // 先左后右 最后翻转
            if(pop.left != null){
                stack.push(pop.left);
            }
            if(pop.right != null){
                stack.push(pop.right);
            }
        }
        Collections.reverse(res);
        return res;
    }
}
