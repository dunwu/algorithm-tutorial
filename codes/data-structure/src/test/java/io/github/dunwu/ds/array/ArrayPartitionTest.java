package io.github.dunwu.ds.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Zhang Peng
 * @date 2018-11-05
 */
public class ArrayPartitionTest {

    @Test
    public void test() {
        int[] nums1 = {1, 4, 3, 2};
        Assert.assertEquals(4, ArrayPartition.arrayPairSum(nums1));
    }
}
