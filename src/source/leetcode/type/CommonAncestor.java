package source.leetcode.type;

import source.leetcode.esay.tree.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 公共祖先
 * 236.  二叉树的最近公共祖先1
 * 1676. 二叉树的最近公共祖先2 vip
 * 1644. 二叉树的最近公共祖先3 vip
 * 235. 二叉搜索树的最近公共祖先
 * 1650. 二叉树的最近公共祖先4 vip
 */
public class CommonAncestor {
    /**
     * 236. 二叉树的最近公共祖先  (不重复, 两个节点的祖先, 节点必存在)
     * 变相先序.  递归, 每一层递归若找到
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if (root.val == p.val || root.val == q.val) { //一父一子的情况
            return root;
        }
        TreeNode left = lowestCommonAncestor1(root.left, p, q);
        TreeNode right = lowestCommonAncestor1(root.right, p, q);
        if(left != null && right != null){          //一左一右情况
            return root;
        }
        //除了上面情况外, 要么在左, 要么在右
        return left != null ? left : right;
    }

    /**
     * 1676. 二叉树的最近公共祖先  (不重复, 若干节点的祖先, 节点必存在)
     * 对236改进 加入set记录是否存在
     */
    private Set<Integer> set = null;
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode[] nodes) {
        if(this.set == null){   //首次进行初始化,  也可以将递归逻辑单独一个函数
            set = new HashSet<>(nodes.length);
            for (TreeNode node : nodes) {
                set.add(node.val);
            }
        }
        if(root == null){
            return null;
        }
        if (set.contains(root.val)) { //一父多子的情况
            return root;
        }
        TreeNode left = lowestCommonAncestor2(root.left, nodes);
        TreeNode right = lowestCommonAncestor2(root.right, nodes);
        if(left != null && right != null){          //左右都存在情况
            return root;
        }
        //除了上面情况外, 要么在左, 要么在右
        return left != null ? left : right;
    }

    /**
     * 1644. 二叉树的最近公共祖先  (不重复, 两个节点的祖先, 节点可能不存在)
     * 对236改进, 不能直接判断一父一子的情况了, 需要全遍历完之后才能判断
     */
    private boolean foundP = false, foundQ = false; //记录 p 和 q 是否存在于二叉树中
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = find(root, p.val, q.val);
        // p 和 q 都存在二叉树中，才有公共祖先
        if (foundP && foundQ) {
            return res;
        }
        return null;
    }
    private TreeNode find(TreeNode root, int p, int q) {
        if(root == null){
            return null;
        }
        TreeNode left = find(root.left, p, q);
        TreeNode right = find(root.right, p, q);
        if(left != null && right != null){          //一左一右情况
            return root;
        }
        if (root.val == p || root.val == q) { //一父一子的情况, 需要等左右两边find完(如果存在节点则对标记进行改变)
            // 找到了，记录一下
            if (root.val == p) foundP = true;
            if (root.val == q) foundQ = true;
            return root;
        }
        //除了上面情况外, 要么在左, 要么在右
        return left != null ? left : right;
    }

    /**
     * 235. 二叉搜索树的最近公共祖先
     * BST , 依附左小右大特性判断, 不需要遍历
     */
    TreeNode lowestCommonAncestor4(TreeNode root, TreeNode p, TreeNode q) {
        // 保证 val1 较小，val2 较大
        int val1 = Math.min(p.val, q.val);
        int val2 = Math.max(p.val, q.val);
        return find1(root, val1, val2);
    }
    TreeNode find1(TreeNode root, int val1, int val2) {
        if (root == null) {
            return null;
        }
        if (root.val > val2) {
            // 当前节点太大，去左子树找
            return find1(root.left, val1, val2);
        }
        if (root.val < val1) {
            // 当前节点太小，去右子树找
            return find1(root.right, val1, val2);
        }
        // val1 <= root.val <= val2
        // 则当前节点就是最近公共祖先
        return root;
    }

    /**
     * 1650. 二叉树的最近公共祖先4  (每个节点带parent指针指向父节点)
     * 不是二叉树的范畴, 实际上就是求两个链表的交点.
     */
}
