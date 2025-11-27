package io.github.dunwu.algorithm.design;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/reveal-cards-in-increasing-order/">950. 按递增顺序显示卡牌</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-03
 */
public class 按递增顺序显示卡牌 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertArrayEquals(new int[] { 2, 13, 3, 11, 5, 17, 7 }
            , s.deckRevealedIncreasing(new int[] { 17, 13, 11, 2, 3, 5, 7 }));
    }

    static class Solution {

        public int[] deckRevealedIncreasing(int[] deck) {
            int n = deck.length;
            LinkedList<Integer> res = new LinkedList<>();
            Arrays.sort(deck);
            for (int i = n - 1; i >= 0; i--) {
                if (!res.isEmpty()) {
                    res.addFirst(res.removeLast());
                }
                res.addFirst(deck[i]);
            }
            int[] arr = new int[n];
            for (int i = 0; i < res.size(); i++) {
                arr[i] = res.get(i);
            }
            return arr;
        }

    }

}
