package io.github.dunwu.ds.str;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Zhang Peng
 * @date 2018-11-05
 */
public class ReverseStringTest {
    @Test
    public void test() {
        Assert.assertEquals("olleh", ReverseString.reverseString("hello"));
        Assert.assertEquals("amanaP :lanac a ,nalp a ,nam A",
            ReverseString.reverseString("A man, a plan, a canal: Panama"));
    }
}
