package io.github.dunwu.algorithm.tree.bstree;

import io.github.dunwu.algorithm.tree.TreeNode;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-07-07
 */
public class 将有序数组转换为二叉搜索树 {

    public static void main(String[] args) {
        System.out.println("result = " + sortedArrayToBST(new int[] { -10, -3, 0, 5, 9 }));
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return backtrack(nums, 0, nums.length - 1);
    }

    public static TreeNode backtrack(int[] nums, int left, int right) {
        if (left > right) return null;
        // always choose left middle node as a root
        int p = (left + right) / 2;

        // inorder traversal: left -> node -> right
        TreeNode root = new TreeNode(nums[p]);
        root.left = backtrack(nums, left, p - 1);
        root.right = backtrack(nums, p + 1, right);
        return root;
    }

}
