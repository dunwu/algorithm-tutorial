package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @see <a href="https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/">124. 二叉树中的最大路径和</a>
 * @since 2020-07-06
 */
public class 二叉树中的最大路径和 {

    public static void main(String[] args) {
        二叉树中的最大路径和 demo = new 二叉树中的最大路径和();
        TreeNode tree = TreeNode.buildTree(1, 2, 3);
        Assertions.assertEquals(6, demo.maxPathSum(tree));
        TreeNode tree2 = TreeNode.buildTree(-10, 9, 20, null, null, 15, 7);
        Assertions.assertEquals(42, demo.maxPathSum(tree2));
        TreeNode tree3 = TreeNode.buildTree(2, -1);
        Assertions.assertEquals(2, demo.maxPathSum(tree3));
        TreeNode tree4 = TreeNode.buildTree(-2, -1);
        Assertions.assertEquals(-1, demo.maxPathSum(tree4));
    }

    int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxGain(root);
        return maxSum;
    }

    public int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int left = Math.max(maxGain(node.left), 0);
        int right = Math.max(maxGain(node.right), 0);

        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int current = node.val + left + right;

        // 更新答案
        maxSum = Math.max(maxSum, current);

        // 返回节点的最大贡献值
        return node.val + Math.max(left, right);
    }

}
