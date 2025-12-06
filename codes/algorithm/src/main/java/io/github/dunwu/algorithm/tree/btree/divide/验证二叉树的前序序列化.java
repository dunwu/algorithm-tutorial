package io.github.dunwu.algorithm.tree.btree.divide;

import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/verify-preorder-serialization-of-a-binary-tree/">331. 验证二叉树的前序序列化</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-15
 */
public class 验证二叉树的前序序列化 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertTrue(s.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        Assertions.assertFalse(s.isValidSerialization("1,#"));
        Assertions.assertFalse(s.isValidSerialization("9,#,#,1"));

        Solution2 s2 = new Solution2();
        Assertions.assertTrue(s2.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        Assertions.assertFalse(s2.isValidSerialization("1,#"));
        Assertions.assertFalse(s2.isValidSerialization("9,#,#,1"));
    }

    static class Solution {

        /**
         * 参考题解：https://leetcode.cn/problems/verify-preorder-serialization-of-a-binary-tree/solutions/651132/pai-an-jiao-jue-de-liang-chong-jie-fa-zh-66nt
         */
        public boolean isValidSerialization(String preorder) {
            LinkedList<String> stack = new LinkedList<>();
            for (String s : preorder.split(",")) {
                stack.push(s);
                while (stack.size() >= 3
                    && stack.get(0).equals("#")
                    && stack.get(1).equals("#")
                    && !stack.get(2).equals("#")) {
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.push("#");
                }
            }
            return stack.size() == 1 && stack.pop().equals("#");
        }

    }

    static class Solution2 {

        /**
         * 参考题解：https://leetcode.cn/problems/verify-preorder-serialization-of-a-binary-tree/solutions/651132/pai-an-jiao-jue-de-liang-chong-jie-fa-zh-66nt
         */
        public boolean isValidSerialization(String preorder) {
            int diff = 1;
            for (String s : preorder.split(",")) {
                diff -= 1;
                if (diff < 0) {
                    return false;
                }
                if (!s.equals("#")) {
                    diff += 2;
                }
            }
            return diff == 0;
        }

    }

}
