package io.github.dunwu.algorithm.tree.btree.traverse;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/sum-root-to-leaf-numbers/">求根节点到叶节点数字之和</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-15
 */
public class 求根节点到叶节点数字之和 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(25, s.sumNumbers(TreeNode.buildTree(1, 2, 3)));
        Assertions.assertEquals(1026, s.sumNumbers(TreeNode.buildTree(4, 9, 0, 5, 1)));
    }

    static class Solution {

        int res = 0;
        LinkedList<Integer> paths = null;

        public int sumNumbers(TreeNode root) {
            res = 0;
            paths = new LinkedList<>();
            traverse(root);
            return res;
        }

        public void traverse(TreeNode root) {
            // 【校验】
            if (root == null) { return; }

            // 选择
            paths.addLast(root.val);
            if (root.left == null && root.right == null) {
                int num = 0;
                for (Integer path : paths) {
                    num = num * 10 + path;
                }
                res += num;
            }

            // 【前序】
            traverse(root.left);
            // 【中序】
            traverse(root.right);
            // 【后序】

            // 取消选择
            paths.removeLast();
        }

    }

}
