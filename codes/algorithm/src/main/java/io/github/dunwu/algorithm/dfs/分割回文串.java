package io.github.dunwu.algorithm.dfs;

import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/palindrome-partitioning/">131. 分割回文串</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-12-12
 */
public class 分割回文串 {

    public static void main(String[] args) {
        Solution s = new Solution();

        String[][] expect = new String[][] { { "a", "a", "b" }, { "aa", "b" } };
        List<List<String>> output = s.partition("aab");
        Assertions.assertEquals(expect.length, output.size());

        List<List<String>> output2 = s.partition("a");
        Assertions.assertEquals(1, output2.size());
    }

    static class Solution {

        private List<String> path;
        private List<List<String>> res;

        public List<List<String>> partition(String s) {
            path = new LinkedList<>();
            res = new LinkedList<>();
            dfs(s, 0);
            return res;
        }

        public void dfs(String s, int start) {
            if (start == s.length()) {
                // base case，走到叶子节点
                // 即整个 s 被成功分割为若干个回文子串，记下答案
                res.add(new LinkedList<String>(path));
            }
            for (int i = start; i < s.length(); i++) {
                if (!isPalindrome(s, start, i)) {
                    // s[start..i] 不是回文串，不能分割
                    continue;
                }
                // s[start..i] 是一个回文串，可以进行分割
                // 做选择，把 s[start..i] 放入路径列表中
                path.add(s.substring(start, i + 1));
                // 进入回溯树的下一层，继续切分 s[i+1..]
                dfs(s, i + 1);
                // 撤销选择
                path.remove(path.size() - 1);
            }
        }

        // 用双指针技巧判断 s[low..high] 是否是一个回文串
        public boolean isPalindrome(String s, int low, int high) {
            while (low < high) {
                if (s.charAt(low) != s.charAt(high)) { return false; }
                low++;
                high--;
            }
            return true;
        }

    }

}
