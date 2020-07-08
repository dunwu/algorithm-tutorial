package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import io.github.dunwu.algorithm.tree.TreeUtils;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-07-07
 */
public class 从中序与后序遍历序列构造二叉树 {

    public static void main(String[] args) {
        int[] postorder = { 9, 15, 7, 20, 3 };
        int[] inorder = { 9, 3, 15, 20, 7 };
        从中序与后序遍历序列构造二叉树 demo = new 从中序与后序遍历序列构造二叉树();
        TreeNode root = demo.buildTree(inorder, postorder);
        List<Integer> list = TreeUtils.toBfsValueList(root);
        System.out.println(list);
        Assertions.assertArrayEquals(Arrays.asList(3, 9, 20, null, null, 15, 7).toArray(), list.toArray());
    }

    private Map<Integer, Integer> map;

    public TreeNode backtrack(int[] postorder, int[] inorder, int postLeft, int postRight, int inLeft, int inRight) {
        if (postLeft > postRight) return null;

        // 后序遍历中的最后一个节点就是根节点
        // 在中序遍历中定位根节点
        int inRoot = map.get(postorder[postRight]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(postorder[postRight]);

        // 得到右子树中的节点数目
        int rightTreeSize = inRight - inRoot;

        // System.out.printf("左子树：postLeft = %s, postRight = %s, inLeft = %s, inRight = %s\n",
        //     postorder[postLeft], postorder[postRight - rightTreeSize - 1], inorder[inLeft], inorder[inRoot - 1]);
        // System.out.printf("右子树：postLeft = %s, postRight = %s, inLeft = %s, inRight = %s\n",
        //     postorder[postRight - rightTreeSize], postorder[postRight - 1], inorder[inRoot + 1], inorder[inRight]);

        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 leftTreeSize」个元素就对应了
        // 中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = backtrack(postorder, inorder, postLeft, postRight - rightTreeSize - 1, inLeft, inRoot - 1);

        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了
        // 中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = backtrack(postorder, inorder, postRight - rightTreeSize, postRight - 1, inRoot + 1, inRight);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null) { return null;}
        int n = inorder.length;
        map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return backtrack(postorder, inorder, 0, n - 1, 0, n - 1);
    }

}
