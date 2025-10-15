import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/longest-common-prefix/">14. 最长公共前缀</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2025-08-06
 */
public class 最长公共前缀 {

    public static void main(String[] args) {
        String[] input1 = { "flower", "flow", "flight" };
        String expect1 = "fl";
        String output1 = longestCommonPrefix(input1);
        Assertions.assertEquals(expect1, output1);

        String[] input2 = { "dog", "racecar", "car" };
        String expect2 = "";
        String output2 = longestCommonPrefix(input2);
        Assertions.assertEquals(expect2, output2);
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int p = 0;
        int len = strs.length;
        while (true) {
            if (strs[0].length() <= p) {
                break;
            }
            char c = strs[0].charAt(p);
            int i = 1;
            while (i < len && p < strs[i].length() && strs[i].charAt(p) == c) {
                i++;
            }
            if (i < len) {
                break;
            }
            p++;
        }
        return strs[0].substring(0, p);
    }

}
