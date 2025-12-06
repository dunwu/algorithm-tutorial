package io.github.dunwu.algorithm.graph.union_find;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/satisfiability-of-equality-equations/">990. 等式方程的可满足性</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-03
 */
public class 等式方程的可满足性 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertFalse(s.equationsPossible(new String[] { "a==b", "b!=a" }));
        Assertions.assertTrue(s.equationsPossible(new String[] { "b==a", "a==b" }));
        Assertions.assertTrue(s.equationsPossible(new String[] { "a==b", "b==c", "a==c" }));
        Assertions.assertFalse(s.equationsPossible(new String[] { "a==b", "b!=c", "c==a" }));
        Assertions.assertTrue(s.equationsPossible(new String[] { "c==c", "b==d", "x!=z" }));
    }

    static class Solution {

        public boolean equationsPossible(String[] equations) {
            UF uf = new UF(26);
            for (String exp : equations) {
                if (exp.contains("==")) {
                    String[] vals = exp.split("==");
                    int a = vals[0].charAt(0) - 'a';
                    int b = vals[1].charAt(0) - 'a';
                    uf.union(a, b);
                }
            }

            for (String exp : equations) {
                if (exp.contains("!=")) {
                    String[] vals = exp.split("!=");
                    int a = vals[0].charAt(0) - 'a';
                    int b = vals[1].charAt(0) - 'a';
                    if (uf.connected(a, b)) {
                        return false;
                    }
                }
            }
            return true;
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
