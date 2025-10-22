package io.github.dunwu.algorithm.tree.btree.traverse;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/add-one-row-to-tree/">623. 在二叉树中增加一行</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-15
 */
public class 在二叉树中增加一行 {

    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTree(4, 2, 6, 3, 1, 5);
        TreeNode newRoot = new Solution().addOneRow(root, 1, 2);
        List<Integer> list = TreeNode.toValueList(newRoot);
        Assertions.assertArrayEquals(new Integer[] { 4, 1, 1, 2, null, null, 6, 3, 1, 5 }, list.toArray());

        TreeNode root2 = TreeNode.buildTree(4, 2, 6, 3, 1, 5);
        TreeNode newRoot2 = new Solution().addOneRow(root2, 1, 1);
        List<Integer> list2 = TreeNode.toValueList(newRoot2);
        Assertions.assertArrayEquals(new Integer[] { 1, 4, null, 2, 6, 3, 1, 5 }, list2.toArray());
    }

    static class Solution {

        public TreeNode addOneRow(TreeNode root, int val, int depth) {
            if (root == null) { return root; }
            if (depth == 1) {
                TreeNode newRoot = new TreeNode(val);
                newRoot.left = root;
                return newRoot;
            }
            LinkedList<TreeNode> q = new LinkedList<>();
            int level = 1;
            q.offer(root);
            while (!q.isEmpty()) {

                int size = q.size();
                if (level == depth - 1) {
                    for (int i = 0; i < size; i++) {
                        TreeNode node = q.poll();
                        TreeNode left = node.left;
                        node.left = new TreeNode(val);
                        node.left.left = left;

                        TreeNode right = node.right;
                        node.right = new TreeNode(val);
                        node.right.right = right;
                    }
                    break;
                }

                // 层序遍历
                for (int i = 0; i < size; i++) {
                    TreeNode node = q.poll();
                    if (node.left != null) {
                        q.offer(node.left);
                    }
                    if (node.right != null) {
                        q.offer(node.right);
                    }
                }

                level++;
            }
            return root;
        }

    }

}
