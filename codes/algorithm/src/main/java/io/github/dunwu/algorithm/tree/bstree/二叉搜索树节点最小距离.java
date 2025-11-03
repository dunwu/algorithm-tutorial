package io.github.dunwu.algorithm.tree.bstree;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes">二叉搜索树结点最小距离</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2020-06-18
 */
public class 二叉搜索树节点最小距离 {

    public static void main(String[] args) {

        Solution s = new Solution();

        TreeNode tree = TreeNode.buildTree(4, 2, 6, 1, 3);
        Assertions.assertEquals(1, s.minDiffInBST(tree));
    }

    static class Solution {

        int pre = -1;
        int min = Integer.MAX_VALUE;

        public int minDiffInBST(TreeNode root) {
            pre = -1;
            min = Integer.MAX_VALUE;
            dfs(root);
            return min;
        }

        public void dfs(TreeNode root) {
            if (root == null) return;
            dfs(root.left);
            if (pre == -1) {
                pre = root.val;
            } else {
                min = Math.min(min, Math.abs(pre - root.val));
                pre = root.val;
            }
            dfs(root.right);
        }

    }

}
