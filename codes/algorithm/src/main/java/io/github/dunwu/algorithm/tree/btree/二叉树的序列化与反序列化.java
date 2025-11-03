package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/">297. 二叉树的序列化与反序列化</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-07-06
 */
public class 二叉树的序列化与反序列化 {

    public static void main(String[] args) {

        String input1 = "1,2,3,null,null,4,5,null,null,null,null,";
        String input2 = "null,";
        String input3 = "1,null,null,";
        String input4 = "1,2,null,null,null,";

        Solution s = new Solution();
        Assertions.assertEquals(input1, s.serialize(s.deserialize(input1)));
        Assertions.assertEquals(input2, s.serialize(s.deserialize(input2)));
        Assertions.assertEquals(input3, s.serialize(s.deserialize(input3)));
        Assertions.assertEquals(input4, s.serialize(s.deserialize(input4)));
    }

    static class Solution {

        public static final String SEP = ",";
        public static final String NULL = "null";

        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }

        void serialize(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append(NULL).append(SEP);
                return;
            }
            sb.append(root.val).append(SEP);
            serialize(root.left, sb);
            serialize(root.right, sb);
        }

        public TreeNode deserialize(String data) {
            LinkedList<String> values = new LinkedList<>(Arrays.asList(data.split(SEP)));
            return deserialize(values);
        }

        public TreeNode deserialize(LinkedList<String> values) {
            if (values == null || values.isEmpty()) { return null; }
            String val = values.removeFirst();
            if (val.equals(NULL)) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(val));
            root.left = deserialize(values);
            root.right = deserialize(values);
            return root;
        }

    }

}
