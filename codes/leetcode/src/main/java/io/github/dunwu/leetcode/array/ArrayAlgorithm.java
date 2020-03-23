package io.github.dunwu.leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-03-11
 */
public class ArrayAlgorithm {

    /**
     * 题目：<a href="https://leetcode-cn.com/problems/two-sum/">1. 两数之和</a>
     * <p>
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     */
    public static int[] twoSumInSorted(int[] nums, int target) {
        final int[] notFound = new int[] { -1, -1 };
        if (nums == null || nums.length < 2) {
            return notFound;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int v = nums[left] + nums[right];
            if (v == target) {
                return new int[] { left + 1, right + 1 };
            } else if (v > target) {
                right--;
            } else {
                left++;
            }
        }
        return notFound;
    }

    /**
     * 题目：<a href="https://leetcode-cn.com/problems/two-sum/">1. 两数之和</a>
     * <p>
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     */
    public static int[] twoSum_method1(int[] nums, int target) {
        final int[] notFound = new int[] { -1, -1 };
        if (nums == null || nums.length < 2) {
            return notFound;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return notFound;
    }

    /**
     * 题目：<a href="https://leetcode-cn.com/problems/two-sum/">1. 两数之和</a>
     * <p>
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     */
    public static int[] twoSum_method2(int[] nums, int target) {
        final int[] notFound = new int[] { -1, -1 };
        if (nums == null || nums.length < 2) {
            return notFound;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[] { map.get(temp), i };
            } else {
                map.put(nums[i], i);
            }
        }

        return notFound;
    }

    /**
     * 题目：<a href="https://leetcode-cn.com/problems/contains-duplicate/">217. 存在重复元素</a>
     * <p>
     * 给定一个整数数组，判断是否存在重复元素。
     * <p>
     * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
     */
    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        return set.size() != nums.length;
    }

    /**
     * 题目：<a href="https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/">面试题53 - I.
     * 在排序数组中查找数字I</a>
     * <p>
     * 统计一个数字在排序数组中出现的次数。
     */
    public static int count(int[] nums, int target) {
        int count = 0;
        for (int i : nums) {
            if (target == i) {
                count++;
                continue;
            }

            if (count != 0) { break; }
        }
        return count;
    }

    /**
     * 题目：<a href="https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/">34.
     * 在排序数组中查找元素的第一个和最后一个位置</a>
     * <p>
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * <p>
     * 如果数组中不存在目标值，返回 [-1, -1]。
     */
    public static int[] searchRange(int[] nums, int target) {
        final int[] notFoundResult = { -1, -1 };
        if (nums == null || nums.length == 0) { return notFoundResult; }

        int begin = searchLeft(nums, target);
        if (begin == nums.length || nums[begin] != target) { return notFoundResult; }
        int end = searchRight(nums, target);
        return new int[] { begin, end };
    }

    /**
     * 数组二分查找，要求传入的数组是有序排列
     * <p>
     * 参考：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/er-fen-cha-zhao-suan-fa-xi-jie-xiang-jie-by-labula/
     */
    public static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) { return -1; }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2; // 防止 mid 溢出
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static int searchLeft(int[] nums, int target) {
        if (nums == null || nums.length == 0) { return -1; }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                right = mid - 1;
            }
        }

        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    public static int searchRight(int[] nums, int target) {
        if (nums == null || nums.length == 0) { return -1; }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                left = mid + 1;
            }
        }

        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }

    /**
     * 题目：<a href="https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum/">1013.
     * 将数组分成和相等的三个部分</a>
     * <p>
     * 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
     * <p>
     * 形式上，如果可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... +
     * A[A.length - 1]) 就可以将数组三等分。
     */
    public static boolean canThreePartsEqualSum(int[] array) {
        return false;
    }

}
