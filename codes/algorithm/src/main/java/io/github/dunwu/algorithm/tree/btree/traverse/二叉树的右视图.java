package io.github.dunwu.algorithm.tree.btree.traverse;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

import java.util.LinkedHashMap;
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

        Solution s = new Solution();
        Assertions.assertArrayEquals(new Integer[] { 1, 3, 4 },
            s.rightSideView(TreeNode.buildTree(1, 2, 3, null, 5, null, 4)).toArray());
        Assertions.assertArrayEquals(new Integer[] { 1, 3, 4, 5 },
            s.rightSideView(TreeNode.buildTree(1, 2, 3, 4, null, null, null, 5)).toArray());
        Assertions.assertArrayEquals(new Integer[] { 1, 3 },
            s.rightSideView(TreeNode.buildTree(1, null, 3)).toArray());
        Assertions.assertArrayEquals(new Integer[] {},
            s.rightSideView(TreeNode.buildTree()).toArray());

        Solution2 s2 = new Solution2();
        Assertions.assertArrayEquals(new Integer[] { 1, 3, 4 },
            s2.rightSideView(TreeNode.buildTree(1, 2, 3, null, 5, null, 4)).toArray());
        Assertions.assertArrayEquals(new Integer[] { 1, 3, 4, 5 },
            s2.rightSideView(TreeNode.buildTree(1, 2, 3, 4, null, null, null, 5)).toArray());
        Assertions.assertArrayEquals(new Integer[] { 1, 3 },
            s2.rightSideView(TreeNode.buildTree(1, null, 3)).toArray());
        Assertions.assertArrayEquals(new Integer[] {},
            s2.rightSideView(TreeNode.buildTree()).toArray());

    }

    // 【层序遍历】思路
    static class Solution {

        LinkedList<Integer> res = null;

        public List<Integer> rightSideView(TreeNode root) {
            if (root == null) { return new LinkedList<>(); }

            res = new LinkedList<>();
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int size = queue.size();
                // 每层将最后一个元素加入结果集
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node.left != null) { queue.offer(node.left); }
                    if (node.right != null) { queue.offer(node.right); }
                    if (i == size - 1) {
                        res.add(node.val);
                    }
                }
            }
            return res;
        }

    }

    // 【遍历递归】思路
    static class Solution2 {

        int depth = 0;
        LinkedHashMap<Integer, Integer> map = null;

        public List<Integer> rightSideView(TreeNode root) {
            map = new LinkedHashMap<>();
            traverse(root);
            return new LinkedList<>(map.values());
        }

        public void traverse(TreeNode root) {
            if (root == null) { return; }
            depth++;
            if (!map.containsKey(depth)) {
                map.put(depth, root.val);
            }
            traverse(root.right);
            traverse(root.left);
            depth--;
        }

    }

}
