package io.github.dunwu.ds.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-01-18
 */
public class LeetcodeBTreeDemo {

    static TreeNode ans;

    public LeetcodeBTreeDemo() {
        this.ans = null;
    }

    private static boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {

        // If reached the end of a branch, return false.
        if (currentNode == null) {
            return false;
        }

        // Left Recursion. If left recursion returns true, set left = 1 else 0
        int left = recurseTree(currentNode.left, p, q) ? 1 : 0;

        // Right Recursion
        int right = recurseTree(currentNode.right, p, q) ? 1 : 0;

        // If the current node is one of p or q
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;

        // If any two of the flags left, right or mid become True
        if (mid + left + right >= 2) {
            ans = currentNode;
        }

        // Return true if any one of the three bool values is True.
        return (mid + left + right > 0);
    }

    /**
     * <code>二叉树的最近公共祖先</code> 算法实现
     * <p>
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     * <p>
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     * <p>
     * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
     * <p>
     * 示例 1:
     *
     * <pre>
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     * 输出: 3
     * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
     * </pre>
     * <p>
     * 示例 2:
     *
     * <pre>
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
     * 输出: 5
     * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
     * </pre>
     * <p>
     * 说明:
     * <p>
     * 所有节点的值都是唯一的。
     * <p>
     * p、q 为不同节点且均存在于给定的二叉树中。
     *
     * @see <a href="https://leetcode-cn.com/explore/featured/card/bytedance/244/linked-list-and-tree/1026/">二叉树的最近公共祖先</a>
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Traverse the tree
        recurseTree(root, p, q);
        return ans;
    }

    /**
     * <code>二叉树的锯齿形层次遍历</code> 算法实现
     * <p>
     * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     * <p>
     * 例如：给定二叉树 [3,9,20,null,null,15,7],
     *
     * <pre>
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * </pre>
     * 返回锯齿形层次遍历如下：
     *
     * <pre>
     * [
     *   [3],
     *   [20,9],
     *   [15,7]
     * ]
     * </pre>
     *
     * @see <a href="https://leetcode-cn.com/explore/featured/card/bytedance/244/linked-list-and-tree/1027/">二叉树的锯齿形层次遍历</a>
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

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

    public static class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;

        public TreeNode(int val) { this.val = val; }

    }

}
