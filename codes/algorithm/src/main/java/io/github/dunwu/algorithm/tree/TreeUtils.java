package io.github.dunwu.algorithm.tree;

import java.util.*;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-01-28
 */
public class TreeUtils {

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

    public static void depthOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + "  ");
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
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

    public static String serialize(TreeNode root, String NULL, String SEP) {
        StringBuilder sb = new StringBuilder();
        serializePreOrder(root, sb, NULL, SEP);
        int size = sb.length();
        int pos = sb.lastIndexOf(SEP);
        if (pos == size - 1) {
            sb.deleteCharAt(pos);
        }
        return sb.toString();
    }

    static void serializePreOrder(TreeNode root, StringBuilder sb, String NULL, String SEP) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }

        // 前序处理
        sb.append(root.val).append(SEP);

        serializePreOrder(root.left, sb, NULL, SEP);
        serializePreOrder(root.right, sb, NULL, SEP);
    }

    public static TreeNode deserialize(String data, String SEP, String NULL) {
        // 将字符串转化成列表
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.addLast(s);
        }
        return deserializePreOrder(nodes, NULL);
    }

    static TreeNode deserializePreOrder(LinkedList<String> nodes, String NULL) {
        if (nodes.isEmpty()) return null;

        String first = nodes.removeFirst();
        if (first.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(first));

        root.left = deserializePreOrder(nodes, NULL);
        root.right = deserializePreOrder(nodes, NULL);

        return root;
    }

    public static void main(String[] args) {
        Integer[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        TreeNode head = TreeUtils.buildTree(array);
        toList(head);
    }

}
