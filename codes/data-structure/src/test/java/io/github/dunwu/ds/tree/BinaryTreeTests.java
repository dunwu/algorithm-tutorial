package io.github.dunwu.ds.tree;

import io.github.dunwu.ds.common.JavaCollectionTest;
import io.github.dunwu.ds.common.TreeTest;
import io.github.dunwu.ds.common.Utils;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertTrue;


public class BinaryTreeTests {

    @Test
    public void testBTree() {
        Utils.TestData data = Utils.generateTestData(1000);

        String bstName = "B-Tree";
        BinaryTree<Integer> bst = new BinaryTree<Integer>(2);
        Collection<Integer> bstCollection = bst.toCollection();

        assertTrue(TreeTest.testTree(bst, Integer.class, bstName, data.unsorted, data.invalid));
        assertTrue(JavaCollectionTest
            .testCollection(bstCollection, Integer.class, bstName, data.unsorted, data.sorted, data.invalid));
    }
}
