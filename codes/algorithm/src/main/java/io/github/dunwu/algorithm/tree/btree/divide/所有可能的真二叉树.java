package io.github.dunwu.algorithm.tree.btree.divide;

import io.github.dunwu.algorithm.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/all-possible-full-binary-trees/">894. 所有可能的真二叉树</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-10-21
 */
public class 所有可能的真二叉树 {

    public static void main(String[] args) {
        Solution s = new Solution();
        List<TreeNode> trees = s.allPossibleFBT(7);
        trees.forEach(tree -> {
            System.out.println(TreeNode.serialize(tree));
        });
    }

    static class Solution {

        List<TreeNode>[] memo;

        public List<TreeNode> allPossibleFBT(int n) {
            if (n % 2 == 0) {
                return new LinkedList<>();
            }
            memo = new LinkedList[n + 1];
            return build(n);
        }

        public List<TreeNode> build(int n) {
            List<TreeNode> res = new LinkedList<>();
            if (n == 1) {
                res.add(new TreeNode(0));
                return res;
            }
            if (memo[n] != null) {
                return memo[n];
            }
            for (int i = 1; i < n; i += 2) {
                int j = n - i - 1;

                List<TreeNode> leftSubTree = build(i);
                List<TreeNode> rightSubTree = build(j);
                for (TreeNode left : leftSubTree) {
                    for (TreeNode right : rightSubTree) {
                        TreeNode node = new TreeNode(0);
                        node.left = left;
                        node.right = right;
                        res.add(node);
                    }
                }
            }
            memo[n] = res;
            return res;
        }

    }

}
