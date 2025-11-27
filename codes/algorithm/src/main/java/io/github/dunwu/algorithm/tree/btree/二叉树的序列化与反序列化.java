package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

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

        // 主函数，将二叉树序列化为字符串
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }

        // 辅助函数，将二叉树存入 StringBuilder
        void serialize(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append(NULL).append(SEP);
                return;
            }

            // ****** 前序位置 ********
            sb.append(root.val).append(SEP);

            // ***********************

            serialize(root.left, sb);
            serialize(root.right, sb);
        }

        // 主函数，将字符串反序列化为二叉树结构
        public TreeNode deserialize(String data) {
            // 将字符串转化成列表
            LinkedList<String> nodes = new LinkedList<>();
            for (String s : data.split(SEP)) {
                nodes.addLast(s);
            }
            return deserialize(nodes);
        }

        // 辅助函数，通过 nodes 列表构造二叉树
        TreeNode deserialize(LinkedList<String> nodes) {
            if (nodes.isEmpty()) return null;

            // ****** 前序位置 ********
            // 列表最左侧就是根节点
            String first = nodes.removeFirst();
            if (first.equals(NULL)) return null;
            TreeNode root = new TreeNode(Integer.parseInt(first));

            // *********************

            root.left = deserialize(nodes);
            root.right = deserialize(nodes);

            return root;
        }

    }

}
