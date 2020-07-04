package io.github.dunwu.algorithm.search;

import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-07-04
 */
public class x的平方根 {

    public static void main(String[] args) {
        Assertions.assertEquals(2, mySqrt(4));
        Assertions.assertEquals(3, mySqrt(9));
        Assertions.assertEquals(2, mySqrt(8)); // 8 的平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
        Assertions.assertEquals(2.8285f, mySqrt2(8, 4)); // 8 的平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
    }

    // 利用二分法实现求平发根
    public static int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int l = 1, r = x, res = x;
        while (l <= r) {
            int m = (l + r) / 2;
            if (m == x / m) {
                return m;
            } else if (m > x / m) {
                r = m - 1;
            } else {
                l = m + 1;
                res = m;
            }
        }
        return res;
    }

    // 利用二分法实现求浮点数平发根，支持指定精度 e （小数点位数）
    public static float mySqrt2(float x, int e) {
        if (x == 0 || Float.compare(x, 1f) == 0) return x;
        float l = 1f, r = x, res = x;
        while (l <= r) {
            float m = (l + r) / 2;
            if (m == x / m) {
                BigDecimal decimal = new BigDecimal(m).setScale(e, BigDecimal.ROUND_UP);
                return decimal.floatValue();
            } else if (m > x / m) {
                r = m;
            } else {
                l = m;
                res = m;
            }
        }
        BigDecimal decimal = new BigDecimal(res).setScale(e, BigDecimal.ROUND_UP);
        return decimal.floatValue();
    }

}
