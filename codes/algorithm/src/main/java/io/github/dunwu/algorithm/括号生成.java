package io.github.dunwu.algorithm;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-07-03
 */
public class 括号生成 {

    public static void main(String[] args) {
        List<String> list1 = Collections.singletonList("()");
        List<String> list2 = new ArrayList<>();
        list2.add("(())");
        list2.add("()()");
        Assertions.assertArrayEquals(list1.toArray(), generateParenthesis(1).toArray());
        Assertions.assertArrayEquals(list2.toArray(), generateParenthesis(2).toArray());
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generateOneByOne(list, 0, 0, n, "");
        return list;
    }

    private static void generateOneByOne(List<String> list, int left, int right, int n, String str) {
        // 因为括号必然成对出现，所以左括号数和右括号都等于 N，即符合条件
        if (left == n && right == n) {
            list.add(str);
            return;
        }
        // 左括号数小于 N，就累加，将其 ( 加入字符串
        if (left < n) generateOneByOne(list, left + 1, right, n, str + "(");
        // 右括号数小于 N 并且小于左括号数（右括号数多于左括号数，则语义不合法），就累加，将其 ) 加入字符串
        if (right < n && right < left) generateOneByOne(list, left, right + 1, n, str + ")");
    }

}
