package io.github.dunwu.algorithm.tree;

import java.util.*;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-01-28
 */
public class TreeUtils {

    public static TreeNode buildTree(Integer[] array) {
        List<TreeNode> list = new ArrayList<>();

        for (Integer value : array) {
            // 创建结点，每一个结点的左结点和右结点为null
            TreeNode node;
            if (value == null) {
                node = null;
            } else {
                node = new TreeNode(value, null, null);
            }
            // list中存着每一个结点
            list.add(node);
        }

        // 构建二叉树
        if (list.size() > 0) {
            // i表示的是根节点的索引，从0开始
            for (int i = 0; i < array.length / 2 - 1; i++) {
                if (list.get(2 * i + 1) != null) {
                    // 左结点
                    list.get(i).left = list.get(2 * i + 1);
                }
                if (list.get(2 * i + 2) != null) {
                    // 右结点
                    list.get(i).right = list.get(2 * i + 2);
                }
            }
            // 判断最后一个根结点：因为最后一个根结点可能没有右结点，所以单独拿出来处理
            int lastIndex = array.length / 2 - 1;

            // 左结点
            list.get(lastIndex).left = list.get(lastIndex * 2 + 1);
            // 右结点，如果数组的长度为奇数才有右结点
            if (array.length % 2 == 1) {
                list.get(lastIndex).right = list.get(lastIndex * 2 + 2);
            }

            return list.get(0);
        } else {
            return null;
        }
    }

    public static TreeNode asTree(Integer... array) {
        return buildTree(array);
    }

    public static TreeNode find(TreeNode root, int val) {
        if (root == null || root.val == val) { return root;}
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

    public static List<TreeNode> levelTraverse(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return list;
    }

    public static String rserialize(TreeNode root, String str) {
        if (root == null) {
            str += "null,";
        } else {
            str += str.valueOf(root.val) + ",";
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }
        return str;
    }

    public static String serialize(TreeNode root) {
        String text = rserialize(root, "");
        while (text.endsWith("null,")) {
            int index = text.lastIndexOf("null,");
            text = text.substring(0, index);
        }
        if (text.endsWith(",")) {
            text = text.substring(0, text.length() - 1);
        }
        return text;
    }

    public static TreeNode rdeserialize(List<String> list) {
        List<TreeNode> nodes = new ArrayList<>();

        for (String value : list) {
            // 创建结点，每一个结点的左结点和右结点为null
            TreeNode node;
            if (value == null || value.equalsIgnoreCase("null")) {
                node = null;
            } else {
                node = new TreeNode(Integer.parseInt(value), null, null);
            }
            // list中存着每一个结点
            nodes.add(node);
        }

        // 构建二叉树
        if (nodes.size() > 0) {
            // i表示的是根节点的索引，从0开始
            for (int i = 0; i < list.size() / 2 - 1; i++) {
                if (nodes.get(2 * i + 1) != null) {
                    // 左结点
                    nodes.get(i).left = nodes.get(2 * i + 1);
                }
                if (nodes.get(2 * i + 2) != null) {
                    // 右结点
                    nodes.get(i).right = nodes.get(2 * i + 2);
                }
            }
            // 判断最后一个根结点：因为最后一个根结点可能没有右结点，所以单独拿出来处理
            int lastIndex = list.size() / 2 - 1;

            // 左结点
            nodes.get(lastIndex).left = nodes.get(lastIndex * 2 + 1);
            // 右结点，如果数组的长度为奇数才有右结点
            if (list.size() % 2 == 1) {
                nodes.get(lastIndex).right = nodes.get(lastIndex * 2 + 2);
            }

            return nodes.get(0);
        } else {
            return null;
        }
    }

    public static TreeNode deserialize(String data) {
        data = data.substring(1, data.length() - 1);
        String[] nums = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(nums));
        return rdeserialize(list);
    }

    public static void main(String[] args) {
        Integer[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        TreeNode head = TreeUtils.asTree(array);
        levelTraverse(head);
    }

}
