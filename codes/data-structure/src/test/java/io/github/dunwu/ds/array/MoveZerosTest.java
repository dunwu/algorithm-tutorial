package io.github.dunwu.ds.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Zhang Peng
 * @date 2018-11-05
 */
public class MoveZerosTest {
    @Test
    public void test() {
        int[] nums1 = {0, 1, 0, 3, 12};
        MoveZeros.moveZeroes(nums1);
        Assert.assertArrayEquals(new int[] {1, 3, 12, 0, 0}, nums1);

        int[] nums2 = {0, 0, 1};
        MoveZeros.moveZeroes(nums2);
        Assert.assertArrayEquals(new int[] {1, 0, 0}, nums2);
    }
}
