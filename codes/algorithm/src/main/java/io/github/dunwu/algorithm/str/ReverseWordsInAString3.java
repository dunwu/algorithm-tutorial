package io.github.dunwu.algorithm.str;

//    【反转字符串中的单词 III】

//
//    给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
//
//    示例 1:
//
//    输入: "Let's take LeetCode contest"
//    输出: "s'teL ekat edoCteeL tsetnoc"
//    注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。

/**
 * @author Zhang Peng
 * @since 2018-11-05
 */
public class ReverseWordsInAString3 {

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] strs = s.split(" ");
        for (int index = 0; index < strs.length; index++) {
            int i = 0;
            int j = strs[index].length() - 1;

            char[] a = strs[index].toCharArray();
            while (i < j) {
                char t = a[i];
                a[i++] = a[j];
                a[j--] = t;
            }

            sb.append(a);
            if (index != strs.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

}
