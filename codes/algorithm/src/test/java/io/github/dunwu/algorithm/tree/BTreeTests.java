package io.github.dunwu.algorithm.tree;

import io.github.dunwu.algorithm.tree.btree.BTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-01-28
 */
public class BTreeTests {

    @Test
    @DisplayName("二叉树的最大深度")
    public void maxDepthTest() {
        BTree<Integer> tree = BTree.buildTree(1, 2, 3, 4, 5);
        Assertions.assertEquals(3, tree.maxDepth());
    }

    @Test
    @DisplayName("二叉树的最小深度")
    public void minDepthTest() {
        BTree<Integer> tree = BTree.buildTree(3, 9, 20, null, null, 15, 7);
        Assertions.assertEquals(2, tree.minDepth());

        tree = BTree.buildTree(1, 2);
        Assertions.assertEquals(2, tree.minDepth());
    }

    @Test
    @DisplayName("判断两颗二叉树是否完全一致")
    public void isEqualsTest() {
        BTree<Integer> tree1 = BTree.buildTree(1, 2, 3);
        BTree<Integer> tree2 = BTree.buildTree(1, 2, 3);
        Assertions.assertTrue(BTree.isEquals(tree1, tree2));

        tree1 = BTree.buildTree(1, 2, 1);
        tree2 = BTree.buildTree(1, 1, 2);
        Assertions.assertFalse(BTree.isEquals(tree1, tree2));
    }

    @Test
    @DisplayName("广度优先搜索（BFS）")
    public void levelOrderBottomTest() {
        BTree<Integer> tree = BTree.buildTree(3, 9, 20, null, null, 15, 7);
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Collections.singletonList(3));
        lists.add(Arrays.asList(9, 20));
        lists.add(Arrays.asList(15, 7));
        Assertions.assertIterableEquals(lists, tree.levelOrderLists());
    }

    @Test
    @DisplayName("判断两颗二叉树的叶子节点是否相似")
    public void isLeafSimilarTest() {
        BTree<Integer> tree1 = BTree.buildTree(3, 5, 1, 6, 2, 9, 8, null, null, 7, 4);
        BTree<Integer> tree2 = BTree.buildTree(3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8);
        Assertions.assertTrue(BTree.isLeafSimilar(tree1, tree2));
    }

}
