package io.github.dunwu.algorithm.tree.btree.divide;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">105.
 * 从前序与中序遍历序列构造二叉树</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-11
 */
public class 从前序与中序遍历序列构造二叉树 {

    public static void main(String[] args) {

        Solution s = new Solution();

        TreeNode output1 = s.buildTree(new int[] { 3, 9, 20, 15, 7 }, new int[] { 9, 3, 15, 20, 7 });
        Assertions.assertEquals(TreeNode.buildTree(3, 9, 20, null, null, 15, 7), output1);

        TreeNode output2 = s.buildTree(new int[] { -1 }, new int[] { -1 });
        Assertions.assertEquals(TreeNode.buildTree(-1), output2);
    }

    static class Solution {

        Map<Integer, Integer> map = null;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (inorder == null || preorder == null) { return null; }
            map = new HashMap<>(inorder.length);
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
        }

        public TreeNode build(int[] preorder, int preLow, int preHigh,
            int[] inorder, int inLow, int inHigh) {
            if (preLow > preHigh) { return null; }
            int inMid = map.get(preorder[preLow]);
            int leftLen = inMid - inLow;
            TreeNode root = new TreeNode(preorder[preLow]);
            root.left = build(preorder, preLow + 1, preLow + leftLen,
                inorder, inLow, inMid - 1);
            root.right = build(preorder, preLow + leftLen + 1, preHigh,
                inorder, inMid + 1, inHigh);
            return root;
        }

    }

}
