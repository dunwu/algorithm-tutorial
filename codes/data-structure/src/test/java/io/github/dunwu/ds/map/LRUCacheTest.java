package io.github.dunwu.ds.map;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-01-18
 */
public class LRUCacheTest {

    @Test
    public void test() {
        LRUCache cache = new LRUCache(3);
        Assert.assertEquals(-1, cache.get(2));
        cache.put(2, 6);
        Assert.assertEquals(-1, cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        Assert.assertEquals(2, cache.get(1));
        Assert.assertEquals(6, cache.get(2));
    }

}
