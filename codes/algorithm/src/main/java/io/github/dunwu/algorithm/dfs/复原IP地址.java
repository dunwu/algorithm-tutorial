package io.github.dunwu.algorithm.dfs;

import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/restore-ip-addresses/">93. 复原 IP 地址</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-12-12
 */
public class 复原IP地址 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertArrayEquals(new String[] { "255.255.11.135", "255.255.111.35" },
            s.restoreIpAddresses("25525511135").toArray());
        Assertions.assertArrayEquals(new String[] { "0.0.0.0" }, s.restoreIpAddresses("0000").toArray());
        Assertions.assertArrayEquals(new String[] { "1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3" },
            s.restoreIpAddresses("101023").toArray());
    }

    static class Solution {

        private LinkedList<String> path;
        private LinkedList<String> res;

        public List<String> restoreIpAddresses(String s) {
            path = new LinkedList<>();
            res = new LinkedList<>();
            dfs(s, 0);
            return res;
        }

        public void dfs(String s, int start) {

            // base case，走到叶子节点
            // 即整个 s 被成功分割为合法的四部分，记下答案
            if (start == s.length() && path.size() == 4) {
                String ip = String.join(".", path);
                res.add(ip);
            }

            for (int i = start; i < s.length(); i++) {

                // s[start..i] 不是合法的 ip 数字，不能分割
                if (!isValid(s, start, i)) { continue; }

                // 已经分解成 4 部分了，不能再分解了
                if (path.size() >= 4) { continue; }

                // 【选择】
                // s[start..i] 是一个合法的 ip 数字，可以进行分割
                // 做选择，把 s[start..i] 放入路径列表中
                path.add(s.substring(start, i + 1));

                // 【回溯】
                dfs(s, i + 1);

                // 【取消选择】
                path.removeLast();
            }
        }

        public boolean isValid(String s, int start, int end) {

            int length = end - start + 1;

            if (length == 0 || length > 3) { return false; }

            // 如果只有一位数字，肯定是合法的
            if (length == 1) { return true; }

            // 多于一位数字，但开头是 0，肯定不合法
            if (s.charAt(start) == '0') { return false; }

            // 排除了开头是 0 的情况，那么如果是两位数，肯定是合法的
            if (length <= 2) { return true; }

            // 现在输入的一定是三位数，不能大于 255
            return Integer.parseInt(s.substring(start, start + length)) <= 255;
        }

    }

}
