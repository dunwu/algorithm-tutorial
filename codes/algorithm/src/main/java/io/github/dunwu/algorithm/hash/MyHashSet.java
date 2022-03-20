//    【设计哈希集合】
//
//    不使用任何内建的哈希表库设计一个哈希集合
//
//    具体地说，你的设计应该包含以下的功能
//
//    add(value)：向哈希集合中插入一个值。
//    contains(value) ：返回哈希集合中是否存在这个值。
//    remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
//
//    示例:
//
//    MyHashSet hashSet = new MyHashSet();
//    hashSet.add(1);
//    hashSet.add(2);
//    hashSet.contains(1);    // 返回 true
//    hashSet.contains(3);    // 返回 false (未找到)
//    hashSet.add(2);
//    hashSet.contains(2);    // 返回 true
//    hashSet.remove(2);
//    hashSet.contains(2);    // 返回  false (已经被删除)
//
//    注意：
//
//    所有的值都在 [1, 1000000]的范围内。
//    操作的总数目在[1, 10000]范围内。
//    不要使用内建的哈希集合库。

package io.github.dunwu.algorithm.hash;

import java.util.LinkedList;

/**
 * 实现 HashMap，使用拉链表法(基于 LinkedList 实现)决哈希冲突
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2022-03-20
 */
class MyHashSet {

    private final int BUCKET_NUM = 1000;

    private final LinkedList<Integer>[] data;

    public MyHashSet() {
        data = new LinkedList[BUCKET_NUM];
        for (int i = 0; i < BUCKET_NUM; ++i) {
            data[i] = new LinkedList<>();
        }
    }

    public void add(int key) {
        int bucket = hash(key);
        for (Integer item : data[bucket]) {
            if (item == key) {
                return;
            }
        }
        data[bucket].add(key);
    }

    public int hash(int key) {
        return key % BUCKET_NUM;
    }

    public int pos(int key) {
        return key / BUCKET_NUM;
    }

    public void remove(int key) {
        int bucket = hash(key);
        for (Integer item : data[bucket]) {
            if (item == key) {
                data[bucket].remove(item);
                return;
            }
        }
    }

    public boolean contains(int key) {
        int bucket = hash(key);
        for (Integer item : data[bucket]) {
            if (item == key) {
                return true;
            }
        }
        return false;
    }

}
