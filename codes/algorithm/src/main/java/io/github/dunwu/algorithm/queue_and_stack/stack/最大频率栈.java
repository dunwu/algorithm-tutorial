package io.github.dunwu.algorithm.queue_and_stack.stack;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Stack;
import java.util.TreeMap;

/**
 * <a href="https://leetcode.cn/problems/maximum-frequency-stack/">895. 最大频率栈</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-11
 */
public class 最大频率栈 {

    public static void main(String[] args) {
        FreqStack s1 = new FreqStack();
        s1.push(5);//堆栈为 [5]
        s1.push(7);//堆栈是 [5,7]
        s1.push(5);//堆栈是 [5,7,5]
        s1.push(7);//堆栈是 [5,7,5,7]
        s1.push(4);//堆栈是 [5,7,5,7,4]
        s1.push(5);//堆栈是 [5,7,5,7,4,5]
        Assertions.assertEquals(5, s1.pop()); //返回 5 ，因为 5 出现频率最高。堆栈变成 [5,7,5,7,4]
        Assertions.assertEquals(7, s1.pop()); //返回 7 ，因为 5 和 7 出现频率最高，但7最接近顶部。堆栈变成 [5,7,5,4]。
        Assertions.assertEquals(5, s1.pop()); //返回 5 ，因为 5 出现频率最高。堆栈变成 [5,7,4]。
        Assertions.assertEquals(4, s1.pop()); //返回 4 ，因为 4, 5 和 7 出现频率最高，但 4 是最接近顶部的。堆栈变成 [5,7]。
    }

    static class FreqStack {

        int maxFreq = 0;
        HashMap<Integer, Integer> valToFreq = new HashMap<>();
        TreeMap<Integer, Stack<Integer>> freqToVal = new TreeMap<>();

        public FreqStack() {
        }

        public void push(int val) {
            int freq = valToFreq.getOrDefault(val, 0) + 1;
            valToFreq.put(val, freq);
            freqToVal.putIfAbsent(freq, new Stack<>());
            freqToVal.get(freq).add(val);
            maxFreq = Math.max(maxFreq, freq);
        }

        public int pop() {
            Stack<Integer> vals = freqToVal.get(maxFreq);
            int v = vals.pop();
            int freq = valToFreq.get(v) - 1;
            valToFreq.put(v, freq);
            if (vals.isEmpty()) {
                maxFreq--;
            }
            return v;
        }

    }

}
