package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/">236. 二叉树的最近公共祖先</a>
 * <a
 * href="https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/er-cha-shu-de-zui-jin-gong-gong-zu-xian-by-leetc-2/">解题思路</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2020-01-28
 */
public class 二叉树的最近公共祖先 {

    public static void main(String[] args) {

        Solution s = new Solution();
        TreeNode input = TreeNode.buildTree(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5);
        TreeNode output1 = s.lowestCommonAncestor(input, TreeNode.find(input, 2), TreeNode.find(input, 8));
        Assertions.assertNotNull(output1);
        Assertions.assertEquals(6, output1.val);
        TreeNode output2 = s.lowestCommonAncestor(input, TreeNode.find(input, 2), TreeNode.find(input, 4));
        Assertions.assertNotNull(output2);
        Assertions.assertEquals(2, output2.val);

        Solution2 s2 = new Solution2();
        TreeNode input2 = TreeNode.buildTree(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5);
        TreeNode output3 = s2.lowestCommonAncestor(input2, TreeNode.find(input2, 2), TreeNode.find(input2, 8));
        Assertions.assertNotNull(output3);
        Assertions.assertEquals(6, output3.val);
        TreeNode output4 = s2.lowestCommonAncestor(input2, TreeNode.find(input2, 2), TreeNode.find(input2, 4));
        Assertions.assertNotNull(output4);
        Assertions.assertEquals(2, output4.val);
    }

    static class Solution {

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            if (root == null) return null;
            if (root == p || root == q) return root;

            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            if (left != null && right != null) { return root; }
            return left != null ? left : right;
        }

    }

    static class Solution2 {

        private TreeNode res = null;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            res = null;
            return find(root, p.val, q.val);
        }

        TreeNode find(TreeNode root, int p, int q) {
            if (root == null) { return null; }
            // 如果已经找到 LCA 节点，直接返回
            if (res != null) { return res; }

            if (root.val == p || root.val == q) return root;

            TreeNode left = find(root.left, p, q);
            TreeNode right = find(root.right, p, q);

            if (left != null && right != null) {
                // 当前节点是 LCA 节点，记录下来
                res = root;
                return res;
            }
            return left != null ? left : right;
        }

    }

}
