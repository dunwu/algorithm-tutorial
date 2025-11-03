package io.github.dunwu.algorithm.tree.btree.traverse;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/smallest-string-starting-from-leaf/">988. 从叶结点开始的最小字符串</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-15
 */
public class 从叶结点开始的最小字符串 {

    public static void main(String[] args) {

        Solution s = new Solution();
        Assertions.assertEquals("dba",
            s.smallestFromLeaf(TreeNode.buildTree(0, 1, 2, 3, 4, 3, 4)));
        Assertions.assertEquals("adz",
            s.smallestFromLeaf(TreeNode.buildTree(25, 1, 3, 1, 3, 0, 2)));
        Assertions.assertEquals("abc",
            s.smallestFromLeaf(TreeNode.buildTree(2, 2, 1, null, 1, 0, null, 0)));
    }

    static class Solution {

        String res = null;
        LinkedList<Integer> nodes = null;

        public String smallestFromLeaf(TreeNode root) {
            res = null;
            nodes = new LinkedList<>();
            traverse(root);
            return res;
        }

        public void traverse(TreeNode root) {
            // 校验
            if (root == null) { return; }

            // 选择
            nodes.addLast(root.val);
            if (root.left == null && root.right == null) {
                String str = toString(nodes);
                // System.out.printf("\tstr: %s\n", str);
                if (res == null || str.compareTo(res) < 0) {
                    res = str;
                }
            }

            traverse(root.left);
            traverse(root.right);

            // 取消选择
            nodes.removeLast();
        }

        public String toString(LinkedList<Integer> nodes) {
            StringBuilder sb = new StringBuilder();
            for (int node : nodes) {
                char c = (char) (node + 'a');
                sb.insert(0, c);
            }
            return sb.toString();
        }

    }

}
