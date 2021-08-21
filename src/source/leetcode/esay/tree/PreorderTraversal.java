package source.leetcode.esay.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 前序遍历
 * @author lzf
 * @Date 2021/8/21
 */
public class PreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<>();
		if(root==null){
			return res;
		}
		pre(root,res);
		return res;
	}
	public void pre(TreeNode node,List<Integer> res){
		res.add(node.val);
		if (node.left!=null){
			pre(node.left,res);
		}
		if (node.right!=null){
			pre(node.right,res);
		}
	}
}
