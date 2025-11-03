package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/count-complete-tree-nodes/">222. 完全二叉树的节点个数</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-07-06
 */
public class 完全二叉树的节点个数 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(6, s.countNodes(TreeNode.buildTree(1, 2, 3, 4, 5, 6)));
        Assertions.assertEquals(0, s.countNodes(TreeNode.buildTree()));
        Assertions.assertEquals(1, s.countNodes(TreeNode.buildTree(1)));
    }

    static class Solution {

        public int countNodes(TreeNode root) {
            if (root == null) { return 0; }
            return countNodes(root.left) + countNodes(root.right) + 1;
        }

    }

}
