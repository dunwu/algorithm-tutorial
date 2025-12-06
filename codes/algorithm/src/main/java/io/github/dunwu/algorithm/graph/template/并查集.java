package io.github.dunwu.algorithm.graph.template;

/**
 * 并查集
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-12-03
 */
public class 并查集 {

    static class UF {

        // 连通分量个数
        private int count;
        // 存储每个节点的父节点
        private int[] parent;

        // n 为图中节点的个数
        public UF(int n) {
            this.count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        // 将节点 p 和节点 q 连通
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);

            if (rootP == rootQ) { return; }

            parent[rootQ] = rootP;
            // 两个连通分量合并成一个连通分量
            count--;
        }

        // 判断节点 p 和节点 q 是否连通
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

        // 返回图中的连通分量个数
        public int count() {
            return count;
        }

    }

}
