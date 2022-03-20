package io.github.dunwu.algorithm.hash;

// 不使用任何内建的哈希表库设计一个哈希映射（HashMap）。
//
// 实现 MyHashMap 类：
//
// MyHashMap() 用空映射初始化对象
// void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，则更新其对应的值 value 。
// int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。
// void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。
//
// 示例：
//
// 输入：
// ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
// [[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
// 输出：
// [null, null, null, 1, -1, null, 1, null, -1]
//
// 解释：
// MyHashMap myHashMap = new MyHashMap();
// myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
// myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
// myHashMap.get(1);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
// myHashMap.get(3);    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
// myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
// myHashMap.get(2);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
// myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
// myHashMap.get(2);    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]
//
// 提示：
//
// 0 <= key, value <= 106
// 最多调用 104 次 put、get 和 remove 方法
//
// 链接：https://leetcode-cn.com/leetbook/read/hash-table/xhqwd3/

import java.util.LinkedList;

/**
 * 实现 HashMap，使用拉链表法(基于 LinkedList 实现)决哈希冲突
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2022-03-20
 */
public class MyHashMap {

    private final int BUCKET_NUM = 1000;
    private final LinkedList<Pair>[] data;

    public MyHashMap() {
        data = new LinkedList[BUCKET_NUM];
        for (int i = 0; i < BUCKET_NUM; ++i) {
            data[i] = new LinkedList<>();
        }
    }

    public void put(int key, int value) {
        int bucket = hash(key);
        for (Pair pair : data[bucket]) {
            if (pair.key == key) {
                pair.value = value;
                return;
            }
        }
        data[bucket].add(new Pair(key, value));
    }

    public int get(int key) {
        int bucket = hash(key);
        for (Pair pair : data[bucket]) {
            if (pair.key == key) {
                return pair.value;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int bucket = hash(key);
        for (Pair pair : data[bucket]) {
            if (pair.key == key) {
                data[bucket].remove(pair);
                return;
            }
        }
    }

    private int hash(int key) {
        return key % BUCKET_NUM;
    }

    private static class Pair {

        private final int key;
        private int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

    }

    public static void main(String[] args) {
        MyHashMap obj = new MyHashMap();
        obj.put(5, 555);
        obj.put(1005, 555);
        System.out.println("key = 5, value = " + obj.get(5));
        System.out.println("key = 1005, value = " + obj.get(1005));
        // obj.remove(key);
    }

}
