package io.github.dunwu.ds.str;

//    【反转字符串】
//
//    编写一个函数，其作用是将输入的字符串反转过来。
//
//    示例 1:
//
//    输入: "hello"
//    输出: "olleh"
//    示例 2:
//
//    输入: "A man, a plan, a canal: Panama"
//    输出: "amanaP :lanac a ,nalp a ,nam A"


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
