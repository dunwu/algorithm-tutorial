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
public class 从前序与中序遍历序列构造二叉树 {

    public static void main(String[] args) {
        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };
        从前序与中序遍历序列构造二叉树 demo = new 从前序与中序遍历序列构造二叉树();
        TreeNode root = demo.buildTree(preorder, inorder);
        List<Integer> list = TreeUtils.toBfsValueList(root);
        System.out.println(list);
        Assertions.assertArrayEquals(Arrays.asList(3, 9, 20, null, null, 15, 7).toArray(), list.toArray());
    }

    // 中序遍历结构，key 是值，value 是索引
    private Map<Integer, Integer> map;

    public TreeNode backtrack(int[] preorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }

        // 前序遍历中的第一个节点就是根节点
        // 在中序遍历中定位根节点
        int inRoot = map.get(preorder[preLeft]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preLeft]);

        // 得到左子树中的节点数目
        int leftTreeSize = inRoot - inLeft;

        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 leftTreeSize」个元素就对应了
        // 中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = backtrack(preorder, preLeft + 1, preLeft + leftTreeSize, inLeft, inRoot - 1);

        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了
        // 中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = backtrack(preorder, preLeft + leftTreeSize + 1, preRight, inRoot + 1, inRight);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) { return null;}
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return backtrack(preorder, 0, n - 1, 0, n - 1);
    }

}
