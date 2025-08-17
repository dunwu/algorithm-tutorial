package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import io.github.dunwu.algorithm.tree.TreeUtils;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/sum-root-to-leaf-numbers/">求根节点到叶节点数字之和</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-15
 */
public class 二叉树的右视图 {

    public static void main(String[] args) {
        Assertions.assertArrayEquals(new Integer[] { 1, 3, 4 },
            new Solution().rightSideView(TreeUtils.buildTree(1, 2, 3, null, 5, null, 4)).toArray(new Integer[0]));

        Assertions.assertArrayEquals(new Integer[] { 1, 3, 4, 5 },
            new Solution().rightSideView(TreeUtils.buildTree(1, 2, 3, 4, null, null, null, 5)).toArray(new Integer[0]));
    }

    static class Solution {

        public List<Integer> rightSideView(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }

            List<Integer> res = new LinkedList<>();
            LinkedList<TreeNode> q = new LinkedList<>();
            q.offer(root);

            while (!q.isEmpty()) {
                int size = q.size();
                TreeNode node = null;
                for (int i = 0; i < size; i++) {
                    node = q.poll();
                    if (node.left != null) {
                        q.offer(node.left);
                    }
                    if (node.right != null) {
                        q.offer(node.right);
                    }
                }
                if (node != null) {
                    res.add(node.val);
                }
            }

            return res;
        }

    }

}
