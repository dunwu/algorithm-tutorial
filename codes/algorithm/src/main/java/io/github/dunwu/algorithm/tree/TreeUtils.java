package io.github.dunwu.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-01-28
 */
public class TreeUtils {

    public static TreeNode buildTree(Integer... array) {
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

    public static void main(String[] args) {
        Integer[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        TreeNode head = TreeUtils.buildTree(array);
        levelTraverse(head);
    }

}
