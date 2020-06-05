package io.github.dunwu.algorithm.str;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Zhang Peng
 * @since 2018-11-05
 */
public class ImplementStrstrTest {

    @Test
    public void test() {
        Assertions.assertEquals(0, ImplementStrstr.strStr("", ""));
        Assertions.assertEquals(-1, ImplementStrstr.strStr("aaa", "aaaa"));
        Assertions.assertEquals(0, ImplementStrstr.strStr("aaa", ""));
        Assertions.assertEquals(2, ImplementStrstr.strStr("hello", "ll"));
        Assertions.assertEquals(-1, ImplementStrstr.strStr("aaaaa", "bba"));
        Assertions.assertEquals(1, ImplementStrstr.strStr("mississippi", "issi"));
        Assertions.assertEquals(9, ImplementStrstr.strStr("mississippi", "pi"));
    }

}
