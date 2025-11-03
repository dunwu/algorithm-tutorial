package io.github.dunwu.algorithm.tree.btree.traverse;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/sum-of-root-to-leaf-binary-numbers/">1022. 从根到叶的二进制数之和</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-15
 */
public class 从根到叶的二进制数之和 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(22, s.sumRootToLeaf(TreeNode.buildTree(1, 0, 1, 0, 1, 0, 1)));
        Assertions.assertEquals(0, s.sumRootToLeaf(TreeNode.buildTree(0)));
    }

    static class Solution {

        int sum = 0;
        LinkedList<Integer> nodes;

        public int sumRootToLeaf(TreeNode root) {
            sum = 0;
            nodes = new LinkedList<>();
            traverse(root);
            return sum;
        }

        public void traverse(TreeNode node) {
            // 校验
            if (node == null) return;

            // 选择
            nodes.addLast(node.val);
            if (node.left == null && node.right == null) {
                Integer num = toNum(nodes);
                System.out.printf("\tnum: %d\n", num);
                sum += num;
            }

            traverse(node.left);
            traverse(node.right);

            // 取消选择
            nodes.removeLast();
        }

        Integer toNum(LinkedList<Integer> nodes) {
            int num = 0;
            for (int node : nodes) {
                num = num * 2 + node;
            }
            return num;
        }

    }

}
