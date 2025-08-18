package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import io.github.dunwu.algorithm.tree.TreeUtils;
import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/average-of-levels-in-binary-tree/">637. 二叉树的层平均值</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-18
 */
public class 二叉树的层平均值 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertArrayEquals(new Double[] { 3.00000, 14.50000, 11.00000 },
            s.averageOfLevels(TreeUtils.buildTree(3, 9, 20, null, null, 15, 7)).toArray());
        Assertions.assertArrayEquals(new Double[] { 3.00000, 14.50000, 11.00000 },
            s.averageOfLevels(TreeUtils.buildTree(3, 9, 20, 15, 7)).toArray());
    }

    static class Solution {

        public List<Double> averageOfLevels(TreeNode root) {
            if (root == null) { return new LinkedList<>(); }

            List<Double> res = new LinkedList<>();
            LinkedList<TreeNode> q = new LinkedList<>();
            q.offer(root);

            while (!q.isEmpty()) {
                double sum = 0;
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = q.poll();
                    sum += node.val;
                    if (node.left != null) { q.offer(node.left); }
                    if (node.right != null) { q.offer(node.right); }
                }
                res.add(sum / size);
            }
            return res;
        }

    }

}
