package io.github.dunwu.leetcode.str;

//    【实现 strStr() 函数】
//
//    给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
//
//    示例 1:
//
//    输入: haystack = "hello", needle = "ll"
//    输出: 2
//    示例 2:
//
//    输入: haystack = "aaaaa", needle = "bba"
//    输出: -1
//    说明:
//
//    当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
//
//    对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。

/**
 * @author Zhang Peng
 * @since 2018-11-05
 */
public class ImplementStrstr {

    public static int strStr(String haystack, String needle) {
        if (haystack.equals(needle)) {
            return 0;
        }

        if (haystack == null || haystack.length() == 0) {
            return -1;
        }

        if (needle == null || needle.length() == 0) {
            return 0;
        }

        if (haystack.length() < needle.length()) {
            return -1;
        }

        int begin = 0;
        int i = 0;
        int j = 0;
        while (i < haystack.length() && begin < haystack.length()) {
            if (j == needle.length()) {
                return begin;
            } else if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = 0;
                begin++;
                i = begin;
            }
        }

        if (i == haystack.length() && j == needle.length()) {
            return begin;
        }
        return -1;
    }

}
