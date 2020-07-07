package io.github.dunwu.algorithm.tree.bstree;

import io.github.dunwu.algorithm.tree.TreeNode;
import io.github.dunwu.algorithm.tree.TreeUtils;
import org.junit.jupiter.api.Assertions;

import java.util.*;

/**
 * <code>98. 验证二叉搜索树</code> 算法实现
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @see <a href="https://leetcode-cn.com/problems/validate-binary-search-tree/">98. 验证二叉搜索树</a>
 * @since 2020-07-02
 */
public class 验证二叉搜索树 {

    public static void main(String[] args) {
        TreeNode root = TreeUtils.asTree(2, 1, 3);
        TreeNode root2 = TreeUtils.asTree(5, 1, 4, null, null, 3, 6);
        TreeNode root3 = TreeUtils.asTree(1, 1);

        Assertions.assertTrue(isValidBST(root));
        Assertions.assertFalse(isValidBST(root2));
        Assertions.assertFalse(isValidBST(root3));

        Assertions.assertTrue(isValidBST2(root));
        Assertions.assertFalse(isValidBST2(root2));
        Assertions.assertFalse(isValidBST2(root3));
    }

    public static boolean isValidBST(TreeNode root) {
        return help(root, null, null);
    }

    public static boolean help(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if (min != null && root.val <= min) return false;
        if (max != null && root.val >= max) return false;
        return help(root.left, min, root.val) && help(root.right, root.val, max);
    }

    /**
     * 中序遍历二叉搜索树获取到的一定是有序数组。符合这个条件的就是有效二叉搜索树
     * <p>
     * 遍历二叉搜索树的时间复杂度：O(N) 但是对 List 进行排序，也要耗费时间，所以综合来看，应该是 O(N) + O(log N)
     * <p>
     * 空间复杂度：用两个链表进行比较，占用了 O(2N)，比较耗费空间，性能并不好
     */
    public static boolean isValidBST2(TreeNode root) {
        if (root == null) { return true; }
        List<Integer> list = new LinkedList<>();
        inOrder2(root, list);

        // 这里使用 TreeSet，基于两个目的：（1）去重 （2）根据值排序
        Set<Integer> set2 = new TreeSet<>();
        set2.addAll(list);
        return Arrays.equals(list.toArray(), set2.toArray());
    }

    // 单纯的中序遍历
    public static void inOrder2(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inOrder2(root.left, list);
        list.add(root.val);
        inOrder2(root.right, list);
    }

}
