package io.github.dunwu.algorithm.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-03-11
 */
public class ArrayAlgorithmTest {

    @Test
    public void containsDuplicateTest() {
        Assertions.assertTrue(ArrayAlgorithm.containsDuplicate(new int[] { 1, 2, 3, 1 }));
        Assertions.assertFalse(ArrayAlgorithm.containsDuplicate(new int[] { 1, 2, 3, 4 }));
        Assertions.assertTrue(ArrayAlgorithm.containsDuplicate(new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 }));
    }

    @Test
    public void countTest() {
        Assertions.assertEquals(2, ArrayAlgorithm.count(new int[] { 5, 7, 7, 8, 8, 10 }, 8));
        Assertions.assertEquals(0, ArrayAlgorithm.count(new int[] { 5, 7, 7, 8, 8, 10 }, 6));
    }

    @Test
    public void searchRangeTest() {
        Assertions.assertArrayEquals(new int[] { 3, 4 },
            ArrayAlgorithm.searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8));
        Assertions.assertArrayEquals(new int[] { -1, -1 },
            ArrayAlgorithm.searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 6));
    }

    @Test
    public void binarySearchTest() {
        Assertions.assertEquals(5, ArrayAlgorithm.binarySearch(new int[] { 5, 7, 7, 8, 8, 10 }, 10));
        Assertions.assertEquals(0, ArrayAlgorithm.binarySearch(new int[] { 5, 7, 7, 8, 8, 10 }, 5));
        Assertions.assertEquals(2, ArrayAlgorithm.binarySearch(new int[] { 5, 7, 7, 8, 8, 10 }, 7));
    }

    @Test
    public void searchLeftTest() {
        Assertions.assertEquals(-1, ArrayAlgorithm.searchLeft(new int[] { 5, 7, 7, 8, 8, 10 }, 3));
        Assertions.assertEquals(0, ArrayAlgorithm.searchLeft(new int[] { 5, 7, 7, 8, 8, 10 }, 5));
        Assertions.assertEquals(5, ArrayAlgorithm.searchLeft(new int[] { 5, 7, 7, 8, 8, 10 }, 10));
        Assertions.assertEquals(-1, ArrayAlgorithm.searchLeft(new int[] { 5, 7, 7, 8, 8, 10 }, 12));
        Assertions.assertEquals(1, ArrayAlgorithm.searchLeft(new int[] { 5, 7, 7, 8, 8, 10 }, 7));
    }

    @Test
    public void searchRightTest() {
        Assertions.assertEquals(-1, ArrayAlgorithm.searchRight(new int[] { 5, 7, 7, 8, 8, 10 }, 3));
        Assertions.assertEquals(0, ArrayAlgorithm.searchRight(new int[] { 5, 7, 7, 8, 8, 10 }, 5));
        Assertions.assertEquals(5, ArrayAlgorithm.searchRight(new int[] { 5, 7, 7, 8, 8, 10 }, 10));
        Assertions.assertEquals(-1, ArrayAlgorithm.searchRight(new int[] { 5, 7, 7, 8, 8, 10 }, 12));
        Assertions.assertEquals(2, ArrayAlgorithm.searchRight(new int[] { 5, 7, 7, 8, 8, 10 }, 7));
    }

    @Test
    public void twoSumTest() {
        Assertions.assertArrayEquals(new int[] { 0, 1 },
            ArrayAlgorithm.twoSum_method1(new int[] { 2, 7, 11, 15 }, 9));
        Assertions.assertArrayEquals(new int[] { 1, 2 },
            ArrayAlgorithm.twoSum_method1(new int[] { 3, 2, 4 }, 6));
        Assertions.assertArrayEquals(new int[] { -1, -1 },
            ArrayAlgorithm.twoSum_method1(new int[] { 3, 2, 4 }, 9));

        Assertions.assertArrayEquals(new int[] { 0, 1 },
            ArrayAlgorithm.twoSum_method2(new int[] { 2, 7, 11, 15 }, 9));
        Assertions.assertArrayEquals(new int[] { 1, 2 },
            ArrayAlgorithm.twoSum_method2(new int[] { 3, 2, 4 }, 6));
        Assertions.assertArrayEquals(new int[] { -1, -1 },
            ArrayAlgorithm.twoSum_method2(new int[] { 3, 2, 4 }, 9));
    }

    @Test
    public void twoSumInSortedTest() {
        Assertions.assertArrayEquals(new int[] { 1, 2 }, ArrayAlgorithm.twoSumInSorted(new int[] { 2, 7, 11, 15 }, 9));
        Assertions.assertArrayEquals(new int[] { 1, 3 }, ArrayAlgorithm.twoSumInSorted(new int[] { 2, 3, 4 }, 6));
        Assertions.assertArrayEquals(new int[] { 1, 2 }, ArrayAlgorithm.twoSumInSorted(new int[] { 0, 0, 3, 4 }, 0));
    }

    @Test
    public void canThreePartsEqualSumTest() {
        Assertions.assertTrue(ArrayAlgorithm.canThreePartsEqualSum(new int[] { 0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1 }));
        Assertions.assertTrue(ArrayAlgorithm.canThreePartsEqualSum(new int[] { 3, 3, 6, 5, -2, 2, 5, 1, -9, 4 }));
        Assertions.assertFalse(ArrayAlgorithm.canThreePartsEqualSum(new int[] { 0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1 }));
    }

    @Test
    public void rotateTest() {
        int[][] array = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
        };
        int[][] array2 = {
            { 7, 4, 1 },
            { 8, 5, 2 },
            { 9, 6, 3 }
        };
        ArrayAlgorithm.rotate(array);
        Assertions.assertArrayEquals(array2, array);
    }

    @Test
    public void setZeroesTest() {
        int[][] array = {
            { 1, 1, 1 },
            { 1, 0, 1 },
            { 1, 1, 1 }
        };
        int[][] array2 = {
            { 1, 0, 1 },
            { 0, 0, 0 },
            { 1, 0, 1 }
        };
        ArrayAlgorithm.setZeroes(array);
        // ArrayAlgorithm.setZeroForElement(array, 1, 1);
        Assertions.assertArrayEquals(array2, array);
    }

}
