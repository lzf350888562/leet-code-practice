package source.leetcode.esay.tree;

/**
 * 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 对于树上的任意节点，其两侧节点的最大深度的差值不得大于 1。
 * 可借助查询深度
 * @author Jinx
 * @Date 2021/3/27
 */
public class IsBalanced {
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (Math.abs(MaxDepth.maxDepth(root.left) - MaxDepth.maxDepth(root.right)) > 1) {
			return false;
		}
		return isBalanced(root.left) && isBalanced(root.right);
	}
}
