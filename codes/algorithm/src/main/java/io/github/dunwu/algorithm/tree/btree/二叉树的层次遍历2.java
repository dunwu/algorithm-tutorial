package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeUtils;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * <code>二叉树的层次遍历 II</code> 算法实现
 *
 * <pre>
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 * </pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/">二叉树的层次遍历 II</a>
 */
public class 二叉树的层次遍历2 {

    public static void main(String[] args) {
        TreeNode tree = TreeUtils.buildTree(3, 9, 20, null, null, 15, 7);
        List<List<Integer>> resultList = levelOrderBottom(tree);
        List<List<Integer>> expectList = new LinkedList<>();
        expectList.add(Arrays.asList(15, 7));
        expectList.add(Arrays.asList(9, 20));
        expectList.add(Arrays.asList(3));
        Assertions.assertArrayEquals(expectList.toArray(), resultList.toArray());
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root == null) return result;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    list.add(node.val);
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
            }
            result.add(list);
        }
        Collections.reverse(result);
        return result;
    }

}
