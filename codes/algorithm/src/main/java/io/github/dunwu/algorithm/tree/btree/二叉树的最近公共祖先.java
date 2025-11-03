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

        Solution s = new Solution();

        TreeNode root = TreeNode.buildTree(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
        TreeNode node1 = s.lowestCommonAncestor(root, TreeNode.find(root, 5), TreeNode.find(root, 1));
        Assertions.assertNotNull(node1);
        Assertions.assertEquals(3, node1.val);

        TreeNode node2 = s.lowestCommonAncestor(root, TreeNode.find(root, 5), TreeNode.find(root, 4));
        Assertions.assertNotNull(node2);
        Assertions.assertEquals(5, node2.val);
    }

    static class Solution {

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            if (root == null) { return null; }
            if (root == p || root == q) { return root; }

            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left != null && right != null) { return root; }
            if (left == null && right == null) { return null; }
            return left == null ? right : left;
        }

    }

}
