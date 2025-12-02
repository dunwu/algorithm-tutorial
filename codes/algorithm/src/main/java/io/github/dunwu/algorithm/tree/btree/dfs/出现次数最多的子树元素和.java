package io.github.dunwu.algorithm.tree.btree.dfs;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/most-frequent-subtree-sum/">508. 出现次数最多的子树元素和</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-07-06
 */
public class 出现次数最多的子树元素和 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertArrayEquals(new int[] { 2, -3, 4 }, s.findFrequentTreeSum(TreeNode.buildTree(5, 2, -3)));
        Assertions.assertArrayEquals(new int[] { 2 }, s.findFrequentTreeSum(TreeNode.buildTree(5, 2, -5)));
    }

    static class Solution {

        private Map<Integer, Integer> map;

        public int[] findFrequentTreeSum(TreeNode root) {
            map = new HashMap<>();
            sum(root);

            int max = Integer.MIN_VALUE;
            List<Integer> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                Integer k = entry.getKey();
                Integer v = entry.getValue();
                if (v > max) {
                    max = v;
                    list.clear();
                    list.add(k);
                } else if (v == max) {
                    list.add(k);
                }
            }

            int[] res = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }
            return res;
        }

        public int sum(TreeNode root) {
            if (root == null) { return 0; }
            int left = sum(root.left);
            int right = sum(root.right);
            int sum = left + right + root.val;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            return sum;
        }

    }

}
