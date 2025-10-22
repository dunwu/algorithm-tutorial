package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

/**
 * <code>236. 二叉树的最近公共祖先</code> 算法实现
 *
 * @see <a href="https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/">236. 二叉树的最近公共祖先</a>
 * @see <a
 * href="https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/er-cha-shu-de-zui-jin-gong-gong-zu-xian-by-leetc-2/">解题思路</a>
 */
public class 二叉树的最近公共祖先 {

    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTree(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
        TreeNode p = TreeNode.find(root, 5);
        TreeNode q = TreeNode.find(root, 1);
        TreeNode treeNode = lowestCommonAncestor(root, p, q);
        Assertions.assertNotNull(treeNode);
        Assertions.assertEquals(3, treeNode.val);
        System.out.println("公共祖先节点 = " + treeNode.val);

        TreeNode p2 = TreeNode.find(root, 5);
        TreeNode q2 = TreeNode.find(root, 4);
        TreeNode treeNode2 = lowestCommonAncestor(root, p2, q2);
        Assertions.assertNotNull(treeNode2);
        Assertions.assertEquals(5, treeNode2.val);
        System.out.println("公共祖先节点 = " + treeNode2.val);
    }

    /**
     * 递归方式求解
     * <p>
     * 时间复杂度：O(N) 线性级
     * <p>
     * 空间复杂度：O(2) 常数级
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) { return null; }
        if (root == p || root == q) { return root; }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left == null && right == null) {
            return null;
        }
        return left == null ? right : left;
    }

}
