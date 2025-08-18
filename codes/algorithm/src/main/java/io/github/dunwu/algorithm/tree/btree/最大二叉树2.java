package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import io.github.dunwu.algorithm.tree.TreeUtils;
import org.junit.jupiter.api.Assertions;

import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/maximum-binary-tree-ii/">998. 最大二叉树 II</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-18
 */
public class 最大二叉树2 {

    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode input = TreeUtils.buildTree(4, 1, 3, null, null, 2);
        TreeNode output = s.insertIntoMaxTree(input, 5);
        List<Integer> result1 = TreeUtils.toValueList(output);
        Assertions.assertArrayEquals(new Integer[] { 5, 4, null, 1, 3, null, null, 2 }, result1.toArray());

        TreeNode input2 = TreeUtils.buildTree(5, 2, 4, null, 1);
        TreeNode output2 = s.insertIntoMaxTree(input2, 3);
        List<Integer> result2 = TreeUtils.toValueList(output2);
        Assertions.assertArrayEquals(new Integer[] { 5, 2, 4, null, 1, null, 3 }, result2.toArray());
    }

    static class Solution {

        public TreeNode insertIntoMaxTree(TreeNode root, int val) {
            if (root == null) return new TreeNode(val);
            if (val > root.val) {
                TreeNode node = new TreeNode(val);
                node.left = root;
                return node;
            } else {
                root.right = insertIntoMaxTree(root.right, val);
            }
            return root;
        }

    }

}
