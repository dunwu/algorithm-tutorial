package io.github.dunwu.algorithm.dp.template;

/**
 * 动态规划模板
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-10
 */
public class 动态规划模板 {
    // 自顶向下递归的动态规划
    // def dp(状态1, 状态2, ...):
    //     for 选择 in 所有可能的选择:
    //     # 此时的状态已经因为做了选择而改变
    //     result = 求最值(result, dp(状态1, 状态2, ...))
    //     return result

    // 自底向上迭代的动态规划
    // 初始化 base case
    //     dp[0][0][...] = base case
    //         # 进行状态转移
    // for 状态1 in 状态1的所有取值：
    //         for 状态2 in 状态2的所有取值：
    //         for ...
    //     dp[状态1][状态2][...] = 求最值(选择1，选择2...)
}
