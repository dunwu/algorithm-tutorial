package io.github.dunwu.algorithm.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * 二叉树节点
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-01-28
 */
public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode(int val) { this.val = val; }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TreeNode)) return false;
        TreeNode treeNode = (TreeNode) o;
        return val == treeNode.val &&
            Objects.equals(left, treeNode.left) &&
            Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
    }

    public static String serialize(TreeNode root) {
        return serialize(root, "NULL", ",");
    }

    public static String serialize(TreeNode root, String nullFlag, String sepFlag) {
        StringBuilder sb = new StringBuilder();
        doSerialize(root, sb, nullFlag, sepFlag);
        return sb.toString();
    }

    static void doSerialize(TreeNode root, StringBuilder sb, String nullFlag, String sepFlag) {
        if (root == null) {
            sb.append(nullFlag).append(sepFlag);
            return;
        }
        sb.append(root.val).append(sepFlag);
        doSerialize(root.left, sb, nullFlag, sepFlag);
        doSerialize(root.right, sb, nullFlag, sepFlag);
    }

    public static TreeNode deserialize(String data) {
        return deserialize(data, "NULL", ",");
    }

    public static TreeNode deserialize(String data, String nullFlag, String sepFlag) {
        LinkedList<String> nodes = new LinkedList<>(Arrays.asList(data.split(sepFlag)));
        return doDeserialize(nodes, nullFlag);
    }

    static TreeNode doDeserialize(LinkedList<String> nodes, String nullFlag) {
        if (nodes.isEmpty()) return null;

        // =============== 前序遍历处理 ===============
        String val = nodes.removeFirst();
        if (nullFlag.equals(val)) { return null; }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        // ==========================================

        root.left = doDeserialize(nodes, nullFlag);
        root.right = doDeserialize(nodes, nullFlag);
        return root;
    }

    public static TreeNode buildTree(Integer... values) {

        if (values == null || values.length == 0 || values[0] == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(values[0]);
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            TreeNode current = queue.poll();

            // 处理左子节点
            if (i < values.length && values[i] != null) {
                current.left = new TreeNode(values[i]);
                queue.offer(current.left);
            }
            i++;

            // 处理右子节点
            if (i < values.length && values[i] != null) {
                current.right = new TreeNode(values[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    public static TreeNode find(TreeNode root, int val) {
        if (root == null || root.val == val) { return root; }
        TreeNode left = find(root.left, val);
        if (left != null) return left;
        return find(root.right, val);
    }

    public static List<TreeNode> toList(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node);
            if (node == null) continue;
            queue.add(node.left);
            queue.add(node.right);
        }

        // 删除队列尾部的所有 null
        int last = list.size() - 1;
        while (last > 0 && list.get(last) == null) {
            last--;
        }
        return list.subList(0, last + 1);
    }

    public static List<Integer> toValueList(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                list.add(null);
                continue;
            } else {
                list.add(node.val);
            }

            queue.add(node.left);
            queue.add(node.right);
        }

        // 删除队列尾部的所有 null
        int last = list.size() - 1;
        while (last > 0 && list.get(last) == null) {
            last--;
        }
        return list.subList(0, last + 1);
    }

}
