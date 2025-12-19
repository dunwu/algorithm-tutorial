package io.github.dunwu.algorithm.stack.template;

import java.util.Stack;

/**
 * 单调栈算法模板
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-12-19
 */
public class 单调栈算法模板 {

    /**
     * 下一个更大的元素：计算 nums 中每个元素的下一个更大元素
     */
    int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        // 存放答案的数组
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        // 因为是求 nums[i] 后面的元素，所以倒着往栈里放
        for (int i = n - 1; i >= 0; i--) {
            // 删掉 nums[i] 后面较小的元素
            while (!s.isEmpty() && s.peek() <= nums[i]) {
                s.pop();
            }
            // 现在栈顶就是 nums[i] 身后的更大元素
            res[i] = s.isEmpty() ? -1 : s.peek();
            s.push(nums[i]);
        }
        return res;
    }

    /**
     * 下一个更大或相等的元素：计算 nums 中每个元素的下一个更大或相等的元素
     */
    int[] nextGreaterOrEqualElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            // 把这里改成 < 号
            while (!s.isEmpty() && s.peek() < nums[i]) {
                s.pop();
            }
            // 现在栈顶就是 nums[i] 身后的大于等于 nums[i] 的元素
            res[i] = s.isEmpty() ? -1 : s.peek();
            s.push(nums[i]);
        }
        return res;
    }

    /**
     * 下一个更小的元素：计算 nums 中每个元素的下一个更小的元素
     */
    int[] nextLessElement(int[] nums) {
        int n = nums.length;
        // 存放答案的数组
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        // 倒着往栈里放
        for (int i = n - 1; i >= 0; i--) {
            // 删掉 nums[i] 后面较大的元素
            while (!s.isEmpty() && s.peek() >= nums[i]) {
                s.pop();
            }
            // 现在栈顶就是 nums[i] 身后的更小元素
            res[i] = s.isEmpty() ? -1 : s.peek();
            s.push(nums[i]);
        }
        return res;
    }

    /**
     * 下一个更小或相等的元素：计算 nums 中每个元素的下一个更小或相等的元素
     */
    int[] nextLessOrEqualElement(int[] nums) {
        int n = nums.length;
        // 存放答案的数组
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        // 倒着往栈里放
        for (int i = n - 1; i >= 0; i--) {
            // 删掉 nums[i] 后面较大的元素
            while (!s.isEmpty() && s.peek() > nums[i]) {
                s.pop();
            }
            // 现在栈顶就是 nums[i] 身后的更小或相等元素
            res[i] = s.isEmpty() ? -1 : s.peek();
            s.push(nums[i]);
        }
        return res;
    }

    /**
     * 上一个更大元素：计算 nums 中每个元素的上一个更大元素
     */
    int[] prevGreaterElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        // 因为是求 nums[i] 前面的元素，所以正着往栈里放
        for (int i = 0; i < n; i++) {
            // 删掉 nums[i] 前面较小的元素
            while (!s.isEmpty() && s.peek() <= nums[i]) {
                s.pop();
            }
            // 现在栈顶就是 nums[i] 前面的更大元素
            res[i] = s.isEmpty() ? -1 : s.peek();
            s.push(nums[i]);
        }
        return res;
    }

    /**
     * 上一个更大或相等的元素：计算 nums 中每个元素的上一个更大或相等元素
     */
    int[] prevGreaterOrEqualElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            // 注意不等号
            while (!s.isEmpty() && s.peek() < nums[i]) {
                s.pop();
            }
            // 现在栈顶就是 nums[i] 前面的更大或相等元素
            res[i] = s.isEmpty() ? -1 : s.peek();
            s.push(nums[i]);
        }
        return res;
    }

    /**
     * 上一个更小的元素：计算 nums 中每个元素的上一个更小的元素
     */
    int[] prevLessElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            // 把 nums[i] 之前的较大元素删除
            while (!s.isEmpty() && s.peek() >= nums[i]) {
                s.pop();
            }
            // 现在栈顶就是 nums[i] 前面的更小元素
            res[i] = s.isEmpty() ? -1 : s.peek();
            s.push(nums[i]);
        }
        return res;
    }

    /**
     * 上一个更小或相等的元素：计算 nums 中每个元素的上一个更小或相等元素
     */
    int[] prevLessOrEqualElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            // 注意不等号
            while (!s.isEmpty() && s.peek() > nums[i]) {
                s.pop();
            }
            // 现在栈顶就是 nums[i] 前面的更小或相等元素
            res[i] = s.isEmpty() ? -1 : s.peek();
            s.push(nums[i]);
        }
        return res;
    }

}
