package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeUtils;
import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <code>104. 二叉树的最大深度</code> 算法实现
 *
 * @see <a href="https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/">104. 二叉树的最大深度</a>
 */
public class 二叉树的最大深度 {

    public static void main(String[] args) {
        TreeNode tree = TreeUtils.buildTree(3, 9, 20, null, null, 15, 7);
        System.out.println("result = " + maxDepthInDFS(tree));
        Assertions.assertEquals(3, maxDepthInDFS(tree));
        Assertions.assertEquals(3, maxDepthInBFS(tree));
    }

    // 基于 DFS 实现
    // 时间复杂度 O(N)
    public static int maxDepthInDFS(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepthInDFS(root.left), maxDepthInDFS(root.right));
    }

    // 基于 BFS 实现
    // 逐层扫描，只要每层有节点，层级数+1
    // 时间复杂度 O(N)
    public static int maxDepthInBFS(TreeNode root) {

        if (root == null) return 0;

        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) continue;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }

        return level;
    }

}
