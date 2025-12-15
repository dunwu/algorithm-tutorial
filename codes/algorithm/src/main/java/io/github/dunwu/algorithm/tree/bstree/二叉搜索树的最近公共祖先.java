package io.github.dunwu.algorithm.tree.bstree;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/">235. 二叉搜索树的最近公共祖先</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-10-22
 */
public class 二叉搜索树的最近公共祖先 {

    public static void main(String[] args) {

        Solution s = new Solution();

        TreeNode root = TreeNode.buildTree(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5);

        TreeNode node1 = s.lowestCommonAncestor(root, TreeNode.find(root, 2), TreeNode.find(root, 8));
        Assertions.assertNotNull(node1);
        Assertions.assertEquals(6, node1.val);

        TreeNode node2 = s.lowestCommonAncestor(root, TreeNode.find(root, 2), TreeNode.find(root, 4));
        Assertions.assertNotNull(node2);
        Assertions.assertEquals(2, node2.val);
    }

    static class Solution {

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return null;
            if (p.val > q.val) {
                // 保证 p.val <= q.val，便于后续情况讨论
                return lowestCommonAncestor(root, q, p);
            }
            if (root.val >= p.val && root.val <= q.val) {
                // p <= root <= q
                // 即 p 和 q 分别在 root 的左右子树，那么 root 就是 LCA
                return root;
            }
            if (root.val > q.val) {
                // p 和 q 都在 root 的左子树，那么 LCA 在左子树
                return lowestCommonAncestor(root.left, p, q);
            } else {
                // p 和 q 都在 root 的右子树，那么 LCA 在右子树
                return lowestCommonAncestor(root.right, p, q);
            }
        }

    }

}
