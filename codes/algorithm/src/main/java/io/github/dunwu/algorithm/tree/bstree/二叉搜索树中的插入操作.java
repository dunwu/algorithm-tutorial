package io.github.dunwu.algorithm.tree.bstree;

import io.github.dunwu.algorithm.tree.TreeNode;
import io.github.dunwu.algorithm.tree.TreeUtils;

import java.util.List;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @see <a href="https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/">701. 二叉搜索树中的插入操作</a>
 * @since 2020-07-06
 */
public class 二叉搜索树中的插入操作 {

    public static void main(String[] args) {
        TreeNode tree = TreeUtils.asTree(4, 2, 7, 1, 3);
        insertIntoBST(tree, 5);
        List<TreeNode> treeNodes = TreeUtils.toBfsList(tree);
        System.out.println(treeNodes);
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        TreeNode node = root;
        if (val > node.val) {
            if (node.right == null) {
                node.right = new TreeNode(val);
            } else { insertIntoBST(node.right, val); }
        } else {
            if (node.left == null) {
                node.left = new TreeNode(val);
            } else { insertIntoBST(node.left, val); }
        }
        return root;
    }

}
