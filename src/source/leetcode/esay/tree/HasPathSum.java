package source.leetcode.esay.tree;

/**
 * 112. 路径总和
 * @Date 2021/3/27
 */
public class HasPathSum {
	public boolean hasPathSum(TreeNode root, int targetSum) {
		if(root==null)
			return false;
		if(root.val==targetSum&&root.left==null&&root.right==null)
			return true;
		return hasPathSum(root.left,targetSum-root.val)||hasPathSum(root.right,targetSum-root.val);
	}
}
