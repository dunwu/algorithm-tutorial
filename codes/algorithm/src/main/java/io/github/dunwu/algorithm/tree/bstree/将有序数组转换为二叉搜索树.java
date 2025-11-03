package io.github.dunwu.algorithm.tree.bstree;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes">二叉搜索树结点最小距离</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-07-07
 */
public class 将有序数组转换为二叉搜索树 {

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode output1 = s.sortedArrayToBST(new int[] { -10, -3, 0, 5, 9 });
        Assertions.assertArrayEquals(new Integer[] { 0, -3, 9, -10, null, 5 }, TreeNode.toValueList(output1).toArray());
    }

    static class Solution {

        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums == null || nums.length == 0) { return null; }
            TreeNode root = new TreeNode(nums[0]);
            for (int i = 1; i < nums.length; i++) {
                insert(root, nums[i]);
            }
            return root;
        }

        public void insert(TreeNode root, int val) {
            if (root == null) { return; }
            if (val < root.val) {
                if (root.left == null) {
                    root.left = new TreeNode(val);
                } else {
                    insert(root.left, val);
                }
            } else if (val > root.val) {
                if (root.right == null) {
                    root.right = new TreeNode(val);
                } else {
                    insert(root.right, val);
                }
            }
        }

    }

}
