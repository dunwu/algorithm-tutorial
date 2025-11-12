package io.github.dunwu.algorithm.bfs;

import org.junit.jupiter.api.Assertions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/">297. 二叉树的序列化与反序列化</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-06
 */
public class 打开转盘锁 {

    public static void main(String[] args) {

        Solution s = new Solution();

        String[] deadends = new String[] { "0201", "0101", "0102", "1212", "2002" };
        Assertions.assertEquals(6, s.openLock(deadends, "0202"));

        // String[] deadends2 = new String[] { "8888" };
        // Assertions.assertEquals(1, s.openLock(deadends2, "0009"));
        //
        // String[] deadends3 = new String[] { "8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888" };
        // Assertions.assertEquals(-1, s.openLock(deadends3, "8888"));
    }

    static class Solution {

        public int openLock(String[] deadends, String target) {
            Set<String> black = new HashSet<>();
            for (String d : deadends) {
                black.add(d);
            }

            int step = 0;
            Set<String> visited = new HashSet<>();
            LinkedList<String> queue = new LinkedList<>();
            queue.offer("0000");
            visited.add("0000");

            while (!queue.isEmpty()) {
                int size = queue.size();
                System.out.printf("step: %d\n", step);
                for (int i = 0; i < size; i++) {

                    String node = queue.poll();

                    if (target.equals(node)) {
                        return step;
                    }

                    List<String> neighbors = getNeighbors(node);
                    System.out.printf("\tnode: %s, neighbors: %s\n", node, neighbors);
                    for (String neighbor : getNeighbors(node)) {
                        if (!visited.contains(neighbor) && !black.contains(neighbor)) {
                            queue.offer(neighbor);
                            visited.add(neighbor);
                        }
                    }
                }
                step++;
            }
            return -1;
        }

        String plus(String s, int i) {
            char[] ch = s.toCharArray();
            if (ch[i] == '9') {
                ch[i] = '0';
            } else {
                ch[i] += 1;
            }
            return new String(ch);
        }

        String minus(String s, int i) {
            char[] ch = s.toCharArray();
            if (ch[i] == '0') {
                ch[i] = '9';
            } else {
                ch[i] -= 1;
            }
            return new String(ch);
        }

        List<String> getNeighbors(String s) {
            List<String> neighbors = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                neighbors.add(plus(s, i));
                neighbors.add(minus(s, i));
            }
            return neighbors;
        }

    }

}
