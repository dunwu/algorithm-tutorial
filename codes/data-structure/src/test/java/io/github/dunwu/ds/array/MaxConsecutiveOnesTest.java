package io.github.dunwu.ds.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Zhang Peng
 * @since 2018-11-05
 */
public class MaxConsecutiveOnesTest {

    @Test
    public void test() {
        Assert.assertEquals(3, MaxConsecutiveOnes.findMaxConsecutiveOnes(new int[] { 1, 1, 0, 1, 1, 1 }));
    }

}
