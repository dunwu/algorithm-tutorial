package io.github.dunwu.algorithm.str;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Zhang Peng
 * @since 2018-11-05
 */
public class ReverseWordsInAStringTest {

    @Test
    public void test() {
        Assertions.assertEquals("blue is sky the", ReverseWordsInAString.reverseWords("the sky is blue"));
        Assertions.assertEquals("  ", ReverseWordsInAString.reverseWords("  "));
        Assertions.assertEquals("1", ReverseWordsInAString.reverseWords("1 "));
    }

}
