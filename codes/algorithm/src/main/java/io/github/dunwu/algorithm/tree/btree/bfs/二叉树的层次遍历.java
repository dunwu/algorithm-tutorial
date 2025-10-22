package io.github.dunwu.algorithm.tree.btree.bfs;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode-cn.com/problems/binary-tree-level-order-traversal/">二叉树的层次遍历</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-18
 */
public class 二叉树的层次遍历 {

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = TreeNode.buildTree(3, 9, 20, null, null, 15, 7);
        List<List<Integer>> expectList = new LinkedList<>();
        expectList.add(Arrays.asList(3));
        expectList.add(Arrays.asList(9, 20));
        expectList.add(Arrays.asList(15, 7));
        Assertions.assertArrayEquals(expectList.toArray(), s.levelOrder(root).toArray());

        Solution s2 = new Solution();
        TreeNode root2 = TreeNode.buildTree(1);
        List<List<Integer>> expectList2 = new LinkedList<>();
        expectList2.add(Arrays.asList(1));
        Assertions.assertArrayEquals(expectList2.toArray(), s2.levelOrder(root2).toArray());

        Solution s3 = new Solution();
        TreeNode root3 = TreeNode.buildTree();
        Assertions.assertArrayEquals(new LinkedList<>().toArray(), s3.levelOrder(root3).toArray());
    }

    static class Solution {

        public List<List<Integer>> levelOrder(TreeNode root) {

            LinkedList<List<Integer>> res = new LinkedList<>();
            if (root == null) { return res; }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            // while 循环控制从上向下一层层遍历
            while (!queue.isEmpty()) {
                int size = queue.size();
                // 记录这一层的节点值
                List<Integer> level = new LinkedList<>();
                // for 循环控制每一层从左向右遍历
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    level.add(node.val);
                    if (node.left != null) { queue.offer(node.left); }
                    if (node.right != null) { queue.offer(node.right); }
                }
                res.add(level);
            }
            return res;
        }

    }

}
