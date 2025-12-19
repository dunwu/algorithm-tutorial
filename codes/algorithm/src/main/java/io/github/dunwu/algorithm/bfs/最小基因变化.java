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

        final char[] AGCT = new char[] { 'A', 'C', 'G', 'T' };

        public int minMutation(String startGene, String endGene, String[] bank) {
            if (startGene.equals(endGene)) { return 0; }

            int step = 0;
            Set<String> banks = new HashSet<>(Arrays.asList(bank));
            Set<String> visited = new HashSet<>();
            LinkedList<String> queue = new LinkedList<>();
            queue.offer(startGene);

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String curGene = queue.poll();
                    if (curGene.equals(endGene)) { return step; }
                    for (String newGene : neighbours(curGene)) {
                        if (!visited.contains(newGene) && banks.contains(newGene)) {
                            queue.offer(newGene);
                            visited.add(newGene);
                        }
                    }
                }
                step++;
            }
            return -1;
        }

        // 当前基因的每个位置都可以变异为 A/G/C/T，穷举所有可能的结构
        public List<String> neighbours(String gene) {
            List<String> res = new LinkedList<>();
            char[] ch = gene.toCharArray();
            for (int i = 0; i < ch.length; i++) {
                char c = ch[i];
                for (char option : AGCT) {
                    ch[i] = option;
                    res.add(new String(ch));
                }
                ch[i] = c;
            }
            return res;
        }

    }

}
