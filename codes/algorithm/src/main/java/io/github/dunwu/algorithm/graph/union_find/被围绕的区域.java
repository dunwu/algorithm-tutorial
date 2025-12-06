package io.github.dunwu.algorithm.graph.union_find;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/surrounded-regions/">130. 被围绕的区域</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-03
 */
public class 被围绕的区域 {

    public static void main(String[] args) {
        Solution s = new Solution();

        char[][] input = new char[][] {
            { 'X', 'X', 'X', 'X' },
            { 'X', 'O', 'O', 'X' },
            { 'X', 'X', 'O', 'X' },
            { 'X', 'O', 'X', 'X' }
        };
        char[][] expect = new char[][] {
            { 'X', 'X', 'X', 'X' },
            { 'X', 'X', 'X', 'X' },
            { 'X', 'X', 'X', 'X' },
            { 'X', 'O', 'X', 'X' }
        };
        s.solve(input);
        Assertions.assertArrayEquals(expect, input);
    }

    static class Solution {

        private int m;
        private int n;

        public void solve(char[][] board) {
            if (board == null || board.length == 0 || board[0].length == 0) { return; }

            m = board.length;
            n = board[0].length;

            int dummy = m * n;
            UF uf = new UF(m * n + 1);

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // 遇到 O 进行并查集合并操作
                    if (board[i][j] == 'O') {
                        if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                            // 边界上的 O,把它和 dummy 合并成一个连通区域.
                            uf.union(node(i, j), dummy);
                        } else {
                            // 和上下左右合并成一个连通区域
                            if (i > 0 && board[i - 1][j] == 'O') {
                                uf.union(node(i, j), node(i - 1, j));
                            }
                            if (i < m - 1 && board[i + 1][j] == 'O') {
                                uf.union(node(i, j), node(i + 1, j));
                            }
                            if (j > 0 && board[i][j - 1] == 'O') {
                                uf.union(node(i, j), node(i, j - 1));
                            }
                            if (j < n - 1 && board[i][j + 1] == 'O') {
                                uf.union(node(i, j), node(i, j + 1));
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (uf.connected(node(i, j), dummy)) {
                        // 和 dummy 在一个连通区域的，那么就是 O
                        board[i][j] = 'O';
                    } else {
                        board[i][j] = 'X';
                    }
                }
            }
        }

        int node(int i, int j) {
            return i * n + j;
        }

        static class UF {

            // 连通分量个数
            private int count;
            // 存储每个节点的父节点
            private int[] parent;

            public UF(int n) {
                this.count = n;
                parent = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }

            public void union(int p, int q) {
                int rootP = find(p);
                int rootQ = find(q);

                if (rootP == rootQ) { return; }

                parent[rootQ] = rootP;
                count--;
            }

            public boolean connected(int p, int q) {
                int rootP = find(p);
                int rootQ = find(q);
                return rootP == rootQ;
            }

            public int find(int x) {
                if (parent[x] != x) {
                    parent[x] = find(parent[x]);
                }
                return parent[x];
            }

            public int count() {
                return count;
            }

        }

    }

}
