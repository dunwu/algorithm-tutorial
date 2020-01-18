package io.github.dunwu.ds.str;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Zhang Peng
 * @since 2018-11-05
 */
public class AddBinaryTest {

    @Test
    public void test() {
        Assert.assertEquals("100", AddBinary.addBinary("11", "1"));
        Assert.assertEquals("10101", AddBinary.addBinary("1010", "1011"));
    }

}
