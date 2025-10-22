package io.github.dunwu.algorithm.tree.btree.traverse;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/sum-root-to-leaf-numbers/">求根节点到叶节点数字之和</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-15
 */
public class 求根节点到叶节点数字之和 {

    public static void main(String[] args) {
        Assertions.assertEquals(25, new Solution().sumNumbers(TreeNode.buildTree(1, 2, 3)));
        Assertions.assertEquals(1026, new Solution().sumNumbers(TreeNode.buildTree(4, 9, 0, 5, 1)));
    }

    static class Solution {

        TreeNode root = null;
        List<Integer> nums = new LinkedList<>();
        LinkedList<TreeNode> paths = new LinkedList<>();

        public int sumNumbers(TreeNode root) {
            this.root = root;
            traverse(root);
            if (nums.size() == 0) { return 0; }
            return nums.stream().mapToInt(Integer::intValue).sum();
        }

        public void traverse(TreeNode node) {
            if (node == null) { return; }
            if (node.left == null && node.right == null) {
                paths.addLast(node);
                if (paths.getFirst() == this.root) {
                    int num = toNum(paths);
                    nums.add(num);
                }
                paths.removeLast();
                return;
            }

            paths.addLast(node);
            traverse(node.left);
            traverse(node.right);
            paths.removeLast();
        }

        public int toNum(List<TreeNode> paths) {
            if (paths.size() == 0) { return 0; }
            int num = 0;
            for (TreeNode node : paths) {
                num = num * 10 + node.val;
            }
            return num;
        }

    }

}
