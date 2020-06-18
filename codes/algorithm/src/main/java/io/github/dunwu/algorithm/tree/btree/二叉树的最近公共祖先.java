package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeUtils;
import io.github.dunwu.algorithm.tree.btree.TreeNode;

/**
 * <code>236. 二叉树的最近公共祖先</code> 算法实现
 * <p>
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * 示例 1:
 * <pre>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * </pre>
 * 示例 2:
 * <pre>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 * </pre>
 * 说明:
 * <pre>
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 * </pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/">236. 二叉树的最近公共祖先</a>
 */
public class 二叉树的最近公共祖先 {

    private static TreeNode ans = null;

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildTree(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        TreeNode treeNode = lowestCommonAncestor(root, p, q);
        System.out.println("公共祖先节点 = " + treeNode.val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recurseTree(root, p, q);
        return ans;
    }

    private static boolean recurseTree(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean lson = recurseTree(root.left, p, q);
        boolean rson = recurseTree(root.right, p, q);
        boolean flag = (root.val == p.val || root.val == q.val) && (lson || rson);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) { ans = root; }
        return (root.val == p.val || root.val == q.val) || (lson || rson);
    }

}
