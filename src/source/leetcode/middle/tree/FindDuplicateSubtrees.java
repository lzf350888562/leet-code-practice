package source.leetcode.middle.tree;

import source.leetcode.esay.tree.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 652. 寻找重复的子树
 * 给定一棵二叉树 root，返回所有重复的子树。
 * 对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 */
public class FindDuplicateSubtrees {
    // 记录所有子树以及出现的次数
    HashMap<String, Integer> subTrees = new HashMap<>();
    // 记录重复的子树根节点
    LinkedList<TreeNode> res = new LinkedList<>();
    List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return res;
    }

    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String left = serialize(root.left);
        String right = serialize(root.right);
        String myself = left + "," + right+ "," + root.val;
        int sum = subTrees.getOrDefault(myself, 0);
        // 多次重复也只会被加入结果集一次
        if (sum == 1) {
            res.add(root);
        }
        // 给子树对应的出现次数加一
        subTrees.put(myself, sum + 1);
        return myself;
    }
}
