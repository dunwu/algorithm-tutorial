package io.github.dunwu.algorithm.str;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Zhang Peng
 * @since 2018-11-05
 */
public class ReverseStringTest {

    @Test
    public void test() {
        Assertions.assertEquals("olleh", ReverseString.reverseString("hello"));
        Assertions.assertEquals("amanaP :lanac a ,nalp a ,nam A",
            ReverseString.reverseString("A man, a plan, a canal: Panama"));
    }

}
