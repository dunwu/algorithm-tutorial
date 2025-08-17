package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import io.github.dunwu.algorithm.tree.TreeUtils;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/smallest-string-starting-from-leaf/">988. 从叶结点开始的最小字符串</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-15
 */
public class 从叶结点开始的最小字符串 {

    public static void main(String[] args) {
        Assertions.assertEquals("dba",
            new Solution().smallestFromLeaf(TreeUtils.buildTree(0, 1, 2, 3, 4, 3, 4)));
        Assertions.assertEquals("adz",
            new Solution().smallestFromLeaf(TreeUtils.buildTree(25, 1, 3, 1, 3, 0, 2)));
        Assertions.assertEquals("abc",
            new Solution().smallestFromLeaf(TreeUtils.buildTree(2, 2, 1, null, 1, 0, null, 0)));
    }

    static class Solution {

        String max = null;
        LinkedList<Character> paths = new LinkedList<>();

        public String smallestFromLeaf(TreeNode root) {
            traverse(root);
            return max;
        }

        public void traverse(TreeNode root) {
            if (root == null) { return; }

            char c = (char) (root.val + 'a');
            paths.addLast(c);
            if (root.left == null && root.right == null) {
                StringBuilder sb = new StringBuilder();
                for (int i = paths.size() - 1; i >= 0; i--) {
                    sb.append(paths.get(i));
                }
                if (max == null) {
                    max = sb.toString();
                } else {
                    if (max.compareTo(sb.toString()) > 0) {
                        max = sb.toString();
                    }
                }
            } else {
                traverse(root.left);
                traverse(root.right);
            }
            paths.removeLast();
        }

    }

}
