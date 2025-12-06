package io.github.dunwu.algorithm.graph.union_find;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/redundant-connection/">684. 冗余连接</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-03
 */
public class 冗余连接 {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] input = new int[][] { { 1, 2 }, { 1, 3 }, { 2, 3 } };
        int[][] input2 = new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 4 }, { 1, 5 } };
        Assertions.assertArrayEquals(new int[] { 2, 3 }, s.findRedundantConnection(input));
        Assertions.assertArrayEquals(new int[] { 1, 4 }, s.findRedundantConnection(input2));
    }

    static class Solution {

        public int[] findRedundantConnection(int[][] edges) {
            int n = edges.length;
            UF uf = new UF(n + 1);
            for (int i = 0; i < n; i++) {
                int u = edges[i][0];
                int v = edges[i][1];
                if (uf.find(u) == uf.find(v)) {
                    return new int[] { u, v };
                } else {
                    uf.union(u, v);
                }
            }
            return new int[0];
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
