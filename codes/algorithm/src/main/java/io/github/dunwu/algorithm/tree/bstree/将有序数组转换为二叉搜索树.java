package io.github.dunwu.algorithm.tree.bstree;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/">108. 将有序数组转换为二叉搜索树</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-07-07
 */
public class 将有序数组转换为二叉搜索树 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(TreeNode.buildTree(0, -3, 9, -10, null, 5),
            s.sortedArrayToBST(new int[] { -10, -3, 0, 5, 9 }));
        Assertions.assertEquals(TreeNode.buildTree(3, 1), s.sortedArrayToBST(new int[] { 1, 3 }));
    }

    static class Solution {

        public TreeNode sortedArrayToBST(int[] nums) {
            return sortedArrayToBST(nums, 0, nums.length - 1);
        }

        // 将闭区间 [left, right] 中的元素转化成 BST，返回根节点
        TreeNode sortedArrayToBST(int[] nums, int left, int right) {
            if (left > right) {
                // 区间为空
                return null;
            }
            // 构造根节点
            // BST 节点左小右大，中间的元素就是根节点
            int mid = (left + right) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            // 递归构建左子树
            root.left = sortedArrayToBST(nums, left, mid - 1);
            // 递归构造右子树
            root.right = sortedArrayToBST(nums, mid + 1, right);
            return root;
        }

    }

}
