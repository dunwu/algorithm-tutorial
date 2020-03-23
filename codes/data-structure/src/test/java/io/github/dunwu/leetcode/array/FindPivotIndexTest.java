package io.github.dunwu.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Zhang Peng
 * @since 2018-11-05
 */
public class FindPivotIndexTest {

    @Test
    public void test() {
        Assertions.assertEquals(3, FindPivotIndex.pivotIndex(new int[] { 1, 7, 3, 6, 5, 6 }));
        Assertions.assertEquals(-1, FindPivotIndex.pivotIndex(new int[] { 1, 2, 3 }));
    }

}
