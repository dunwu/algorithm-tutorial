package io.github.dunwu.algorithm.tree.bstree;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/convert-bst-to-greater-tree/">538. 把二叉搜索树转换为累加树</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-10-22
 */
public class 二叉搜索树中的搜索 {

    public static void main(String[] args) {

        Solution s = new Solution();

        TreeNode input1 = TreeNode.buildTree(4, 2, 7, 1, 3);
        TreeNode output1 = s.searchBST(input1, 2);
        Assertions.assertArrayEquals(new Integer[] { 2, 1, 3 }, TreeNode.toValueList(output1).toArray());

        TreeNode output2 = s.searchBST(input1, 5);
        Assertions.assertNull(output2);
    }

    static class Solution {

        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null) { return null; }
            if (root.val == val) {
                return root;
            } else if (root.val < val) {
                return searchBST(root.right, val);
            } else {
                return searchBST(root.left, val);
            }
        }

    }

}
