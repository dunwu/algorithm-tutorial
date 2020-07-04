package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeUtils;
import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <code>二叉树的最小深度</code> 算法实现
 *
 * <pre>
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 * </pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/minimum-depth-of-binary-tree">二叉树的最小深度</a>
 */
public class 二叉树的最小深度 {

    public static void main(String[] args) {
        TreeNode tree = TreeUtils.buildTree(3, 9, 20, null, null, 15, 7);
        System.out.println("result = " + minDepthInDFS(tree));
        Assertions.assertEquals(2, minDepthInDFS(tree));
        Assertions.assertEquals(2, minDepthInBFS(tree));
    }

    // 基于 DFS 实现
    // 时间复杂度 O(N)
    public static int minDepthInDFS(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return 1 + minDepthInDFS(root.right);
        if (root.right == null) return 1 + minDepthInDFS(root.left);
        return 1 + Math.min(minDepthInDFS(root.left), minDepthInDFS(root.right));
    }

    // 基于 BFS 实现
    // 时间复杂度 O(N)
    public static int minDepthInBFS(TreeNode root) {
        if (root == null) return 0;
        int level = 0;
        int min = -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    if (min == -1) {
                        min = level;
                    } else {
                        min = Math.min(min, level);
                    }
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        return min;
    }

}
