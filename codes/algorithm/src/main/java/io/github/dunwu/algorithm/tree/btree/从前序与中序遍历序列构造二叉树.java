package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import io.github.dunwu.algorithm.tree.TreeUtils;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">105. 从前序与中序遍历序列构造二叉树</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-11
 */
public class 从前序与中序遍历序列构造二叉树 {

    public static void main(String[] args) {
        TreeNode output1 = buildTree(new int[] { 3, 9, 20, 15, 7 }, new int[] { 9, 3, 15, 20, 7 });
        List<Integer> list = TreeUtils.toBfsValueList(output1);
        System.out.println(list);
        Assertions.assertArrayEquals(Arrays.asList(3, 9, 20, null, null, 15, 7).toArray(), list.toArray());

        TreeNode output2 = buildTree(new int[] { -1 }, new int[] { -1 });
        List<Integer> list2 = TreeUtils.toBfsValueList(output2);
        System.out.println(list2);
        Assertions.assertArrayEquals(Arrays.asList(-1).toArray(), list2.toArray());
    }

    // 存储 inorder 中值到索引的映射
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null
            || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public static TreeNode build(int[] preorder, int preBegin, int preEnd,
        int[] inorder, int inBegin, int inEnd) {
        if (preBegin > preEnd || inBegin > inEnd) {
            return null;
        }
        int rootVal = preorder[preBegin];
        int rootInIndex = map.get(rootVal);
        int inLeftLen = rootInIndex - inBegin;
        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder, preBegin + 1, preBegin + inLeftLen,
            inorder, inBegin, rootInIndex - 1);
        root.right = build(preorder, preBegin + inLeftLen + 1, preEnd,
            inorder, rootInIndex + 1, inEnd);
        return root;
    }

}
