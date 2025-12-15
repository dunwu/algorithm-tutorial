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
        int[][] direct = new int[][] { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };

        public void solve(char[][] board) {

            if (board == null || board.length == 0) return;
            m = board.length;
            n = board[0].length;

            // 给 dummy 留一个额外位置
            UF uf = new UF(m * n + 1);
            int dummy = m * n;

            // 将首列和末列的 O 与 dummy 连通
            for (int i = 0; i < m; i++) {
                if (board[i][0] == 'O') { uf.union(index(i, 0), dummy); }
                if (board[i][n - 1] == 'O') { uf.union(index(i, n - 1), dummy); }
            }

            // 将首行和末行的 O 与 dummy 连通
            for (int j = 0; j < n; j++) {
                if (board[0][j] == 'O') { uf.union(index(0, j), dummy); }
                if (board[m - 1][j] == 'O') { uf.union(index(m - 1, j), dummy); }
            }

            // 方向数组 d 是上下左右搜索的常用手法
            for (int i = 1; i < m - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    if (board[i][j] == 'O') {
                        // 将此 O 与上下左右的 O 连通
                        for (int[] d : direct) {
                            int x = i + d[0], y = j + d[1];
                            if (board[x][y] == 'O') {
                                uf.union(index(x, y), index(i, j));
                            }
                        }
                    }
                }
            }

            // 所有不和 dummy 连通的 O，都要被替换
            for (int i = 1; i < m - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    int index = index(i, j);
                    if (!uf.connected(index, dummy)) {
                        board[i][j] = 'X';
                    }
                }
            }
        }

        public int index(int row, int col) {
            return row * n + col;
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
