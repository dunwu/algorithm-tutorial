package io.github.dunwu.algorithm.tree.btree.divide;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/">106.
 * 从中序与后序遍历序列构造二叉树</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-11
 */
public class 根据前序和后序遍历构造二叉树 {

    public static void main(String[] args) {

        Solution s = new Solution();
        TreeNode output1 = s.constructFromPrePost(new int[] { 1, 2, 4, 5, 3, 6, 7 },
            new int[] { 4, 5, 2, 6, 7, 3, 1 });
        Assertions.assertEquals(TreeNode.buildTree(1, 2, 3, 4, 5, 6, 7), output1);

        TreeNode output2 = s.constructFromPrePost(new int[] { 1 }, new int[] { 1 });
        Assertions.assertEquals(TreeNode.buildTree(1), output2);
    }

    static class Solution {

        Map<Integer, Integer> map = new HashMap<>();

        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            if (preorder.length == 0 || postorder.length == 0) { return null; }
            for (int i = 0; i < postorder.length; i++) {
                map.put(postorder[i], i);
            }
            return build(preorder, 0, preorder.length - 1,
                postorder, 0, postorder.length - 1);
        }

        public TreeNode build(int[] preorder, int preLow, int preHigh,
            int[] postorder, int postLow, int postHigh) {
            if (preLow > preHigh) { return null; }
            if (preLow == preHigh) { return new TreeNode(preorder[preLow]); }
            int leftRootVal = preorder[preLow + 1];
            int leftPostHigh = map.get(leftRootVal);
            int leftLen = leftPostHigh - postLow + 1;
            TreeNode root = new TreeNode(preorder[preLow]);
            root.left = build(preorder, preLow + 1, preLow + leftLen,
                postorder, postLow, leftPostHigh);
            root.right = build(preorder, preLow + leftLen + 1, preHigh,
                postorder, leftPostHigh + 1, postHigh - 1);
            return root;
        }

    }

}
