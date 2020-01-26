package io.github.dunwu.algorithm.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-01-18
 */
public class StringAlgorithmTest {

    @Test
    public void lengthOfLongestSubstring() {
        int len = StringAlgorithm.lengthOfLongestSubstring("abcabcbb");
        Assertions.assertEquals(3, len);

        len = StringAlgorithm.lengthOfLongestSubstring("bbbbb");
        Assertions.assertEquals(1, len);

        len = StringAlgorithm.lengthOfLongestSubstring("pwwkew");
        Assertions.assertEquals(3, len);
    }

    @Test
    public void longestCommonPrefix() {
        String str = StringAlgorithm.longestCommonPrefix(new String[] { "flower", "flow", "flight" });
        Assertions.assertEquals("fl", str);

        str = StringAlgorithm.longestCommonPrefix(new String[] { "dog", "racecar", "car" });
        Assertions.assertEquals("", str);
    }

    @Test
    public void checkInclusion() {
        boolean result = StringAlgorithm.checkInclusion("ab", "eidbaooo");
        Assertions.assertEquals(true, result);

        result = StringAlgorithm.checkInclusion("ab", "eidboaoo");
        Assertions.assertEquals(false, result);
    }

    @Test
    public void multiply() {
        String result = StringAlgorithm.multiply("2", "3");
        Assertions.assertEquals("6", result);

        result = StringAlgorithm.multiply("333", "2");
        Assertions.assertEquals("666", result);

        result = StringAlgorithm.multiply("123", "456");
        Assertions.assertEquals("56088", result);

        result = StringAlgorithm.multiply("123456789", "987654321");
        Assertions.assertEquals("121932631112635269", result);

        result = StringAlgorithm.multiply("498828660196", "840477629533");
        Assertions.assertEquals("419254329864656431168468", result);
    }

    @Test
    public void add() {
        String result = StringAlgorithm.add("100000000000000000000", "8888");
        Assertions.assertEquals("100000000000000008888", result);

        result = StringAlgorithm.add("1368", "9120");
        Assertions.assertEquals("10488", result);
    }

    @Test
    public void reverseWords() {
        String result = StringAlgorithm.reverseWords("the sky is blue");
        Assertions.assertEquals("blue is sky the", result);

        result = StringAlgorithm.reverseWords("  hello world!  ");
        Assertions.assertEquals("world! hello", result);

        result = StringAlgorithm.reverseWords("a good   example");
        Assertions.assertEquals("example good a", result);
    }

    @Test
    public void simplifyPath() {
        String result = StringAlgorithm.simplifyPath("/home/");
        Assertions.assertEquals("/home", result);

        result = StringAlgorithm.simplifyPath("/../");
        Assertions.assertEquals("/", result);

        result = StringAlgorithm.simplifyPath("/home//foo/");
        Assertions.assertEquals("/home/foo", result);

        result = StringAlgorithm.simplifyPath("/a/./b/../../c/");
        Assertions.assertEquals("/c", result);
    }

}
