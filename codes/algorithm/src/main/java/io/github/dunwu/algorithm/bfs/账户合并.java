package io.github.dunwu.algorithm.bfs;

import java.util.Arrays;
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
        List<List<String>> input1 = new LinkedList<>();
        input1.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
        input1.add(Arrays.asList("John", "johnnybravo@mail.com"));
        input1.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        input1.add(Arrays.asList("Mary", "mary@mail.com"));
        List<List<String>> output1 = solution.accountsMerge(input1);
        System.out.println("output1: " + output1);
    }

    static class Solution {

        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            return null;
        }

    }

}
