package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeUtils;
import org.junit.jupiter.api.Assertions;

import java.util.*;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @see <a href="https://leetcode-cn.com/problems/binary-tree-level-order-traversal/">二叉树的层次遍历</a>
 * @since 2020-06-18
 */
public class 二叉树的层次遍历 {

    public static void main(String[] args) {
        TreeNode tree = TreeUtils.asTree(3, 9, 20, null, null, 15, 7);
        List<List<Integer>> resultList = levelOrder(tree);
        List<List<Integer>> expectList = new LinkedList<>();
        expectList.add(Arrays.asList(3));
        expectList.add(Arrays.asList(9, 20));
        expectList.add(Arrays.asList(15, 7));
        Assertions.assertArrayEquals(expectList.toArray(), resultList.toArray());
    }

    /**
     * 基于 BFS 实现二叉树层次遍历。关键在于使用一个队列存储
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                list.add(node.val);
            }
            result.add(list);
        }

        return result;
    }

}
