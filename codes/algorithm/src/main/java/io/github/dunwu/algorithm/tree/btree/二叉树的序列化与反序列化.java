package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-07-06
 */
public class 二叉树的序列化与反序列化 {

    public static void main(String[] args) {
        // String input = "1,2,null,4,null,null,3,null,null";
        String input2 = "null,null,null,4,2,null,null,3,1";
        TreeNode tree = deserialize(input2);
        Assertions.assertEquals(input2, serialize(tree));
    }

    static final String SEP = ",";
    static final String NULL = "null";

    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializePostOrder(root, sb);
        int size = sb.length();
        int pos = sb.lastIndexOf(SEP);
        if (pos == size - 1) {
            sb.deleteCharAt(pos);
        }
        return sb.toString();
    }

    static void serializePreOrder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }

        // 前序处理
        sb.append(root.val).append(SEP);

        serializePreOrder(root.left, sb);
        serializePreOrder(root.right, sb);
    }

    static void serializePostOrder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }

        serializePostOrder(root.left, sb);
        serializePostOrder(root.right, sb);

        // 后序处理
        sb.append(root.val).append(SEP);
    }

    public static TreeNode deserialize(String data) {
        // 将字符串转化成列表
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.addLast(s);
        }
        return deserializePostOrder(nodes);
    }

    static TreeNode deserializePreOrder(LinkedList<String> nodes) {
        if (nodes.isEmpty()) return null;

        // ****** 前序位置 ********
        // 列表最左侧就是根节点
        String first = nodes.removeFirst();
        if (first.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(first));

        // *********************

        root.left = deserializePreOrder(nodes);
        root.right = deserializePreOrder(nodes);

        return root;
    }

    static TreeNode deserializePostOrder(LinkedList<String> nodes) {
        if (nodes.isEmpty()) return null;

        String last = nodes.removeLast();
        if (last.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(last));

        root.right = deserializePostOrder(nodes);
        root.left = deserializePostOrder(nodes);

        return root;
    }

}
