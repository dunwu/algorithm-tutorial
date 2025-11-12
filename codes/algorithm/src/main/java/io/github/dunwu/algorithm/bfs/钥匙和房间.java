package io.github.dunwu.algorithm.bfs;

import org.junit.jupiter.api.Assertions;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/keys-and-rooms/">841. 钥匙和房间</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-07
 */
public class 钥匙和房间 {

    public static void main(String[] args) {
        Solution s = new Solution();

        List<List<Integer>> input1 = new LinkedList<>();
        input1.add(Collections.singletonList(1));
        input1.add(Collections.singletonList(2));
        input1.add(Collections.singletonList(3));
        input1.add(new LinkedList<>());
        Assertions.assertTrue(s.canVisitAllRooms(input1));
    }

    static class Solution {

        public boolean canVisitAllRooms(List<List<Integer>> rooms) {

            Set<Integer> visited = new HashSet<>();
            LinkedList<Integer> queue = new LinkedList<>();
            queue.offer(0);

            while (!queue.isEmpty()) {
                Integer cur = queue.poll();
                if (visited.contains(cur)) {
                    continue;
                }
                visited.add(cur);
                if (visited.size() == rooms.size()) {
                    return true;
                }

                for (Integer room : rooms.get(cur)) {
                    queue.offer(room);
                }
            }

            return false;
        }

    }

}
