package io.github.dunwu.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Zhang Peng
 * @since 2018-11-05
 */
public class RemoveDuplicatesFromSortedArrayTest {

    @Test
    public void test() {
        int[] nums1 = { 1, 1, 2 };
        Assertions.assertEquals(2, RemoveDuplicatesFromSortedArray.removeDuplicates(nums1));

        int[] nums2 = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        Assertions.assertEquals(5, RemoveDuplicatesFromSortedArray.removeDuplicates(nums2));

        int[] nums3 = { 1, 2 };
        Assertions.assertEquals(2, RemoveDuplicatesFromSortedArray.removeDuplicates(nums3));

        int[] nums4 = { 2, 2 };
        Assertions.assertEquals(1, RemoveDuplicatesFromSortedArray.removeDuplicates(nums4));
    }

}
