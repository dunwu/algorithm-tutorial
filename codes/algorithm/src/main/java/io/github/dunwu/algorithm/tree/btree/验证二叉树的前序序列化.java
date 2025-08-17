package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import io.github.dunwu.algorithm.tree.TreeUtils;
import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/verify-preorder-serialization-of-a-binary-tree/">331. 验证二叉树的前序序列化</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-15
 */
public class 验证二叉树的前序序列化 {

    public static void main(String[] args) {
        Assertions.assertEquals(22,
            new Solution().sumRootToLeaf(TreeUtils.buildTree(1, 0, 1, 0, 1, 0, 1)));
        Assertions.assertEquals(0,
            new Solution().sumRootToLeaf(TreeUtils.buildTree(0)));
    }

    static class Solution {

        int sum = 0;
        LinkedList<Integer> paths = new LinkedList<>();

        public boolean isValidSerialization(String preorder) {

        }

        public void traverse(TreeNode root) {
            if (root == null) { return; }

            paths.addLast(root.val);
            if (root.left == null && root.right == null) {
                int num = 0;
                for (Integer value : paths) {
                    num = num * 2 + value;
                }
                sum += num;
            } else {
                traverse(root.left);
                traverse(root.right);
            }
            paths.removeLast();
        }

    }

}
