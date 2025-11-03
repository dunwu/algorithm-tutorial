package io.github.dunwu.algorithm.data_structure;

import org.junit.jupiter.api.Assertions;

import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * <a href="https://leetcode.cn/problems/lru-cache/">146. LRU 缓存</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-10-31
 */
public class LRU缓存 {

    public static void main(String[] args) {

        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        Assertions.assertEquals(1, lRUCache.get(1));
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        Assertions.assertEquals(-1, lRUCache.get(2));
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        Assertions.assertEquals(-1, lRUCache.get(1));
        Assertions.assertEquals(3, lRUCache.get(3));
        Assertions.assertEquals(4, lRUCache.get(4));
    }

    static class LRUCache {

        private int capacity = 0;
        private LinkedHashMap<Integer, Integer> cache = null;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cache = new LinkedHashMap<>(capacity);
        }

        public int get(int key) {
            Integer val = cache.get(key);
            if (val != null) {
                cache.remove(key);
                cache.put(key, val);
            }
            return val == null ? -1 : val;
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                cache.remove(key);
            } else {
                if (capacity <= cache.size()) {
                    Iterator<Integer> iterator = cache.keySet().iterator();
                    cache.remove(iterator.next());
                }
            }
            cache.put(key, value);
        }

    }

}
