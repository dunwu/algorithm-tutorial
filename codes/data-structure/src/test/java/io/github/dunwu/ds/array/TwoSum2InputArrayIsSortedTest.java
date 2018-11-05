package io.github.dunwu.ds.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Zhang Peng
 * @date 2018-11-05
 */
public class TwoSum2InputArrayIsSortedTest {
    @Test
    public void test() {
        Assert.assertArrayEquals(new int[] {1, 2}, TwoSum2InputArrayIsSorted.twoSum(new int[] {2, 7, 11, 15}, 9));
        Assert.assertArrayEquals(new int[] {1, 3}, TwoSum2InputArrayIsSorted.twoSum(new int[] {2, 3, 4}, 6));
        Assert.assertArrayEquals(new int[] {1, 2}, TwoSum2InputArrayIsSorted.twoSum(new int[] {0, 0, 3, 4}, 0));
    }
}
