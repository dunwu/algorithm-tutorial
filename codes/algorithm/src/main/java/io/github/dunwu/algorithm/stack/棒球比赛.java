package io.github.dunwu.algorithm.stack;

import org.junit.jupiter.api.Assertions;

import java.util.Stack;

/**
 * <a href="https://leetcode-cn.com/problems/baseball-game/">682. 棒球比赛</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-09
 */
public class 棒球比赛 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(30, s.calPoints(new String[] { "5", "2", "C", "D", "+" }));
        Assertions.assertEquals(27, s.calPoints(new String[] { "5", "-2", "4", "C", "D", "9", "+", "+" }));
    }

    static class Solution {

        public int calPoints(String[] operations) {
            Stack<Integer> stack = new Stack<>();
            for (String op : operations) {
                switch (op) {
                    case "C":
                        stack.pop();
                        break;
                    case "D":
                        stack.push(stack.peek() * 2);
                        break;
                    case "+":
                        int cur = stack.pop();
                        int prev = stack.pop();
                        int next = prev + cur;
                        stack.push(prev);
                        stack.push(cur);
                        stack.push(next);
                        break;
                    default:
                        stack.push(Integer.valueOf(op));
                        break;
                }
            }

            int res = 0;
            while (!stack.isEmpty()) {
                res += stack.pop();
            }
            return res;
        }

    }

}
