package io.github.dunwu.leetcode.str;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-05-12
 */
public class StringAlgorithm {

    /**
     * @see <a href="https://leetcode-cn.com/problems/is-unique-lcci/">01. 判定字符是否唯一</a>
     */
    public static boolean isUnique(String str) {
        if (str == null || str.length() <= 1) { return true; }
        Set<Character> set = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }

    /**
     * @see <a href="https://leetcode-cn.com/problems/check-permutation-lcci/">02. 判定是否互为字符重排</a>
     */
    public static boolean checkPermutation(String s1, String s2) {
        if (!(s1 != null && s2 != null)) {
            return false;
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        Map<Character, Integer> countMap1 = new HashMap<>();
        Map<Character, Integer> countMap2 = new HashMap<>();
        for (char c : s1.toCharArray()) {
            if (countMap1.containsKey(c)) {
                Integer cnt = countMap1.get(c);
                cnt++;
            } else {
                countMap1.put(c, 1);
            }
        }
        for (char c : s2.toCharArray()) {
            if (countMap2.containsKey(c)) {
                Integer cnt = countMap2.get(c);
                cnt++;
            } else {
                countMap2.put(c, 1);
            }
        }

        Set<Character> keySet1 = countMap1.keySet();
        Set<Character> keySet2 = countMap2.keySet();
        if (keySet1.size() != keySet2.size()) {
            return false;
        }

        for (Character key : keySet1) {
            if (!countMap2.containsKey(key)) {
                return false;
            }

            if (countMap2.get(key).intValue() != countMap1.get(key).intValue()) {
                return false;
            }
        }
        return true;
    }

    /**
     * @see <a href="https://leetcode-cn.com/problems/string-to-url-lcci/">03. URL化</a>
     */
    public static String replaceSpaces(String str, int length) {
        int realLength = str.length();
        int min = Math.min(length, realLength);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < min; i++) {
            char c = str.charAt(i);
            if (str.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * @see <a href="https://leetcode-cn.com/problems/palindrome-permutation-lcci/">04. 回文排列</a>
     */
    public static boolean canPermutePalindrome(String s) {
        int length = s.length();
        boolean isEven = (length % 2) == 0;
        Map<Character, Integer> map = new HashMap<>(length);
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                Integer cnt = map.get(c);
                cnt++;
                map.put(c, cnt);
            } else {
                map.put(c, 1);
            }
        }

        int oddCount = 0;
        for (char c : map.keySet()) {
            int count = map.get(c);

            if (isEven && (count % 2) != 0) { return false; }
            if (!isEven && (count % 2) != 0) {
                if (oddCount > 1) {
                    return false;
                }
                oddCount++;
            }
        }
        return true;
    }

    /**
     * @see <a href="https://leetcode-cn.com/problems/palindrome-permutation-lcci/">05. 一次编辑</a>
     */
    public static boolean oneEditAway(String first, String second) {
        if (first == null || second == null) {
            return false;
        }
        int len1 = first.length();
        int len2 = second.length();
        if (Math.abs(len1 - len2) > 1) {
            return false;
        }
        if (len2 > len1) { return oneEditAway(second, first); }

        for (int i = 0; i < len2; i++) {
            if (first.charAt(i) != second.charAt(i)) {
                return first.substring(i + 1).equals(second.substring(len1 == len2 ? i + 1 : i));
            }
        }
        return true;
    }

    /**
     * @see <a href="https://leetcode-cn.com/problems/compress-string-lcci/">06. 字符串压缩</a>
     */
    public static String compressString(String str) {
        if (str == null) { return null; }

        int originLen = str.length();
        if (str.length() <= 1) {
            return str;
        }

        int cnt = 0;
        char mark = str.charAt(0);
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (mark == c) {
                cnt++;
            } else {
                sb.append(mark).append(cnt);
                // 设置新字符
                mark = c;
                cnt = 1;
            }
        }
        sb.append(mark).append(cnt);

        String newStr = sb.toString();
        if (newStr.length() >= originLen) {
            return str;
        } else {
            return newStr;
        }
    }

    /**
     * @see <a href="https://leetcode-cn.com/problems/string-rotation-lcci/">09. 字符串轮转</a>
     */
    public static boolean isFlipedString(String s1, String s2) {
        if (s1 == null || s2 == null) { return false; }

        int len1 = s1.length(), len2 = s2.length();
        if (len1 != len2) {
            return false;
        }

        if (s1.equals(s2)) {
            return true;
        }

        if (len1 == 1) {
            return false;
        }

        int begin = s1.indexOf(s2.charAt(0)) - 1;
        for (int i = begin; i < len2 - 1; i++) {
            String temp = leftMove(s1, i + 1);
            if (s2.equals(temp)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 字符串整体向左偏移
     */
    private static String leftMove(String str, int pos) {
        if (str == null || str.length() <= 1 || pos <= 0) {
            return str;
        }

        String temp = str.substring(pos);
        temp = temp + str.substring(0, pos);
        return temp;
    }

}
