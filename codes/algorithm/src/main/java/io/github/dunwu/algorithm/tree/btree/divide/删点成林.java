package io.github.dunwu.algorithm.tree.btree.divide;

import io.github.dunwu.algorithm.tree.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/delete-nodes-and-return-forest/">1110. 删点成林</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-18
 */
public class 删点成林 {

    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode input = TreeNode.buildTree(1, 2, 3, 4, 5, 6, 7);
        List<TreeNode> output = s.delNodes(input, new int[] { 3, 5 });
        for (TreeNode tree : output) {
            System.out.println(TreeNode.toValueList(tree));
        }

        // List<Integer> result1 = TreeNode.toValueList(output);
        // Assertions.assertArrayEquals(new Integer[] { 5, 4, null, 1, 3, null, null, 2 }, result1.toArray());
    }

    static class Solution {

        Set<Integer> delValSet = new HashSet<>();
        List<TreeNode> res = new LinkedList<>();

        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            for (int val : to_delete) {
                delValSet.add(val);
            }
            traverse(root, false);
            return res;
        }

        public TreeNode traverse(TreeNode root, boolean hasParent) {
            if (root == null) { return null; }
            boolean deleted = delValSet.contains(root.val);
            if (!deleted && !hasParent) {
                res.add(root);
            }
            root.left = traverse(root.left, !deleted);
            root.right = traverse(root.right, !deleted);
            return deleted ? null : root;
        }

    }

}
