package io.github.dunwu.leetcode.array;

import io.github.dunwu.leetcode.util.ArrayUtil;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author Zhang Peng
 * @since 2018-11-05
 */
public class PascalsTriangle2Test {

    @Test
    public void test() {
        List<Integer> list = PascalsTriangle2.getRow(3);
        System.out.println(ArrayUtil.getArrayString(list.toArray(), 0, list.size() - 1));
    }

}
