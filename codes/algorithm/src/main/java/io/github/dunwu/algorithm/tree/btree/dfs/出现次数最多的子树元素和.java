package io.github.dunwu.algorithm.tree.btree.dfs;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    }

    static class Solution {

        private HashMap<Integer, Integer> map = new HashMap<>();

        public int[] findFrequentTreeSum(TreeNode root) {

            sum(root);

            int max = Integer.MIN_VALUE;
            for (int cnt : map.values()) {
                max = Math.max(max, cnt);
            }

            List<Integer> list = new ArrayList<>();
            for (Integer key : map.keySet()) {
                if (map.get(key) == max) {
                    list.add(key);
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
            int leftSum = sum(root.left);
            int rightSum = sum(root.right);
            int sum = leftSum + rightSum + root.val;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            return sum;
        }

    }

}
