package io.github.dunwu.algorithm.tree.bstree;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/unique-binary-search-trees-ii/">95. 不同的二叉搜索树 II</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-10-22
 */
public class 不同的二叉搜索树2 {

    public static void main(String[] args) {

        Solution s = new Solution();

        List<TreeNode> output1 = s.generateTrees(3);
        LinkedList<List<Integer>> expectList1 = new LinkedList<>();
        expectList1.add(new LinkedList<>(Arrays.asList(1, null, 2, null, 3)));
        expectList1.add(new LinkedList<>(Arrays.asList(1, null, 3, 2)));
        expectList1.add(new LinkedList<>(Arrays.asList(2, 1, 3)));
        expectList1.add(new LinkedList<>(Arrays.asList(3, 1, null, null, 2)));
        expectList1.add(new LinkedList<>(Arrays.asList(3, 2, null, 1)));
        Assertions.assertEquals(expectList1.size(), output1.size());
        output1.forEach(tree -> {
            List<Integer> expect = expectList1.poll();
            Assertions.assertArrayEquals(expect.toArray(), TreeNode.toValueList(tree).toArray());
        });

        List<TreeNode> output2 = s.generateTrees(1);
        LinkedList<List<Integer>> expectList2 = new LinkedList<>();
        expectList2.add(new LinkedList<>(Collections.singletonList(1)));
        Assertions.assertEquals(expectList2.size(), output2.size());
        output2.forEach(tree -> {
            List<Integer> expect = expectList2.poll();
            Assertions.assertArrayEquals(expect.toArray(), TreeNode.toValueList(tree).toArray());
        });
    }

    static class Solution {

        // 主函数
        public List<TreeNode> generateTrees(int n) {
            if (n == 0) return new LinkedList<>();
            // 构造闭区间 [1, n] 组成的 BST
            return build(1, n);
        }

        // 构造闭区间 [low, high] 组成的 BST
        List<TreeNode> build(int low, int high) {
            List<TreeNode> res = new LinkedList<>();
            // base case
            if (low > high) {
                res.add(null);
                return res;
            }

            // 1、穷举 root 节点的所有可能。
            for (int i = low; i <= high; i++) {
                // 2、递归构造出左右子树的所有合法 BST。
                List<TreeNode> leftTree = build(low, i - 1);
                List<TreeNode> rightTree = build(i + 1, high);
                // 3、给 root 节点穷举所有左右子树的组合。
                for (TreeNode left : leftTree) {
                    for (TreeNode right : rightTree) {
                        // i 作为根节点 root 的值
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        res.add(root);
                    }
                }
            }
            return res;
        }

    }

}
