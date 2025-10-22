package io.github.dunwu.algorithm.tree.btree.bfs;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/">二叉树的层次遍历 II</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-18
 */
public class 二叉树的层次遍历2 {

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = TreeNode.buildTree(3, 9, 20, null, null, 15, 7);
        List<List<Integer>> expectList = new LinkedList<>();
        expectList.add(Arrays.asList(15, 7));
        expectList.add(Arrays.asList(9, 20));
        expectList.add(Arrays.asList(3));
        Assertions.assertArrayEquals(expectList.toArray(), s.levelOrderBottom(root).toArray());

        Solution s2 = new Solution();
        TreeNode root2 = TreeNode.buildTree(1);
        List<List<Integer>> expectList2 = new LinkedList<>();
        expectList2.add(Arrays.asList(1));
        Assertions.assertArrayEquals(expectList2.toArray(), s2.levelOrderBottom(root2).toArray());

        Solution s3 = new Solution();
        TreeNode root3 = TreeNode.buildTree();
        Assertions.assertArrayEquals(new LinkedList<>().toArray(), s3.levelOrderBottom(root3).toArray());
    }

    static class Solution {

        public List<List<Integer>> levelOrderBottom(TreeNode root) {

            if (root == null) {
                return new ArrayList();
            }

            LinkedList<TreeNode> queue = new LinkedList<>();
            List<List<Integer>> result = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> currentLevel = new LinkedList<>();
                result.add(currentLevel);
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    currentLevel.add(node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            Collections.reverse(result);
            return result;
        }

    }

}
