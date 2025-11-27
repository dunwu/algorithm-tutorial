package io.github.dunwu.algorithm.tree.btree.divide;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
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
    }

    static class Solution {

        /**
         * 参考题解：https://leetcode.cn/problems/verify-preorder-serialization-of-a-binary-tree/solutions/651132/pai-an-jiao-jue-de-liang-chong-jie-fa-zh-66nt
         */
        public boolean isValidSerialization(String preorder) {
            LinkedList<String> values = new LinkedList<>(Arrays.asList(preorder.split(",")));
            int diff = 1;
            for (String val : values) {
                diff -= 1;
                if (diff < 0) {
                    return false;
                }
                if (!val.equals("#")) {
                    diff += 2;
                }
            }
            return diff == 0;
        }

    }

}
