package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import io.github.dunwu.algorithm.tree.TreeUtils;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode-cn.com/problems/binary-tree-level-order-traversal/">二叉树的层次遍历</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-18
 */
public class 二叉树的层次遍历 {

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = TreeUtils.buildTree(3, 9, 20, null, null, 15, 7);
        List<List<Integer>> expectList = new LinkedList<>();
        expectList.add(Arrays.asList(3));
        expectList.add(Arrays.asList(9, 20));
        expectList.add(Arrays.asList(15, 7));
        Assertions.assertArrayEquals(expectList.toArray(), s.levelOrder(root).toArray());

        Solution s2 = new Solution();
        TreeNode root2 = TreeUtils.buildTree(1);
        List<List<Integer>> expectList2 = new LinkedList<>();
        expectList2.add(Arrays.asList(1));
        Assertions.assertArrayEquals(expectList2.toArray(), s2.levelOrder(root2).toArray());

        Solution s3 = new Solution();
        TreeNode root3 = TreeUtils.buildTree();
        Assertions.assertArrayEquals(new LinkedList<>().toArray(), s3.levelOrder(root3).toArray());
    }

    static class Solution {

        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList();
            }
            List<List<Integer>> result = new LinkedList<>();
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int level = 1;
            while (!queue.isEmpty()) {
                int n = queue.size();
                System.out.printf("\nLevel[%s]: ", level);
                List<Integer> curLevelNodes = new LinkedList<>();
                for (int i = 0; i < n; i++) {
                    TreeNode node = queue.poll();
                    System.out.printf("%s, ", node);
                    curLevelNodes.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                level++;
                result.add(curLevelNodes);
            }
            System.out.println();
            return result;
        }

    }

}
