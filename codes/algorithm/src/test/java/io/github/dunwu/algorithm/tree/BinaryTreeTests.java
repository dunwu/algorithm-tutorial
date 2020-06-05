package io.github.dunwu.algorithm.tree;

import io.github.dunwu.algorithm.common.JavaCollectionTest;
import io.github.dunwu.algorithm.common.TreeTest;
import io.github.dunwu.algorithm.common.Utils;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinaryTreeTests {

    @Test
    public void testBTree() {
        Utils.TestData data = Utils.generateTestData(1000);

        String bstName = "B-Tree";
        BinaryTree<Integer> bst = new BinaryTree<Integer>(2);
        Collection<Integer> bstCollection = bst.toCollection();

        assertTrue(TreeTest.testTree(bst, Integer.class, bstName, data.unsorted, data.invalid));
        assertTrue(JavaCollectionTest.testCollection(bstCollection, Integer.class, bstName, data.unsorted, data.sorted,
            data.invalid));
    }

}
