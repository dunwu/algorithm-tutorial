package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import io.github.dunwu.algorithm.tree.TreeUtils;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/">106.
 * 从中序与后序遍历序列构造二叉树</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-11
 */
public class 根据前序和后序遍历构造二叉树 {

    public static void main(String[] args) {
        TreeNode output1 = constructFromPrePost(new int[] { 1, 2, 4, 5, 3, 6, 7 }, new int[] { 4, 5, 2, 6, 7, 3, 1 });
        List<Integer> list = TreeUtils.toBfsValueList(output1);
        System.out.println(list);
        Assertions.assertArrayEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7).toArray(), list.toArray());
    }

    // 存储 postorder 中值到索引的映射
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            map.put(postorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1,
            postorder, 0, postorder.length - 1);
    }

    // 定义：根据 preorder[preBegin..preEnd] 和 postorder[postBegin..postEnd]
    // 构建二叉树，并返回根节点。
    static TreeNode build(int[] preorder, int preBegin, int preEnd,
        int[] postorder, int postBegin, int postEnd) {
        if (preBegin > preEnd) {
            return null;
        }
        if (preBegin == preEnd) {
            return new TreeNode(preorder[preBegin]);
        }

        // root 节点对应的值就是前序遍历数组的第一个元素
        int rootVal = preorder[preBegin];
        // root.left 的值是前序遍历第二个元素
        // 通过前序和后序遍历构造二叉树的关键在于通过左子树的根节点
        // 确定 preorder 和 postorder 中左右子树的元素区间
        int nextRootVal = preorder[preBegin + 1];
        // leftRootVal 在后序遍历数组中的索引
        int nextRootPos = map.get(nextRootVal);
        // 左子树的元素个数
        int leftSize = nextRootPos - postBegin + 1;

        // 先构造出当前根节点
        TreeNode root = new TreeNode(rootVal);

        // 递归构造左右子树
        // 根据左子树的根节点索引和元素个数推导左右子树的索引边界
        root.left = build(preorder, preBegin + 1, preBegin + leftSize,
            postorder, postBegin, nextRootPos);
        root.right = build(preorder, preBegin + leftSize + 1, preEnd,
            postorder, nextRootPos + 1, postEnd - 1);
        return root;
    }

}
