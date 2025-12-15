package io.github.dunwu.algorithm.dfs;

import io.github.dunwu.algorithm.util.ArrayUtil;
import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/beautiful-arrangement/">526. 优美的排列</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-12-12
 */
public class 格雷编码 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertArrayEquals(new int[] { 0, 1 }, ArrayUtil.toIntArray(s.grayCode(1)));
        Assertions.assertArrayEquals(new int[] { 0, 1, 3, 2 }, ArrayUtil.toIntArray(s.grayCode(2)));
    }

    static class Solution {

        private boolean[] visited;
        private LinkedList<Integer> path;
        private LinkedList<Integer> res;

        public List<Integer> grayCode(int n) {
            visited = new boolean[n];
            path = new LinkedList<>();
            res = null;
            dfs(n, 0);
            return res;
        }

        public void dfs(int n, int root) {
            if (res != null) return;
            if (path.size() == (1 << n)) {
                res = new LinkedList<>(path);
                return;
            }
            if (visited[root]) return;

            visited[root] = true;
            path.addLast(root);

            for (int i = 0; i < n; i++) {
                int next = flipBit(root, i);
                dfs(n, next);
            }

            path.removeLast();
            visited[root] = false;
        }

        // 把第 i 位取反（0 变 1，1 变 0）
        int flipBit(int x, int i) {
            return x ^ (1 << i);
        }

    }

}
