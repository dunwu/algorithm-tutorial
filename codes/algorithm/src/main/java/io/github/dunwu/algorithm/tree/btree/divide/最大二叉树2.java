package io.github.dunwu.algorithm.tree.btree.divide;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/maximum-binary-tree-ii/">998. 最大二叉树 II</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-18
 */
public class 最大二叉树2 {

    public static void main(String[] args) {
        TreeNode input = TreeNode.buildTree(4, 1, 3, null, null, 2);
        TreeNode output = insertIntoMaxTree(input, 5);
        List<Integer> result1 = TreeNode.toValueList(output);
        Assertions.assertArrayEquals(new Integer[] { 5, 4, null, 1, 3, null, null, 2 }, result1.toArray());

        TreeNode input2 = TreeNode.buildTree(5, 2, 4, null, 1);
        TreeNode output2 = insertIntoMaxTree(input2, 3);
        List<Integer> result2 = TreeNode.toValueList(output2);
        Assertions.assertArrayEquals(new Integer[] { 5, 2, 4, null, 1, null, 3 }, result2.toArray());

        TreeNode input3 = TreeNode.buildTree(3, 2);
        TreeNode output3 = insertIntoMaxTree(input3, 1);
        List<Integer> result3 = TreeNode.toValueList(output3);
        Assertions.assertArrayEquals(new Integer[] { 3, 2, null, null, 1 }, result3.toArray());
    }

    public static TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val < val) {
            // 如果 val 是整棵树最大的，那么原来的这棵树应该是 val 节点的左子树，
            // 因为 val 节点是接在原始数组 a 的最后一个元素
            TreeNode temp = root;
            root = new TreeNode(val);
            root.left = temp;
        } else {
            // 如果 val 不是最大的，那么就应该在右子树上，
            // 因为 val 节点是接在原始数组 a 的最后一个元素
            root.right = insertIntoMaxTree(root.right, val);
        }
        return root;
    }

}
