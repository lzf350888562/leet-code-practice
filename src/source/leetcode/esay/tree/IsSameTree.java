package source.leetcode.esay.tree;

/**
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * @author Jinx
 * @Date 2021/3/26
 */
public class IsSameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		return isSameNode(p,q);
	}
	public static boolean isSameNode(TreeNode p, TreeNode q){
		if (p==null||q==null){
			if (p==null&&q==null){
				return true;
			}else {
				return false;
			}
		}else if (p.val==q.val){
			return isSameNode(p.left,q.left)&&isSameNode(p.right,q.right);
		}else {
			return false;
		}
	}
}
