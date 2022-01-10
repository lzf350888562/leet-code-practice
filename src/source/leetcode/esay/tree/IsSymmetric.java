package source.leetcode.esay.tree;

/**
 * 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 * @Date 2021/3/27
 */
public class IsSymmetric {
	public boolean isSymmetric(TreeNode root) {
		return nodeSymmetric(root.left,root.right);
	}

	private static boolean nodeSymmetric(TreeNode left,TreeNode right) {
		if (left==null||right==null){
			if (left==null&&right==null){
				return true;
			}else {
				return false;
			}
		}
		return left.val==right.val&&nodeSymmetric(left.left,right.right)&&nodeSymmetric(left.right,right.left);
	}


}
