package io.github.dunwu.algorithm.bfs;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/minimum-genetic-mutation/">433. 最小基因变化</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-07
 */
public class 最小基因变化 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(1,
            s.minMutation("AACCGGTT", "AACCGGTA", new String[] { "AACCGGTA" }));
        Assertions.assertEquals(2,
            s.minMutation("AACCGGTT", "AAACGGTA", new String[] { "AACCGGTA", "AACCGCTA", "AAACGGTA" }));
        Assertions.assertEquals(3,
            s.minMutation("AAAAACCC", "AACCCCCC", new String[] { "AAAACCCC", "AAACCCCC", "AACCCCCC" }));
        Assertions.assertEquals(-1,
            s.minMutation("AACCGGTT", "AACCGGTA", new String[] {}));
        Assertions.assertEquals(-1,
            s.minMutation("AAAAAAAA", "CCCCCCCC",
                new String[] { "AAAAAAAA", "AAAAAAAC", "AAAAAACC", "AAAAACCC", "AAAACCCC", "AACACCCC", "ACCACCCC",
                    "ACCCCCCC", "CCCCCCCA" }));
    }

    static class Solution {

        final char[] options = new char[] { 'A', 'C', 'G', 'T' };

        public int minMutation(String startGene, String endGene, String[] bank) {
            return bfs(startGene, endGene, bank);
        }

        public int bfs(String startGene, String endGene, String[] bank) {

            Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
            // 最终结果不在有效基因集合中，直接返回
            if (!bankSet.contains(endGene)) {
                return -1;
            }

            Set<String> visited = new HashSet<>();
            LinkedList<String> queue = new LinkedList<>();
            queue.offer(startGene);

            int step = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String cur = queue.poll();
                    if (cur.equals(endGene)) {
                        return step;
                    }

                    List<String> neighbors = getNeighbors(cur, bankSet);
                    System.out.printf("%s 的邻居：%s\n", cur, neighbors);
                    for (String str : neighbors) {
                        if (visited.contains(str)) {
                            continue;
                        }
                        visited.add(str);
                        queue.offer(str);
                    }
                }
                step++;
            }
            return -1;
        }

        public List<String> getNeighbors(String s, Set<String> bankSet) {
            List<String> list = new LinkedList<>();
            char[] ch = s.toCharArray();
            for (int i = 0; i < ch.length; i++) {
                char oldChar = ch[i];
                for (char newChar : options) {
                    if (oldChar != newChar) {
                        ch[i] = newChar;
                        String str = new String(ch);
                        if (bankSet.contains(str)) {
                            list.add(str);
                        }
                    }
                }
                ch[i] = oldChar;
            }
            return list;
        }

    }

}
