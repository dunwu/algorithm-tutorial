package io.github.dunwu.algorithm.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @see <a href="https://leetcode-cn.com/problems/number-of-recent-calls/">933. 最近的请求次数</a>
 * @since 2020-06-10
 */
public class 最近的请求次数 {

    Queue<Integer> queue;

    public 最近的请求次数() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        while (queue.peek() < t - 3000) { queue.poll(); }
        return queue.size();
    }

}
