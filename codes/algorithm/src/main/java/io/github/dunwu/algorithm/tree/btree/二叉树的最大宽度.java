package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import io.github.dunwu.algorithm.tree.TreeUtils;
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
        Assertions.assertEquals(4, s.widthOfBinaryTree(TreeUtils.buildTree(1, 3, 2, 5, 3, null, 9)));
        Assertions.assertEquals(7, s.widthOfBinaryTree(TreeUtils.buildTree(1, 3, 2, 5, null, null, 9, 6, null, 7)));
    }

    static class Solution {

        public static class NodeInfo {

            public int id;
            public TreeNode node;

            public NodeInfo(int id, TreeNode node) {
                this.id = id;
                this.node = node;
            }

        }

        public int widthOfBinaryTree(TreeNode root) {

            int maxWidth = 0;
            LinkedList<NodeInfo> q = new LinkedList<>();
            q.offer(new NodeInfo(1, root));

            while (!q.isEmpty()) {
                int size = q.size();
                int begin = 0, end = 0;
                for (int i = 0; i < size; i++) {
                    NodeInfo cur = q.poll();
                    if (i == 0) {
                        begin = cur.id;
                    }
                    if (i == size - 1) {
                        end = cur.id;
                    }
                    if (cur.node.left != null) {
                        q.offer(new NodeInfo(cur.id * 2, cur.node.left));
                    }
                    if (cur.node.right != null) {
                        q.offer(new NodeInfo(cur.id * 2 + 1, cur.node.right));
                    }
                }
                int width = end - begin + 1;
                maxWidth = Math.max(maxWidth, width);
            }
            return maxWidth;
        }

    }

}
