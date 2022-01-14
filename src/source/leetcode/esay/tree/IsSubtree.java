package source.leetcode.esay.tree;

/**
 * 572. 另一棵树的子树
 * 检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。
 */
public class IsSubtree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //主递归函数也要判空 防止空指针调用
        if(root == null && subRoot == null){
            return true;
        }else{
            if(root == null){
                return false;
            }
            if(subRoot == null){
                return false;
            }
        }
        //root的每个节点与subRoot比较
        return compare(root,subRoot) || isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
    public boolean compare(TreeNode node, TreeNode subRoot){
        if( node == null && subRoot == null ){
            return true;
        }else if(node != null && subRoot != null){
            if(node.val == subRoot.val){
                return compare(node.left,subRoot.left) && compare(node.right,subRoot.right);
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}
