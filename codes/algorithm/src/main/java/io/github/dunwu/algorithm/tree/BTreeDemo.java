package io.github.dunwu.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-01-20
 */
public class BTreeDemo {

    /**
     * 前序遍历递归方法
     *
     * @param root {@link TreeNode}
     */
    public static void preOrder(TreeNode root) {
        TreeNode node = root;
        if (node != null) {
            System.out.print(node.val + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 前序遍历非递归方法
     *
     * @param root {@link TreeNode}
     */
    public static void preOrder2(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                System.out.print(root.val + " ");
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                TreeNode t = stack.pop();
                root = t.right;
            }
        }
    }

    /**
     * 中序遍历递归方法
     *
     * @param root {@link TreeNode}
     */
    public static void inOrder(TreeNode root) {
        if (root != null) {
            preOrder(root.left);
            System.out.print(root.val + " ");
            preOrder(root.right);
        }
    }

    /**
     * 中序遍历非递归方法
     *
     * @param root {@link TreeNode}
     */
    public static void inOrder2(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                TreeNode t = stack.pop();
                System.out.print(t.val + " ");
                root = t.right;
            }
        }
    }

    public static void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val + " ");
        }
    }

    /**
     * 中序遍历非递归方法
     *
     * @param root {@link TreeNode}
     */
    public static void postOrder2(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                TreeNode t = stack.pop();
                System.out.print(t.val + " ");
                root = t.left;
            }
        }
    }

    public static void levelTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + "  ");
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
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

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return _sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public static TreeNode _sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) return null;

        // always choose left middle node as a root
        int p = (left + right) / 2;

        // inorder traversal: left -> node -> right
        TreeNode root = new TreeNode(nums[p]);
        root.left = _sortedArrayToBST(nums, left, p - 1);
        root.right = _sortedArrayToBST(nums, p + 1, right);
        return root;
    }

    public static class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;

        public TreeNode(int val) { this.val = val; }

    }

}
