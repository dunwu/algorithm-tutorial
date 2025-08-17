package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import io.github.dunwu.algorithm.tree.TreeUtils;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
        List<Integer> list = TreeUtils.toValueList(output1);
        System.out.println(list);
        Assertions.assertArrayEquals(Arrays.asList(3, 9, 20, null, null, 15, 7).toArray(), list.toArray());
    }

    static class Solution {

        Map<Integer, Integer> map = new HashMap<>();

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if (inorder == null || postorder == null) { return null; }
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return build(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
        }

        public TreeNode build(int[] inorder, int inBegin, int inEnd,
            int[] postorder, int postBegin, int postEnd) {
            if (postBegin > postEnd) { return null; }
            int rootVal = postorder[postEnd];
            int rootPos = map.get(rootVal);
            int leftSize = rootPos - inBegin;
            TreeNode root = new TreeNode(rootVal);
            root.left = build(inorder, inBegin, rootPos - 1,
                postorder, postBegin, postBegin + leftSize - 1);
            root.right = build(inorder, rootPos + 1, inEnd,
                postorder, postBegin + leftSize, postEnd - 1);
            return root;
        }

    }

}
