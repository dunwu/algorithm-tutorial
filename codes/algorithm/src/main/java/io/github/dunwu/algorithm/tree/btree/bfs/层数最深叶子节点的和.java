package io.github.dunwu.algorithm.tree.btree.bfs;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/deepest-leaves-sum/">1302. 层数最深叶子节点的和</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-18
 */
public class 层数最深叶子节点的和 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(15,
            s.deepestLeavesSum(TreeNode.buildTree(1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8)));
        Assertions.assertEquals(19,
            s.deepestLeavesSum(TreeNode.buildTree(6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5)));
    }

    static class Solution {

        public int deepestLeavesSum(TreeNode root) {

            if (root == null) { return 0; }

            int sum = 0;
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                sum = 0;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    sum += node.val;
                    if (node.left != null) { queue.offer(node.left); }
                    if (node.right != null) { queue.offer(node.right); }
                }
            }
            return sum;
        }

    }

}
