package io.github.dunwu.algorithm.tree.btree.divide;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/**
 * <a href="https://leetcode.cn/problems/delete-nodes-and-return-forest/">1110. 删点成林</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-18
 */
public class 删点成林 {

    public static void main(String[] args) {
        Solution s = new Solution();

        List<TreeNode> output = s.delNodes(TreeNode.buildTree(1, 2, 3, 4, 5, 6, 7), new int[] { 3, 5 });
        List<TreeNode> expect = new ArrayList<>();
        expect.add(TreeNode.buildTree(1, 2, null, 4));
        expect.add(TreeNode.buildTree(6));
        expect.add(TreeNode.buildTree(7));
        for (int i = 0; i < output.size(); i++) {
            Assertions.assertEquals(expect.get(i), output.get(i));
        }

        List<TreeNode> output2 = s.delNodes(TreeNode.buildTree(1, 2, 4, null, 3), new int[] { 3 });
        List<TreeNode> expect2 = new ArrayList<>();
        expect2.add(TreeNode.buildTree(1, 2, 4));
        for (int i = 0; i < output2.size(); i++) {
            Assertions.assertEquals(expect2.get(i), output2.get(i));
        }
    }

    static class Solution {

        private Set<Integer> set = null;
        private List<TreeNode> res = null;

        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            if (root == null) { return new ArrayList<>(); }
            set = new HashSet<>();
            res = new LinkedList<>();
            for (int val : to_delete) {
                set.add(val);
            }
            traverse(root, false);
            return res;
        }

        public TreeNode traverse(TreeNode root, boolean hasParent) {
            if (root == null) { return null; }
            boolean deleted = set.contains(root.val);
            if (!deleted && !hasParent) {
                res.add(root);
            }
            root.left = traverse(root.left, !deleted);
            root.right = traverse(root.right, !deleted);
            return deleted ? null : root;
        }

    }

}
