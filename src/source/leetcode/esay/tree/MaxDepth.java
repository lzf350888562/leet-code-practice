package source.leetcode.esay.tree;

/**
 * @author Jinx
 * @Date 2021/3/27
 */
public class MaxDepth {
	public static int maxDepth(TreeNode root) {
		return root==null?0:Math.max(maxDepth(root.left),maxDepth(root.right))+1;
	}
}
