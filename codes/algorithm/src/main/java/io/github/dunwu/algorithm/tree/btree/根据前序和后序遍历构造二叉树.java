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
public class 根据前序和后序遍历构造二叉树 {

    public static void main(String[] args) {
        TreeNode output1 = new Solution().constructFromPrePost(new int[] { 1, 2, 4, 5, 3, 6, 7 },
            new int[] { 4, 5, 2, 6, 7, 3, 1 });
        List<Integer> list = TreeUtils.toValueList(output1);
        // System.out.println(list);
        Assertions.assertArrayEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7).toArray(), list.toArray());
    }

    static class Solution {

        Map<Integer, Integer> postPosMap = new HashMap<>();

        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            if (preorder.length == 0 || postorder.length == 0) { return null; }
            for (int i = 0; i < postorder.length; i++) {
                postPosMap.put(postorder[i], i);
            }
            return build(preorder, 0, preorder.length - 1,
                postorder, 0, postorder.length - 1);
        }

        public TreeNode build(int[] preorder, int preBegin, int preEnd,
            int[] postorder, int postBegin, int postEnd) {
            if (preBegin > preEnd) { return null; }
            if (preBegin == preEnd) { return new TreeNode(preorder[preBegin]); }
            int rootVal = preorder[preBegin];
            int nextRootVal = preorder[preBegin + 1];
            int nextRootPos = postPosMap.get(nextRootVal);
            int leftSize = nextRootPos - postBegin + 1;
            TreeNode root = new TreeNode(rootVal);
            root.left = build(preorder, preBegin + 1, preBegin + leftSize,
                postorder, postBegin, nextRootPos);
            root.right = build(preorder, preBegin + leftSize + 1, preEnd,
                postorder, nextRootPos + 1, postEnd - 1);
            return root;
        }

    }

}
