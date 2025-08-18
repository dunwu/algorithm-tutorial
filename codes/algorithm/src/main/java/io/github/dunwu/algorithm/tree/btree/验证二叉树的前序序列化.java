package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import io.github.dunwu.algorithm.tree.TreeUtils;
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
        Assertions.assertTrue(new Solution().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        Assertions.assertFalse(new Solution().isValidSerialization("1,#"));
        Assertions.assertFalse(new Solution().isValidSerialization("9,#,#,1"));
    }

    static class Solution {

        public static final String SEP = ",";
        public static final String NULL = "#";
        boolean isOk = true;

        public boolean isValidSerialization(String preorder) {
            LinkedList<String> nodes = new LinkedList<>();
            for (String s : preorder.split(SEP)) {
                nodes.addFirst(s);
            }
            deserialize(nodes);
            if (nodes.size() > 0) {
                isOk = false;
            }
            return isOk;
        }

        public TreeNode deserialize(LinkedList<String> values) {

            if (values.isEmpty()) return null;

            String value = values.removeLast();
            if (NULL.equals(value)) {
                return null;
            }
            if (values.isEmpty() || values.size() < 2) {
                isOk = false;
                return null;
            }
            TreeNode node = new TreeNode(Integer.parseInt(value));

            node.left = deserialize(values);
            node.right = deserialize(values);

            return node;
        }

    }

}
