package io.github.dunwu.algorithm.search;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-07-13
 */
public class 第一个错误的版本 {

    public static void main(String[] args) {

    }

    public static int firstBadVersion(int n) {
        int begin = 1, end = n;
        while (begin < end) {
            int mid = begin + (end - begin) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                begin = mid;
            }
        }
        return begin;
    }

    public static boolean isBadVersion(int n) {
        return true;
    }

}
