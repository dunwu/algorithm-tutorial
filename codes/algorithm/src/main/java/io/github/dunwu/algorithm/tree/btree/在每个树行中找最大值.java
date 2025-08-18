package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import io.github.dunwu.algorithm.tree.TreeUtils;
import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/find-largest-value-in-each-tree-row/">515. 在每个树行中找最大值</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-18
 */
public class 在每个树行中找最大值 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertArrayEquals(new Integer[] { 1, 3, 9 },
            s.largestValues(TreeUtils.buildTree(1, 3, 2, 5, 3, null, 9)).toArray());
        Assertions.assertArrayEquals(new Integer[] { 1, 3, 9 },
            s.largestValues(TreeUtils.buildTree(1, 3)).toArray());
    }

    static class Solution {

        public List<Integer> largestValues(TreeNode root) {

            if (root == null) { return new LinkedList<>(); }

            List<Integer> res = new LinkedList<>();
            LinkedList<TreeNode> q = new LinkedList<>();
            q.offer(root);

            while (!q.isEmpty()) {
                int max = Integer.MIN_VALUE;
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = q.poll();
                    if (node == null) { continue; }
                    max = Math.max(max, node.val);
                    if (node.left != null) { q.offer(node.left); }
                    if (node.right != null) { q.offer(node.right); }
                }
                res.add(max);
            }
            return res;
        }

    }

}
