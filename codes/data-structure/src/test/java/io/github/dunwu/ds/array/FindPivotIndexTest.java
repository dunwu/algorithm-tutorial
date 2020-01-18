package io.github.dunwu.ds.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Zhang Peng
 * @since 2018-11-05
 */
public class FindPivotIndexTest {

    @Test
    public void test() {
        Assert.assertEquals(3, FindPivotIndex.pivotIndex(new int[] { 1, 7, 3, 6, 5, 6 }));
        Assert.assertEquals(-1, FindPivotIndex.pivotIndex(new int[] { 1, 2, 3 }));
    }

}
