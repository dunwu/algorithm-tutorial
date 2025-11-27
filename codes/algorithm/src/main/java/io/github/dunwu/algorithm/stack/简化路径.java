package io.github.dunwu.algorithm.stack;

import org.junit.jupiter.api.Assertions;

import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/simplify-path/">71. 简化路径</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2025-08-08
 */
public class 简化路径 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals("/home", s.simplifyPath("/home/"));
        Assertions.assertEquals("/home/foo", s.simplifyPath("/home//foo/"));
        Assertions.assertEquals("/home/user/Pictures", s.simplifyPath("/home/user/Documents/../Pictures"));
        Assertions.assertEquals("/", s.simplifyPath("/../"));
        Assertions.assertEquals("/.../b/d", s.simplifyPath("/.../a/../b/c/../d/./"));
    }

    static class Solution {

        public String simplifyPath(String path) {
            String[] parts = path.split("/");
            Stack<String> stk = new Stack<>();
            // 借助栈计算最终的文件夹路径
            for (String part : parts) {
                if (part.isEmpty() || part.equals(".")) {
                    continue;
                }
                if (part.equals("..")) {
                    if (!stk.isEmpty()) stk.pop();
                    continue;
                }
                stk.push(part);
            }
            // 栈中存储的文件夹组成路径
            String res = "";
            while (!stk.isEmpty()) {
                res = "/" + stk.pop() + res;
            }
            return res.isEmpty() ? "/" : res;
        }

    }

}
