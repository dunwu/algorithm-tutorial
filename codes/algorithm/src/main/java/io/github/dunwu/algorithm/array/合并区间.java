package io.github.dunwu.algorithm.array;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-07-29
 */
public class 合并区间 {

    public static void main(String[] args) {
        int[][] array = new int[][] {
            { 1, 4 }, { 2, 3 }
        };
        int[][] exprect = new int[][] {
            { 1, 4 }
        };
        Assertions.assertArrayEquals(exprect, merge(array));

        // int[][] array = new int[][] {
        //     { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 }
        // };
        // int[][] exprect = new int[][] {
        //     { 1, 6 }, { 8, 10 }, { 15, 18 }
        // };
        // Assertions.assertArrayEquals(exprect, merge(array));

        int[][] array2 = new int[][] {
            { 1, 4 }, { 4, 5 }
        };
        int[][] exprect2 = new int[][] {
            { 1, 5 }
        };
        Assertions.assertArrayEquals(exprect2, merge(array2));
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);

        int len = intervals.length;
        int[][] res = new int[len][2];
        int cnt = 0;
        for (int[] interval : intervals) {
            boolean merged = false;
            for (int i = 0; i < cnt; i++) {
                if (interval[0] >= res[i][0] && interval[1] <= res[i][1]) {
                    merged = true;
                    continue;
                }
                if (interval[0] <= res[i][1]) {
                    if (interval[1] >= res[i][1]) {
                        res[i][1] = interval[1];
                        merged = true;
                        continue;
                    }
                }
            }
            if (!merged) {
                res[cnt] = Arrays.copyOf(interval, 2);
                cnt++;
            }
        }
        return Arrays.copyOf(res, cnt);
    }

}
