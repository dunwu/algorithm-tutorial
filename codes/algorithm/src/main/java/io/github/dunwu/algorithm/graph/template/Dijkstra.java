package io.github.dunwu.algorithm.graph.template;

import io.github.dunwu.algorithm.graph.Edge;
import io.github.dunwu.algorithm.graph.Graph;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Dijkstra 算法模板
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-12-03
 */
public class Dijkstra {

    // 输入不包含负权重边的加权图 graph 和起点 src
    // 返回从起点 src 到其他节点的最小路径权重和
    public int[] dijkstra(Graph graph, int src) {
        // 记录从起点 src 到其他节点的最小路径权重和
        // distTo[i] 表示从起点 src 到节点 i 的最小路径权重和
        int[] distTo = new int[graph.size()];
        // 都初始化为正无穷，表示未计算
        Arrays.fill(distTo, Integer.MAX_VALUE);

        // 优先级队列，distFromStart 较小的节点排在前面
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> {
            return a.distFromStart - b.distFromStart;
        });

        // 从起点 src 开始进行 BFS
        pq.offer(new State(src, 0));
        distTo[src] = 0;

        while (!pq.isEmpty()) {
            State state = pq.poll();
            int curNode = state.node;
            int curDistFromStart = state.distFromStart;

            if (distTo[curNode] < curDistFromStart) {
                // 在 Dijkstra 算法中，队列中可能存在重复的节点 state
                // 所以要在元素出队时进行判断，去除较差的重复节点
                continue;
            }

            for (Edge e : graph.neighbors(curNode)) {
                int nextNode = e.to;
                int nextDistFromStart = curDistFromStart + e.weight;

                if (distTo[nextNode] <= nextDistFromStart) {
                    continue;
                }

                // 将 nextNode 节点加入优先级队列
                pq.offer(new State(nextNode, nextDistFromStart));
                // 记录 nextNode 节点到起点的最小路径权重和
                distTo[nextNode] = nextDistFromStart;
            }
        }

        return distTo;
    }

    static class State {

        // 当前节点 ID
        int node;
        // 从起点 s 到当前 node 节点的最小路径权重和
        int distFromStart;

        public State(int node, int distFromStart) {
            this.node = node;
            this.distFromStart = distFromStart;
        }

    }

}
