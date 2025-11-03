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
public class 从中序与后序遍历序列构造二叉树 {

    public static void main(String[] args) {

        Solution s = new Solution();

        TreeNode output1 = s.buildTree(new int[] { 9, 3, 15, 20, 7 }, new int[] { 9, 15, 7, 20, 3 });
        Assertions.assertEquals(TreeNode.buildTree(3, 9, 20, null, null, 15, 7), output1);

        TreeNode output2 = s.buildTree(new int[] { -1 }, new int[] { -1 });
        Assertions.assertEquals(TreeNode.buildTree(-1), output2);
    }

    static class Solution {

        Map<Integer, Integer> map = null;

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if (inorder == null || postorder == null) { return null; }
            map = new HashMap<>(inorder.length);
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return build(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
        }

        public TreeNode build(int[] inorder, int inLow, int inHigh,
            int[] postorder, int postLow, int postHigh) {
            if (postLow > postHigh) { return null; }
            int inMid = map.get(postorder[postHigh]);
            int leftLen = inMid - inLow;
            TreeNode root = new TreeNode(postorder[postHigh]);
            root.left = build(inorder, inLow, inMid - 1,
                postorder, postLow, postLow + leftLen - 1);
            root.right = build(inorder, inMid + 1, inHigh,
                postorder, postLow + leftLen, postHigh - 1);
            return root;
        }

    }

}
