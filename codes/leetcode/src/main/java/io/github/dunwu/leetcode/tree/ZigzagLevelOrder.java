package io.github.dunwu.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <code>103. 二叉树的锯齿形层次遍历</code> 算法实现
 * <p>
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：给定二叉树 [3,9,20,null,null,15,7],
 * <pre>
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * </pre>
 * 返回锯齿形层次遍历如下：
 * <pre>
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * </pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/">103. 二叉树的锯齿形层次遍历</a>
 */
public class ZigzagLevelOrder {

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildTree(3, 9, 20, null, null, 15, 7);
        ZigzagLevelOrder demo = new ZigzagLevelOrder();
        List<List<Integer>> lists = demo.zigzagLevelOrder(root);
        System.out.println(lists);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        boolean reverse = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            LinkedList<Integer> layer = new LinkedList<>();
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();

                if (!reverse) {
                    layer.add(node.val);
                } else {
                    layer.addFirst(node.val);
                }

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            reverse = !reverse;
            list.add(layer);
        }

        return list;
    }

}
