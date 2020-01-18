package io.github.dunwu.ds.str;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Zhang Peng
 * @since 2018-11-05
 */
public class ReverseWordsInAString3Test {

    @Test
    public void test() {
        Assert.assertEquals("s'teL ekat edoCteeL tsetnoc",
            ReverseWordsInAString3.reverseWords("Let's take LeetCode contest"));
    }

}
