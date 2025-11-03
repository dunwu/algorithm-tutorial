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

        LinkedList<TreeNode>[] memo = null;

        public List<TreeNode> allPossibleFBT(int n) {

            if (memo == null) {
                memo = new LinkedList[n + 1];
            }

            LinkedList<TreeNode> res = new LinkedList<>();
            // 根据真二叉树定义，节点数必为奇数
            if (n % 2 == 0) {
                return res;
            }
            if (memo[n] != null) {
                return memo[n];
            }
            if (n == 1) {
                res.add(new TreeNode(0));
                memo[n] = res;
                return res;
            }

            for (int leftNum = 1; leftNum < n; leftNum += 2) {
                int rightNum = n - leftNum - 1;
                List<TreeNode> leftSubTree = allPossibleFBT(leftNum);
                List<TreeNode> rightSubTree = allPossibleFBT(rightNum);
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
