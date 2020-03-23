package io.github.dunwu.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Zhang Peng
 * @since 2018-11-05
 */
public class ArrayPartitionTest {

    @Test
    public void test() {
        int[] nums1 = { 1, 4, 3, 2 };
        Assertions.assertEquals(4, ArrayPartition.arrayPairSum(nums1));
    }

}
