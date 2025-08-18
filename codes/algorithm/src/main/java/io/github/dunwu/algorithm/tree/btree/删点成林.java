package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import io.github.dunwu.algorithm.tree.TreeUtils;
import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/delete-nodes-and-return-forest/">1110. 删点成林</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-18
 */
public class 删点成林 {

    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode input = TreeUtils.buildTree(1, 2, 3, 4, 5, 6, 7);
        List<TreeNode> output = s.delNodes(input, new int[] { 3, 5 });
        // List<Integer> result1 = TreeUtils.toValueList(output);
        // Assertions.assertArrayEquals(new Integer[] { 5, 4, null, 1, 3, null, null, 2 }, result1.toArray());

    }

    static class Solution {

        List<TreeNode> res = new LinkedList<>();

        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            if (root == null) return new LinkedList<>();

            if (isDel(root.val, to_delete)) {
                if (root.left == null && root.right == null) {
                    root = null;
                    return new LinkedList<>();
                } else {

                }
            } else {
                res.addAll(delNodes(root.left, to_delete));
                res.addAll(delNodes(root.right, to_delete));
            }
            return res;
        }

        public boolean isDel(int val, int[] to_delete) {
            for (int num : to_delete) {
                if (val == num) return true;
            }
            return false;
        }

    }

}
