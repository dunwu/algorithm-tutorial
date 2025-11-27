package io.github.dunwu.algorithm.design;

import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/number-of-students-unable-to-eat-lunch/">1700. 无法吃午餐的学生数量</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-03
 */
public class 无法吃午餐的学生数量 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(0, s.countStudents(new int[] { 1, 1, 0, 0 }, new int[] { 0, 1, 0, 1 }));
        Assertions.assertEquals(3, s.countStudents(new int[] { 1, 1, 1, 0, 0, 1 }, new int[] { 1, 0, 0, 0, 1, 1 }));
    }

    static class Solution {

        public int countStudents(int[] students, int[] sandwiches) {
            int total = students.length;
            LinkedList<Integer> studentQueue = new LinkedList<>();
            for (int s : students) {
                studentQueue.addLast(s);
            }
            int matchNum = 0;
            while (matchNum < sandwiches.length) {
                int notMatchNum = 0;
                int size = studentQueue.size();
                while (notMatchNum < size) {
                    Integer s = studentQueue.removeFirst();
                    if (s == sandwiches[matchNum]) {
                        matchNum++;
                        break;
                    } else {
                        studentQueue.addLast(s);
                        notMatchNum++;
                    }
                }
                if (notMatchNum == size) {
                    break;
                }
            }
            return total - matchNum;
        }

    }

}
