package io.github.dunwu.algorithm.dynamic;

import io.github.dunwu.tool.util.ArrayUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-03-06
 */
public class MaxSubArray {

    private static final Logger log = LoggerFactory.getLogger(MaxSubArray.class);

    public static int maxSubArray(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] = Math.max(result[i - 1] + nums[i], nums[i]);
            if (max < result[i]) {
                max = result[i];
            }

            if (log.isDebugEnabled()) {
                log.debug(ArrayUtil.toString(result));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int max = MaxSubArray.maxSubArray(array);
        System.out.println("max = " + max);
    }

}
