package io.github.dunwu.algorithm.tree.btree.divide;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/delete-nodes-and-return-forest/">1110. 删点成林</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-18
 */
public class 删点成林 {

    public static void main(String[] args) {
        Solution s = new Solution();

        List<TreeNode> output = s.delNodes(TreeNode.buildTree(1, 2, 3, 4, 5, 6, 7), new int[] { 3, 5 });
        List<TreeNode> expect = new ArrayList<>();
        expect.add(TreeNode.buildTree(1, 2, null, 4));
        expect.add(TreeNode.buildTree(6));
        expect.add(TreeNode.buildTree(7));
        for (int i = 0; i < output.size(); i++) {
            Assertions.assertEquals(expect.get(i), output.get(i));
        }

        List<TreeNode> output2 = s.delNodes(TreeNode.buildTree(1, 2, 4, null, 3), new int[] { 3 });
        List<TreeNode> expect2 = new ArrayList<>();
        expect2.add(TreeNode.buildTree(1, 2, 4));
        for (int i = 0; i < output2.size(); i++) {
            Assertions.assertEquals(expect2.get(i), output2.get(i));
        }
    }

    static class Solution {

        Set<Integer> delSet;
        // 记录森林的根节点
        List<TreeNode> res;

        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            if (root == null) return new LinkedList<>();
            for (int d : to_delete) {
                delSet.add(d);
            }
            doDelete(root, false);
            return res;
        }

        // 定义：输入一棵二叉树，删除 delSet 中的节点，返回删除完成后的根节点
        private TreeNode doDelete(TreeNode root, boolean hasParent) {
            if (root == null) {
                return null;
            }
            // 判断是否需要被删除
            boolean deleted = delSet.contains(root.val);
            if (!deleted && !hasParent) {
                // 没有父节点且不需要被删除，就是一个新的根节点
                res.add(root);
            }
            // 去左右子树进行删除
            root.left = doDelete(root.left, !deleted);
            root.right = doDelete(root.right, !deleted);
            // 如果需要被删除，返回 null 给父节点
            return deleted ? null : root;
        }

    }

}
