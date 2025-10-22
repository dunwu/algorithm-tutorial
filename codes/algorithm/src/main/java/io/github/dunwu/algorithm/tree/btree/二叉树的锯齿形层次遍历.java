package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/">103. 二叉树的锯齿形层次遍历</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-18
 */
public class 二叉树的锯齿形层次遍历 {

    public static void main(String[] args) {

        Solution s = new Solution();

        TreeNode root = TreeNode.buildTree(3, 9, 20, null, null, 15, 7);
        List<List<Integer>> expect = new LinkedList<>();
        expect.add(Arrays.asList(3));
        expect.add(Arrays.asList(20, 9));
        expect.add(Arrays.asList(15, 7));
        Assertions.assertArrayEquals(expect.toArray(), s.zigzagLevelOrder(root).toArray());

        TreeNode root2 = TreeNode.buildTree(1);
        List<List<Integer>> expect2 = new LinkedList<>();
        expect2.add(Arrays.asList(1));
        Assertions.assertArrayEquals(expect2.toArray(), s.zigzagLevelOrder(root2).toArray());

        TreeNode root3 = TreeNode.buildTree();
        List<List<Integer>> expect3 = new LinkedList<>();
        Assertions.assertArrayEquals(expect3.toArray(), s.zigzagLevelOrder(root3).toArray());
    }

    static class Solution {

        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

            if (root == null) { return new LinkedList<>(); }

            LinkedList<TreeNode> q = new LinkedList<>();
            LinkedList<List<Integer>> res = new LinkedList<>();
            q.offer(root);

            boolean reverse = false;
            while (!q.isEmpty()) {
                int size = q.size();
                List<Integer> cur = new LinkedList<>();

                for (int i = 0; i < size; i++) {
                    TreeNode node = q.poll();
                    cur.add(node.val);
                    if (node.left != null) { q.offer(node.left); }
                    if (node.right != null) { q.offer(node.right); }
                }
                if (reverse) {
                    Collections.reverse(cur);
                }
                res.add(cur);
                reverse = !reverse;
            }

            return res;
        }

    }

}
