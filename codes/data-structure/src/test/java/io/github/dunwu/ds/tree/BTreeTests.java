package io.github.dunwu.ds.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-01-28
 */
public class BTreeTests {

    @Test
    public void maxDepthTest() {
        BTree<Integer> tree = BTree.buildTree(1, 2, 3, 4, 5);
        Assertions.assertEquals(3, tree.maxDepth());
    }

    @Test
    public void isEqualsTest() {
        BTree<Integer> tree1 = BTree.buildTree(1, 2, 3);
        BTree<Integer> tree2 = BTree.buildTree(1, 2, 3);
        Assertions.assertTrue(BTree.isEquals(tree1, tree2));

        tree1 = BTree.buildTree(1, 2, 1);
        tree2 = BTree.buildTree(1, 1, 2);
        Assertions.assertFalse(BTree.isEquals(tree1, tree2));
    }

    @Test
    public void levelOrderBottomTest() {
        BTree<Integer> tree = BTree.buildTree(3, 9, 20, null, null, 15, 7);
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(3));
        lists.add(Arrays.asList(9, 20));
        lists.add(Arrays.asList(15, 7));
        Assertions.assertIterableEquals(lists, tree.levelOrderList());
    }

}
