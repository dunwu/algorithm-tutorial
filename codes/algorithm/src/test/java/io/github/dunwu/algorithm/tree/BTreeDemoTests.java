package io.github.dunwu.algorithm.tree;

import io.github.dunwu.algorithm.tree.btree.BTreeDemo;
import org.junit.jupiter.api.Test;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-01-18
 */
public class BTreeDemoTests {

    public BTreeDemo.TreeNode initBTree() {
        BTreeDemo.TreeNode root = new BTreeDemo.TreeNode(3);
        root.left = new BTreeDemo.TreeNode(9);
        root.right = new BTreeDemo.TreeNode(20);
        root.left.left = null;
        root.left.right = null;
        root.right.left = new BTreeDemo.TreeNode(15);
        root.right.right = new BTreeDemo.TreeNode(17);
        return root;
    }

    @Test
    public void preOrderTest() {
        BTreeDemo.TreeNode root = new BTreeDemo.TreeNode(3);
        root.left = new BTreeDemo.TreeNode(9);
        root.right = new BTreeDemo.TreeNode(20);
        root.left.left = null;
        root.left.right = null;
        root.right.left = new BTreeDemo.TreeNode(15);
        root.right.right = new BTreeDemo.TreeNode(17);
        BTreeDemo.preOrder(root);
        System.out.println();
        BTreeDemo.preOrder2(root);
        System.out.println();
    }

    @Test
    public void inOrderTest() {
        BTreeDemo.TreeNode root = new BTreeDemo.TreeNode(3);
        root.left = new BTreeDemo.TreeNode(9);
        root.right = new BTreeDemo.TreeNode(20);
        root.left.left = null;
        root.left.right = null;
        root.right.left = new BTreeDemo.TreeNode(15);
        root.right.right = new BTreeDemo.TreeNode(17);
        BTreeDemo.inOrder(root);
        System.out.println();
        BTreeDemo.inOrder2(root);
        System.out.println();
    }

    @Test
    public void postOrderTest() {
        BTreeDemo.TreeNode root = initBTree();
        BTreeDemo.postOrder(root);
        System.out.println();
        BTreeDemo.postOrder2(root);
        System.out.println();
    }

    @Test
    public void levelTraverseTest() {
        BTreeDemo.TreeNode root = initBTree();
        BTreeDemo.levelTraverse(root);
        System.out.println();
    }

    @Test
    public void depthOrderTraverseTest() {
        BTreeDemo.TreeNode root = initBTree();
        BTreeDemo.depthOrderTraverse(root);
        System.out.println();
    }

    @Test
    public void sortedArrayToBST() {
        int[] nums = new int[] { -10, -3, 0, 5, 9 };
        BTreeDemo.TreeNode treeNode = BTreeDemo.sortedArrayToBST(nums);
    }

}
