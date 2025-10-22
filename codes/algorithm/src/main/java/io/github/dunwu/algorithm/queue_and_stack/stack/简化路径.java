package io.github.dunwu.algorithm.queue_and_stack.stack;

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
        Assertions.assertEquals("/.../b/d", simplifyPath("/.../a/../b/c/../d/./"));
    }

    public static String simplifyPath(String path) {
        Stack<String> s1 = new Stack<>();
        for (String str : path.split("/")) {
            switch (str) {
                case "":
                case ".":
                    break;
                case "..":
                    if (!s1.isEmpty()) s1.pop();
                    break;
                default:
                    s1.push(str);
                    break;
            }
        }

        StringBuilder result = new StringBuilder();
        while (!s1.isEmpty()) {
            result.insert(0, "/" + s1.pop());
        }
        return result.toString().equals("") ? "/" : result.toString();
    }

}
