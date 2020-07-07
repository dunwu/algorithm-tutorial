package io.github.dunwu.algorithm.tree;

import org.junit.jupiter.api.Test;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-01-18
 */
public class BTreeDemoTests {

    public IntBTree.TreeNode initBTree() {
        IntBTree.TreeNode root = new IntBTree.TreeNode(3);
        root.left = new IntBTree.TreeNode(9);
        root.right = new IntBTree.TreeNode(20);
        root.left.left = null;
        root.left.right = null;
        root.right.left = new IntBTree.TreeNode(15);
        root.right.right = new IntBTree.TreeNode(17);
        return root;
    }

    @Test
    public void preOrderTest() {
        IntBTree.TreeNode root = new IntBTree.TreeNode(3);
        root.left = new IntBTree.TreeNode(9);
        root.right = new IntBTree.TreeNode(20);
        root.left.left = null;
        root.left.right = null;
        root.right.left = new IntBTree.TreeNode(15);
        root.right.right = new IntBTree.TreeNode(17);
        IntBTree.preOrder(root);
        System.out.println();
        IntBTree.preOrder2(root);
        System.out.println();
    }

    @Test
    public void inOrderTest() {
        IntBTree.TreeNode root = new IntBTree.TreeNode(3);
        root.left = new IntBTree.TreeNode(9);
        root.right = new IntBTree.TreeNode(20);
        root.left.left = null;
        root.left.right = null;
        root.right.left = new IntBTree.TreeNode(15);
        root.right.right = new IntBTree.TreeNode(17);
        IntBTree.inOrder(root);
        System.out.println();
        IntBTree.inOrder2(root);
        System.out.println();
    }

    @Test
    public void postOrderTest() {
        IntBTree.TreeNode root = initBTree();
        IntBTree.postOrder(root);
        System.out.println();
        IntBTree.postOrder2(root);
        System.out.println();
    }

    @Test
    public void levelTraverseTest() {
        IntBTree.TreeNode root = initBTree();
        IntBTree.levelTraverse(root);
        System.out.println();
    }

    @Test
    public void depthOrderTraverseTest() {
        IntBTree.TreeNode root = initBTree();
        IntBTree.depthOrderTraverse(root);
        System.out.println();
    }

}
