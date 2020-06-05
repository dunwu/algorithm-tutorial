package io.github.dunwu.algorithm.str;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Zhang Peng
 * @since 2018-11-05
 */
public class AddBinaryTest {

    @Test
    public void test() {
        Assertions.assertEquals("100", AddBinary.addBinary("11", "1"));
        Assertions.assertEquals("10101", AddBinary.addBinary("1010", "1011"));
    }

}
