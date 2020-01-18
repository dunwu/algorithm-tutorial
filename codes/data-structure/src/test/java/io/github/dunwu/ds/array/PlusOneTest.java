package io.github.dunwu.ds.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Zhang Peng
 * @since 2018-11-05
 */
public class PlusOneTest {

    @Test
    public void test() {
        int[] nums1 = { 1, 2, 3 };
        int[] nums2 = { 4, 3, 2, 1 };
        int[] nums3 = { 9, 9, 9, 9 };

        int[] expected1 = { 1, 2, 4 };
        int[] expected2 = { 4, 3, 2, 2 };
        int[] expected3 = { 1, 0, 0, 0, 0 };

        Assert.assertArrayEquals(expected1, PlusOne.plusOne(nums1));
        Assert.assertArrayEquals(expected2, PlusOne.plusOne(nums2));
        Assert.assertArrayEquals(expected3, PlusOne.plusOne(nums3));
    }

}
