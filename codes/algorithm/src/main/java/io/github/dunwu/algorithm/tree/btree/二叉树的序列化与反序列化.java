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
        TreeNode tree1 = deserialize(input1);
        Assertions.assertEquals(input1, serialize(tree1));
    }

    static final String SEP = ",";
    static final String NULL = "null";

    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        doSerialize(root, sb);
        return sb.toString();
    }

    static void doSerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        sb.append(root.val).append(SEP);
        doSerialize(root.left, sb);
        doSerialize(root.right, sb);
    }

    public static TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>(Arrays.asList(data.split(SEP)));
        return doDeserialize(nodes);
    }

    static TreeNode doDeserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) return null;

        // =============== 前序遍历处理 ===============
        String val = nodes.removeFirst();
        if (NULL.equals(val)) { return null; }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        // ==========================================

        root.left = doDeserialize(nodes);
        root.right = doDeserialize(nodes);
        return root;
    }

}
