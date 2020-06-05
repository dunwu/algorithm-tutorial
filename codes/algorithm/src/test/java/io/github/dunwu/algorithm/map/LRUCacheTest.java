package io.github.dunwu.algorithm.map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-01-18
 */
public class LRUCacheTest {

    @Test
    public void test() {
        LRUCache cache = new LRUCache(3);
        Assertions.assertEquals(-1, cache.get(2));
        cache.put(2, 6);
        Assertions.assertEquals(-1, cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        Assertions.assertEquals(2, cache.get(1));
        Assertions.assertEquals(6, cache.get(2));
    }

}
