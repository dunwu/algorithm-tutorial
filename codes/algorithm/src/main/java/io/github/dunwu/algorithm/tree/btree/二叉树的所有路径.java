package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import io.github.dunwu.algorithm.tree.TreeUtils;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <code>二叉树的所有路径</code> 算法实现
 *
 * <pre>
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * </pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/binary-tree-paths/">二叉树的所有路径</a>
 */
public class 二叉树的所有路径 {

    public static void main(String[] args) {
        TreeNode tree = TreeUtils.asTree(1, 2, 3, 5);
        System.out.println("result = " + binaryTreePaths(tree));
        Assertions.assertArrayEquals(Arrays.asList("1->2->5", "1->3").toArray(),
            binaryTreePaths(tree).toArray(new String[0]));
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new LinkedList<>();
        recordPath(root, "", paths);
        return paths;
    }

    private static void recordPath(TreeNode node, String path, List<String> paths) {
        if (node == null) return;
        path += node.val;
        if (node.left == null && node.right == null) {
            paths.add(path);
        } else {
            path += "->";
            recordPath(node.left, path, paths);
            recordPath(node.right, path, paths);
        }
    }

}
