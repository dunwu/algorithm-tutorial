package io.github.dunwu.algorithm.tree;

import java.util.*;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-01-28
 */
public class TreeUtils {

    static final String SEP = ",";
    static final String NULL = "null";

    public static TreeNode buildTree(Integer... arr) {
        List<TreeNode> list = new ArrayList<>();

        for (Integer value : arr) {
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
            for (int i = 0; i < arr.length / 2 - 1; i++) {
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
            int lastIndex = arr.length / 2 - 1;

            if (list.get(lastIndex) != null) {
                // 左结点
                list.get(lastIndex).left = list.get(lastIndex * 2 + 1);
                // 右结点，如果数组的长度为奇数才有右结点
                if (arr.length % 2 == 1) {
                    list.get(lastIndex).right = list.get(lastIndex * 2 + 2);
                }
            }

            return list.get(0);
        } else {
            return null;
        }
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

    public static List<TreeNode> toBfsList(TreeNode root) {
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

    public static List<Integer> toBfsValueList(TreeNode root) {
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

    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializePreOrder(root, sb);
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

    public static TreeNode deserialize(String data) {
        // 将字符串转化成列表
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.addLast(s);
        }
        return deserializePreOrder(nodes);
    }

    static TreeNode deserializePreOrder(LinkedList<String> nodes) {
        if (nodes.isEmpty()) return null;

        String first = nodes.removeFirst();
        if (first.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(first));

        root.left = deserializePreOrder(nodes);
        root.right = deserializePreOrder(nodes);

        return root;
    }

    public static void main(String[] args) {
        Integer[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        TreeNode head = TreeUtils.buildTree(array);
        toBfsList(head);
    }

}
