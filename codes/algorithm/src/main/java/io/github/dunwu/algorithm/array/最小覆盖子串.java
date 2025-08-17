package io.github.dunwu.algorithm.array;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;

/**
 * <a href="https://leetcode.cn/problems/minimum-window-substring/">76. 最小覆盖子串</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-01-10
 */
@Slf4j
public class 最小覆盖子串 {

    public static void main(String[] args) {
        Assertions.assertEquals("BANC", minWindow("ADOBECODEBANC", "ABC"));
        Assertions.assertEquals("a", minWindow("a", "a"));
        Assertions.assertEquals("", minWindow("a", "aa"));
    }

    public static String minWindow(String s, String t) {
        // 用合适的数据结构记录窗口中的数据，根据具体场景变通
        // 比如说，我想记录窗口中元素出现的次数，就用 map
        // 如果我想记录窗口中的元素和，就可以只用一个 int

        // 记录 window 中的字符出现次数
        HashMap<Character, Integer> window = new HashMap<>();
        // 记录所需的字符出现次数
        HashMap<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int valid = 0;
        int left = 0, right = 0;
        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            // 增大窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // *** debug 输出的位置 ***
            // 注意在最终的解法代码中不要 print
            // 因为 IO 操作很耗时，可能导致超时
            log.info("window: [{}, {})", left, right);

            // 判断左侧窗口是否要收缩
            while (left < right && valid == need.size()) {
                // 在这里更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 缩小窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

}
