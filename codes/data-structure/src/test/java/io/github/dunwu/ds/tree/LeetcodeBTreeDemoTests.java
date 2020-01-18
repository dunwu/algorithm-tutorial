package io.github.dunwu.ds.tree;

import org.junit.Test;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-01-18
 */
public class LeetcodeBTreeDemoTests {

    @Test
    public void test() {

        // root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
        LeetcodeBTreeDemo.TreeNode root = new LeetcodeBTreeDemo.TreeNode(-1);
        root.left = new LeetcodeBTreeDemo.TreeNode(5);
        root.right = new LeetcodeBTreeDemo.TreeNode(1);
        root.left.left = new LeetcodeBTreeDemo.TreeNode(6);
        root.left.right = new LeetcodeBTreeDemo.TreeNode(2);
        root.right.left = new LeetcodeBTreeDemo.TreeNode(0);
        root.right.right = new LeetcodeBTreeDemo.TreeNode(8);
        root.left.left.left = null;
        root.left.left.right = null;
        root.left.right.left = new LeetcodeBTreeDemo.TreeNode(7);
        root.left.right.right = new LeetcodeBTreeDemo.TreeNode(4);

        LeetcodeBTreeDemo.TreeNode p = new LeetcodeBTreeDemo.TreeNode(5);
        LeetcodeBTreeDemo.TreeNode q = new LeetcodeBTreeDemo.TreeNode(1);
        LeetcodeBTreeDemo.TreeNode treeNode = LeetcodeBTreeDemo.lowestCommonAncestor(root, p, q);
    }

}
