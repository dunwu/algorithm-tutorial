package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import io.github.dunwu.algorithm.tree.TreeUtils;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree/">1161. 最大层内元素和</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-18
 */
public class 最大层内元素和 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(2,
            s.maxLevelSum(TreeUtils.buildTree(1, 7, 0, 7, -8, null, null)));
        Assertions.assertEquals(2,
            s.maxLevelSum(TreeUtils.buildTree(989, null, 10250, 98693, -89388, null, null, null, -32127)));
        Assertions.assertEquals(3,
            s.maxLevelSum(TreeUtils.buildTree(-100, -200, -300, -20, -5, -10, null)));
    }

    static class Solution {

        public int maxLevelSum(TreeNode root) {

            if (root == null) { return 0; }

            int depth = 1;
            int maxDepth = 1;
            int maxSum = Integer.MIN_VALUE;
            LinkedList<TreeNode> q = new LinkedList<>();
            q.offer(root);

            while (!q.isEmpty()) {
                int sum = 0;
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = q.poll();
                    sum += node.val;
                    if (node.left != null) { q.offer(node.left); }
                    if (node.right != null) { q.offer(node.right); }
                }
                if (sum > maxSum) {
                    maxSum = sum;
                    maxDepth = depth;
                }
                depth++;
            }
            return maxDepth;
        }

    }

}
