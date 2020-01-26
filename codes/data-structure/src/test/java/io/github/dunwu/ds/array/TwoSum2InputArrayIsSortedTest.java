package io.github.dunwu.ds.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Zhang Peng
 * @since 2018-11-05
 */
public class TwoSum2InputArrayIsSortedTest {

    @Test
    public void test() {
        Assertions.assertArrayEquals(new int[] { 1, 2 }, TwoSum2InputArrayIsSorted.twoSum(new int[] { 2, 7, 11, 15 }, 9));
        Assertions.assertArrayEquals(new int[] { 1, 3 }, TwoSum2InputArrayIsSorted.twoSum(new int[] { 2, 3, 4 }, 6));
        Assertions.assertArrayEquals(new int[] { 1, 2 }, TwoSum2InputArrayIsSorted.twoSum(new int[] { 0, 0, 3, 4 }, 0));
    }

}
