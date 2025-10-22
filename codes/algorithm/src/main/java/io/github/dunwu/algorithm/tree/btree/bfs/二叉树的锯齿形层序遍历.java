package io.github.dunwu.algorithm.tree.btree.bfs;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/">103. 二叉树的锯齿形层序遍历</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-10-21
 */
public class 二叉树的锯齿形层序遍历 {

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = TreeNode.buildTree(3, 9, 20, null, null, 15, 7);
        List<List<Integer>> expectList = new LinkedList<>();
        expectList.add(Arrays.asList(3));
        expectList.add(Arrays.asList(20, 9));
        expectList.add(Arrays.asList(15, 7));
        Assertions.assertArrayEquals(expectList.toArray(), s.zigzagLevelOrder(root).toArray());

        TreeNode root2 = TreeNode.buildTree(1, 2, 3, 4, null, null, 5);
        List<List<Integer>> expectList2 = new LinkedList<>();
        expectList2.add(Arrays.asList(1));
        expectList2.add(Arrays.asList(3, 2));
        expectList2.add(Arrays.asList(4, 5));
        Assertions.assertArrayEquals(expectList2.toArray(), s.zigzagLevelOrder(root2).toArray());
    }

    static class Solution {

        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new LinkedList<>();
            if (root == null) return result;

            boolean reverse = false;
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.addLast(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                LinkedList<Integer> layer = new LinkedList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.removeFirst();
                    if (reverse) {
                        layer.addFirst(node.val);
                    } else {
                        layer.addLast(node.val);
                    }
                    if (node.left != null) queue.addLast(node.left);
                    if (node.right != null) queue.addLast(node.right);
                }
                reverse = !reverse;
                result.add(layer);
            }
            return result;
        }

    }

}
