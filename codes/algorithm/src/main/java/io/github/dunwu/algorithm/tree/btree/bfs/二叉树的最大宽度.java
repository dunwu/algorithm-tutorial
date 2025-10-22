package io.github.dunwu.algorithm.tree.btree.bfs;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;

/**
 * <a href="https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/">104. 二叉树的最大深度</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-18
 */
public class 二叉树的最大宽度 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(4, s.widthOfBinaryTree(TreeNode.buildTree(1, 3, 2, 5, 3, null, 9)));
        Assertions.assertEquals(7, s.widthOfBinaryTree(TreeNode.buildTree(1, 3, 2, 5, null, null, 9, 6, null, 7)));
    }

    static class Solution {

        public static class NodeInfo {

            public int id;
            public TreeNode node;

            public NodeInfo(int id, TreeNode node) {
                this.id = id;
                this.node = node;
            }

            @Override
            public String toString() {
                return "NodeInfo{" +
                    "id=" + id +
                    ", node=" + node.val +
                    '}';
            }

        }

        public int widthOfBinaryTree(TreeNode root) {

            if (root == null) return 0;

            int level = 0;
            int maxWidth = 0;
            LinkedList<NodeInfo> queue = new LinkedList<>();
            queue.offer(new NodeInfo(1, root));
            while (!queue.isEmpty()) {
                level++;
                int size = queue.size();
                NodeInfo left = null, right = null;
                for (int i = 0; i < size; i++) {
                    NodeInfo info = queue.poll();
                    if (info == null) { continue; }
                    if (left == null) { left = info; }
                    right = info;
                    if (info.node.left != null) {
                        queue.offer(new NodeInfo(2 * info.id, info.node.left));
                    }
                    if (info.node.right != null) {
                        queue.offer(new NodeInfo(2 * info.id + 1, info.node.right));
                    }
                }
                // System.out.printf("level: %d, left: %s, right: %s\n", level, left.toString(), right.toString());
                int width = right.id - left.id + 1;
                maxWidth = Math.max(maxWidth, width);
            }
            return maxWidth;
        }

    }

}
