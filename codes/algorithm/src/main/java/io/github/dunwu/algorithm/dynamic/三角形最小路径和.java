package io.github.dunwu.algorithm.dynamic;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @see <a href="https://leetcode-cn.com/problems/triangle/">120. 三角形最小路径和</a>
 * @since 2020-07-04
 */
public class 三角形最小路径和 {

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Collections.singletonList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        System.out.println("args = " + minimumTotal(triangle));
        Assertions.assertEquals(11, minimumTotal(triangle));
        Assertions.assertEquals(11, minimumTotal2(triangle));
        Assertions.assertEquals(11, minimumTotal3(triangle));
        Assertions.assertEquals(11, minimumTotal4(triangle));
    }

    // 回溯法，自上而下
    // 时间复杂度：O(2^(M*N))
    public static int minimumTotal(List<List<Integer>> triangle) {
        return backtrack(triangle, triangle.size(), 0, 0);
    }

    private static int backtrack(List<List<Integer>> triangle, int row, int x, int y) {
        if (x == row - 1) return triangle.get(x).get(y);
        int left = backtrack(triangle, row, x + 1, y);
        int right = backtrack(triangle, row, x + 1, y + 1);
        return triangle.get(x).get(y) + Math.min(left, right);
    }

    // 回溯法 + 剪枝，自上而下
    // 针对 minimumTotal 加入记忆缓存 memory 存储计算结果，避免递归中的重复计算
    // 时间复杂度：< O(2^(M*N))
    // 空间复杂度：O(M*M)
    public static int minimumTotal2(List<List<Integer>> triangle) {
        int level = triangle.size();
        int[][] memory = new int[level][level]; // 存储每个节点能得到的最优解
        return backtrack2(triangle, memory, triangle.size(), 0, 0);
    }

    private static int backtrack2(List<List<Integer>> triangle, int[][] memory, int row, int x, int y) {
        if (memory[x][y] != 0) { return memory[x][y]; }
        if (x == row - 1) return memory[x][y] = triangle.get(x).get(y);
        int left = backtrack2(triangle, memory, row, x + 1, y);
        int right = backtrack2(triangle, memory, row, x + 1, y + 1);
        memory[x][y] = triangle.get(x).get(y) + Math.min(left, right);
        return memory[x][y];
    }

    // 动态规划，自下而上
    // 时间复杂度：O(M^2)
    // 空间复杂度：O(M^2)
    public static int minimumTotal3(List<List<Integer>> triangle) {
        // 判空
        if (triangle == null || triangle.size() == 0) return 0;
        int level = triangle.size();
        // 横竖维度都加1，可以不用考虑最后一行的初始化
        // 由于是三角形二维数组，可视为横竖维度都是行数
        int[][] memory = new int[level + 1][level + 1];
        for (int i = level - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (memory[i][j] == 0) {
                    memory[i][j] = Math.min(memory[i + 1][j], memory[i + 1][j + 1]) + triangle.get(i).get(j);
                }
            }
        }
        return memory[0][0];
    }

    // 动态规划，自下而上 + 空间优化
    // 时间复杂度：O(M^2)
    // 空间复杂度：O(M^2)
    public static int minimumTotal4(List<List<Integer>> triangle) {
        // 判空
        if (triangle == null || triangle.size() == 0) return 0;
        int level = triangle.size();
        // 横竖维度都加1，可以不用考虑最后一行的初始化
        // 由于是三角形二维数组，可视为横竖维度都是行数
        int[] memory = new int[level + 1];
        for (int i = level - 1; i >= 0; i--) {
            List<Integer> rows = triangle.get(i);
            for (int j = 0; j < rows.size(); j++) {
                memory[j] = Math.min(memory[j], memory[j + 1]) + rows.get(j);
            }
        }
        return memory[0];
    }

}
