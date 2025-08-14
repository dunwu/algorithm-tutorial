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
        Assertions.assertEquals("/home", simplifyPath("/home/"));
        Assertions.assertEquals("/home/foo", simplifyPath("/home//foo/"));
        Assertions.assertEquals("/home/user/Pictures", simplifyPath("/home/user/Documents/../Pictures"));
        Assertions.assertEquals("/", simplifyPath("/../"));
    }

    public static String simplifyPath(String path) {
        String[] parts = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String part : parts) {
            if (part.isEmpty() || part.equals(".")) continue;
            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(part);
            }
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }
        return res.isEmpty() ? "/" : res;
    }

}
