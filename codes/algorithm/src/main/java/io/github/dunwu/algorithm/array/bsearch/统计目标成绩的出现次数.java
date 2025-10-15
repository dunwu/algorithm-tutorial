package io.github.dunwu.algorithm.array.bsearch;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/">LCR 172. 统计目标成绩的出现次数</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-10-15
 */
public class 统计目标成绩的出现次数 {

    public static void main(String[] args) {
        Assertions.assertEquals(3, countTarget(new int[] { 2, 2, 3, 4, 4, 4, 5, 6, 6, 8 }, 4));
        Assertions.assertEquals(0, countTarget(new int[] { 1, 2, 3, 5, 7, 9 }, 6));
    }

    public static int countTarget(int[] scores, int target) {
        int result = search(scores, 0, scores.length - 1, target);
        return result == -1 ? 0 : result;
    }

    static int search(int[] scores, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (scores[mid] == target) {
            int lcnt = search(scores, left, mid - 1, target);
            int rcnt = search(scores, mid + 1, right, target);
            int cnt = 1;
            if (lcnt > 0) {
                cnt += lcnt;
            }
            if (rcnt > 0) {
                cnt += rcnt;
            }
            return cnt;
        } else if (scores[mid] < target) {
            return search(scores, mid + 1, right, target);
        } else if (scores[mid] > target) {
            return search(scores, left, mid - 1, target);
        }
        return -1;
    }

}
