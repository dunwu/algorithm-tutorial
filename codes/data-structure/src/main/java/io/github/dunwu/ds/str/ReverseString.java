package io.github.dunwu.ds.str;

/**
 * @author Zhang Peng
 * @date 2018-11-05
 */
public class ReverseString {
    public static String reverseString(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
