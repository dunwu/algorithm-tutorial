package io.github.dunwu.algorithm.tree.bstree;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes">783. 二叉搜索树节点最小距离</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2020-06-18
 */
public class 二叉搜索树节点最小距离 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(1, s.minDiffInBST(TreeNode.buildTree(4, 2, 6, 1, 3)));
        Assertions.assertEquals(1, s.minDiffInBST(TreeNode.buildTree(1, 0, 48, null, null, 12, 49)));
    }

    static class Solution {

        private int pre;
        private int res;

        public int minDiffInBST(TreeNode root) {
            pre = -1;
            res = Integer.MAX_VALUE;
            dfs(root);
            return res;
        }

        public void dfs(TreeNode root) {
            // base case
            if (root == null) { return; }

            // 【前序】
            dfs(root.left);

            // 【中序】中序保证递增有序
            if (pre != -1) {
                res = Math.min(res, Math.abs(root.val - pre));
            }
            pre = root.val;

            // 【后序】
            dfs(root.right);
        }

    }

}
