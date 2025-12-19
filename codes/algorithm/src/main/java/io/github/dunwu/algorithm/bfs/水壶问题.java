package io.github.dunwu.algorithm.bfs;

import org.junit.jupiter.api.Assertions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/water-and-jug-problem/">365. 水壶问题</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-12-15
 */
public class 水壶问题 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertTrue(s.canMeasureWater(3, 5, 4));
        Assertions.assertFalse(s.canMeasureWater(2, 6, 5));
        Assertions.assertTrue(s.canMeasureWater(1, 2, 3));
    }

    static class Solution {

        public boolean canMeasureWater(int x, int y, int t) {
            // BFS 算法的队列
            LinkedList<int[]> q = new LinkedList<>();
            // 用来记录已经遍历过的状态，把元组转化成数字方便存储哈希集合
            // 转化方式是 (x, y) -> (x * (y + 1) + y)，和二维数组坐标转一维坐标是一样的原理
            // 因为水桶 2 的取值是 [0, y]，所以需要额外加一，请类比二维数组坐标转一维坐标
            // 且考虑到题目输入的数据规模较大，相乘可能导致 int 溢出，所以使用 long 类型
            HashSet<Long> visited = new HashSet<>();
            // 添加初始状态，两个桶都没有水
            q.offer(new int[] { 0, 0 });
            visited.add((long) 0 * (0 + 1) + 0);

            while (!q.isEmpty()) {
                int[] curState = q.poll();
                if (curState[0] == t || curState[1] == t
                    || curState[0] + curState[1] == t) {
                    // 如果任意一个桶的水量等于目标水量，就返回 true
                    return true;
                }
                // 计算出所有可能的下一个状态
                List<int[]> nextStates = new LinkedList<>();
                // 把 1 桶灌满
                nextStates.add(new int[] { x, curState[1] });
                // 把 2 桶灌满
                nextStates.add(new int[] { curState[0], y });
                // 把 1 桶倒空
                nextStates.add(new int[] { 0, curState[1] });
                // 把 2 桶倒空
                nextStates.add(new int[] { curState[0], 0 });
                // 把 1 桶的水灌进 2 桶，直到 1 桶空了或者 2 桶满了
                nextStates.add(new int[] {
                    curState[0] - Math.min(curState[0], y - curState[1]),
                    curState[1] + Math.min(curState[0], y - curState[1])
                });
                // 把 2 桶的水灌进 1 桶，直到 2 桶空了或者 1 桶满了
                nextStates.add(new int[] {
                    curState[0] + Math.min(curState[1], x - curState[0]),
                    curState[1] - Math.min(curState[1], x - curState[0])
                });

                // 把所有可能的下一个状态都放进队列里
                for (int[] nextState : nextStates) {
                    // 把二维坐标转化为数字，方便去重
                    long hash = (long) nextState[0] * (y + 1) + nextState[1];
                    if (visited.contains(hash)) {
                        // 如果这个状态之前遍历过，就跳过，避免队列永远不空陷入死循环
                        continue;
                    }
                    q.offer(nextState);
                    visited.add(hash);
                }
            }
            return false;
        }

    }

}
