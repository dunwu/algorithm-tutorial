package io.github.dunwu.ds.str;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Zhang Peng
 * @since 2018-11-05
 */
public class ReverseWordsInAString3Test {

    @Test
    public void test() {
        Assertions.assertEquals("s'teL ekat edoCteeL tsetnoc",
            ReverseWordsInAString3.reverseWords("Let's take LeetCode contest"));
    }

}
