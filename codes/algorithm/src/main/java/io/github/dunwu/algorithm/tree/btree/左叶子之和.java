package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import io.github.dunwu.algorithm.tree.TreeUtils;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/sum-of-left-leaves/">404. 左叶子之和</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-15
 */
public class 左叶子之和 {

    public static void main(String[] args) {
        Assertions.assertEquals(24,
            new Solution().sumOfLeftLeaves(TreeUtils.buildTree(3, 9, 20, null, null, 15, 7)));

        Assertions.assertEquals(4,
            new Solution().sumOfLeftLeaves(TreeUtils.buildTree(1, 2, 3, 4, 5)));

        Assertions.assertEquals(0,
            new Solution().sumOfLeftLeaves(TreeUtils.buildTree(1)));
    }

    static class Solution {

        int sum = 0;

        public int sumOfLeftLeaves(TreeNode root) {
            traverse(root);
            return sum;
        }

        public void traverse(TreeNode root) {
            if (root == null) { return; }
            if (root.left != null &&
                root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            }
            traverse(root.left);
            traverse(root.right);
        }

    }

}
