package io.github.dunwu.algorithm.tree.btree.bfs;

import io.github.dunwu.algorithm.tree.TreeNode;
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
            s.largestValues(TreeNode.buildTree(1, 3, 2, 5, 3, null, 9)).toArray());
        Assertions.assertArrayEquals(new Integer[] { 1, 3 },
            s.largestValues(TreeNode.buildTree(1, 2, 3)).toArray());
    }

    static class Solution {

        public List<Integer> largestValues(TreeNode root) {

            if (root == null) { return new LinkedList<>(); }

            LinkedList<Integer> res = new LinkedList<>();
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                int max = Integer.MIN_VALUE;
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    max = Math.max(max, node.val);
                    if (node.left != null) { queue.offer(node.left); }
                    if (node.right != null) { queue.offer(node.right); }
                }
                res.add(max);
            }

            return res;
        }

    }

}
