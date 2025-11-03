package io.github.dunwu.algorithm.tree.bstree;

import cn.hutool.json.JSONUtil;
import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
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

        public List<TreeNode> generateTrees(int n) {
            if (n == 0) return new LinkedList<>();
            return recursion(1, n);
        }

        public List<TreeNode> recursion(int begin, int end) {

            List<TreeNode> res = new LinkedList<>();
            if (begin > end) {
                res.add(null);
                return res;
            }

            for (int i = begin; i <= end; i++) {
                List<TreeNode> leftTrees = recursion(begin, i - 1);
                List<TreeNode> rightTrees = recursion(i + 1, end);
                for (TreeNode left : leftTrees) {
                    for (TreeNode right : rightTrees) {
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
