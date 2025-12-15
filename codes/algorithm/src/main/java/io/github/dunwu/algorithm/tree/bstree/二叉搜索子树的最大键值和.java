package io.github.dunwu.algorithm.tree.bstree;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/unique-binary-search-trees/">96. 不同的二叉搜索树</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-10-22
 */
public class 二叉搜索子树的最大键值和 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(20,
            s.maxSumBST(TreeNode.buildTree(1, 4, 3, 2, 4, 2, 5, null, null, null, null, null, null, 4, 6)));
        Assertions.assertEquals(2, s.maxSumBST(TreeNode.buildTree(4, 3, null, 1, 2)));
        Assertions.assertEquals(0, s.maxSumBST(TreeNode.buildTree(-4, -2, -5)));
        Assertions.assertEquals(6, s.maxSumBST(TreeNode.buildTree(2, 1, 3)));
        Assertions.assertEquals(7, s.maxSumBST(TreeNode.buildTree(5, 4, 8, 3, null, 6, 3)));
    }

    static class Solution {

        // 记录 BST 最大节点之和
        private int maxSum = 0;

        public int maxSumBST(TreeNode root) {
            maxSum = 0;
            findMaxMinSum(root);
            return maxSum;
        }

        // 计算以 root 为根的二叉树的最大值、最小值、节点和
        int[] findMaxMinSum(TreeNode root) {
            // base case
            if (root == null) {
                return new int[] {
                    1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0
                };
            }

            // 递归计算左右子树
            int[] left = findMaxMinSum(root.left);
            int[] right = findMaxMinSum(root.right);

            // ******* 后序位置 *******
            // 通过 left 和 right 推导返回值
            // 并且正确更新 maxSum 变量
            int[] res = new int[4];
            // 这个 if 在判断以 root 为根的二叉树是不是 BST
            if (left[0] == 1 && right[0] == 1 &&
                root.val > left[2] && root.val < right[1]) {
                // 以 root 为根的二叉树是 BST
                res[0] = 1;
                // 计算以 root 为根的这棵 BST 的最小值
                res[1] = Math.min(left[1], root.val);
                // 计算以 root 为根的这棵 BST 的最大值
                res[2] = Math.max(right[2], root.val);
                // 计算以 root 为根的这棵 BST 所有节点之和
                res[3] = left[3] + right[3] + root.val;
                // 更新全局变量
                maxSum = Math.max(maxSum, res[3]);
            } else {
                // 以 root 为根的二叉树不是 BST
                res[0] = 0;
                // 其他的值都没必要计算了，因为用不到
            }

            return res;
        }

    }

}
