package io.github.dunwu.algorithm.bfs;

import io.github.dunwu.algorithm.util.ArrayUtil;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/accounts-merge/">721. 账户合并</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-07
 */
public class 账户合并 {

    public static void main(String[] args) {

        Solution solution = new Solution();

        String[][] input1 = {
            { "John", "johnsmith@mail.com", "john00@mail.com" },
            { "John", "johnnybravo@mail.com" },
            { "John", "johnsmith@mail.com", "john_newyork@mail.com" },
            { "Mary", "mary@mail.com" }
        };
        String[][] expect1 = {
            { "John", "johnnybravo@mail.com" },
            { "John", "john00@mail.com", "john_newyork@mail.com", "johnsmith@mail.com" },
            { "Mary", "mary@mail.com" }
        };
        List<List<String>> output1 = solution.accountsMerge(ArrayUtil.toStringMatrixList(input1));
        Assertions.assertArrayEquals(expect1, ArrayUtil.toStringMatrixArray(output1));

        String[][] input2 = {
            { "Gabe", "Gabe0@m.co", "Gabe3@m.co", "Gabe1@m.co" },
            { "Kevin", "Kevin3@m.co", "Kevin5@m.co", "Kevin0@m.co" },
            { "Ethan", "Ethan5@m.co", "Ethan4@m.co", "Ethan0@m.co" },
            { "Hanzo", "Hanzo3@m.co", "Hanzo1@m.co", "Hanzo0@m.co" },
            { "Fern", "Fern5@m.co", "Fern1@m.co", "Fern0@m.co" }
        };
        String[][] expect2 = {
            { "Hanzo", "Hanzo0@m.co", "Hanzo1@m.co", "Hanzo3@m.co" },
            { "Fern", "Fern0@m.co", "Fern1@m.co", "Fern5@m.co" },
            { "Gabe", "Gabe0@m.co", "Gabe1@m.co", "Gabe3@m.co" },
            { "Kevin", "Kevin0@m.co", "Kevin3@m.co", "Kevin5@m.co" },
            { "Ethan", "Ethan0@m.co", "Ethan4@m.co", "Ethan5@m.co" }
        };
        List<List<String>> output2 = solution.accountsMerge(ArrayUtil.toStringMatrixList(input2));
        Assertions.assertArrayEquals(expect2, ArrayUtil.toStringMatrixArray(output2));
    }

    static class Solution {

        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            // key: email, value: 出现该 email 的 account 的索引列表
            HashMap<String, List<Integer>> emailToIdx = new HashMap<>();
            for (int i = 0; i < accounts.size(); i++) {
                List<String> account = accounts.get(i);
                for (int j = 1; j < account.size(); j++) {
                    String email = account.get(j);
                    List<Integer> indexes = emailToIdx.getOrDefault(email, new ArrayList<>());
                    indexes.add(i);
                    emailToIdx.put(email, indexes);
                }
            }

            // 计算合并后的账户
            List<List<String>> res = new ArrayList<>();
            HashSet<String> visitedEmails = new HashSet<>();

            for (String email : emailToIdx.keySet()) {
                if (visitedEmails.contains(email)) {
                    continue;
                }
                // 合并账户，用 BFS 算法穷举所有和 email 相关联的邮箱
                LinkedList<String> mergedEmail = new LinkedList<>();
                LinkedList<String> queue = new LinkedList<>();
                queue.offer(email);
                visitedEmails.add(email);
                // BFS 算法框架
                while (!queue.isEmpty()) {
                    String curEmail = queue.poll();
                    mergedEmail.addLast(curEmail);
                    List<Integer> indexes = emailToIdx.get(curEmail);
                    for (int index : indexes) {
                        List<String> account = accounts.get(index);
                        for (int j = 1; j < account.size(); j++) {
                            String nextEmail = account.get(j);
                            if (!visitedEmails.contains(nextEmail)) {
                                queue.offer(nextEmail);
                                visitedEmails.add(nextEmail);
                            }
                        }
                    }
                }
                String userName = accounts.get(emailToIdx.get(email).get(0)).get(0);
                // mergedEmail 是 userName 的所有邮箱
                Collections.sort(mergedEmail);
                mergedEmail.addFirst(userName);
                res.add(mergedEmail);
            }
            return res;
        }

    }

}
