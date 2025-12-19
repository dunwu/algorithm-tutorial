package io.github.dunwu.algorithm.dp.template;

/**
 * 动态规划解背包问题模板
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-12-17
 */
public class 动态规划解背包问题模板 {

    // int[][] dp[N+1][W+1]
    // dp[0][..] = 0
    // dp[..][0] = 0
    //
    // for i in [1..N]:
    // for w in [1..W]:
    // dp[i][w] = max(
    //     把物品 i 装进背包,
    //     不把物品 i 装进背包
    // )
    // return dp[N][W]
}
