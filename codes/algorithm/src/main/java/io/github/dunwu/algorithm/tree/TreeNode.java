package io.github.dunwu.algorithm.tree;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-01-28
 */
public class TreeNode {

    int val;

    TreeNode left;

    TreeNode right;

    public TreeNode(int val) { this.val = val; }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
            "val=" + val +
            '}';
    }

}
