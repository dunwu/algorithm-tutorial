package io.github.dunwu.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//    【杨辉三角】
//
//    给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
//
//    在杨辉三角中，每个数是它左上方和右上方的数的和。
//
//    示例:
//
//    输入: 5
//    输出:
//    [
//    [1],
//    [1,1],
//    [1,2,1],
//    [1,3,3,1],
//    [1,4,6,4,1]
//    ]

/**
 * @author Zhang Peng
 * @since 2018-11-04
 */
public class 杨辉三角 {

    public static void main(String[] args) {
        List<List<Integer>> lists = 杨辉三角.generate(5);
        printPascalsTriangle(lists);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        if (numRows <= 0) {

        } else if (numRows == 1) {
            result.add(Arrays.asList(1));
        } else if (numRows == 2) {
            result.add(Arrays.asList(1));
            result.add(Arrays.asList(1, 1));
        } else {
            result.add(Arrays.asList(1));
            result.add(Arrays.asList(1, 1));
            for (int i = 2; i < numRows; i++) {
                List<Integer> current = result.get(i - 1);
                List<Integer> next = new ArrayList<>();

                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) {
                        next.add(1);
                    } else {
                        int x = current.get(j - 1);
                        int y = current.get(j);
                        next.add(x + y);
                    }
                }

                result.add(next);
            }
        }

        return result;
    }

    static void printPascalsTriangle(List<List<Integer>> lists) {
        System.out.printf("【%d层杨辉三角】\n", lists.size());
        for (List<Integer> list : lists) {
            for (Integer num : list) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

}
