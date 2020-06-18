package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeUtils;
import io.github.dunwu.algorithm.tree.btree.TreeNode;
import org.junit.jupiter.api.Assertions;

import java.util.*;

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
public class 二叉树的锯齿形层次遍历 {

    public static void main(String[] args) {
        TreeNode tree = TreeUtils.buildTree(3, 9, 20, null, null, 15, 7);
        List<List<Integer>> resultList = zigzagLevelOrder(tree);
        System.out.println(resultList);
        List<List<Integer>> expectList = new LinkedList<>();
        expectList.add(Arrays.asList(3));
        expectList.add(Arrays.asList(20, 9));
        expectList.add(Arrays.asList(15, 7));
        Assertions.assertArrayEquals(expectList.toArray(), resultList.toArray());
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root == null) return result;
        queue.offer(root);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    list.add(node.val);
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
            }
            if (reverse) {
                Collections.reverse(list);
                result.add(list);
            } else {
                result.add(list);
            }
            reverse = !reverse;
        }
        return result;
    }

}
