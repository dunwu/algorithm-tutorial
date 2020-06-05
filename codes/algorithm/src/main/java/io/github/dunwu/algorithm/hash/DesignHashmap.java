package io.github.dunwu.algorithm.hash;

//    【设计哈希集合】

//
//    不使用任何内建的哈希表库设计一个哈希映射
////
////    具体地说，你的设计应该包含以下的功能
////
////    put(key, value)：向哈希映射中插入(键,值)的数值对。如果键对应的值已经存在，更新这个值。
////    get(key)：返回给定的键所对应的值，如果映射中不包含这个键，返回-1。
////    remove(key)：如果映射中存在这个键，删除这个数值对。
////
////    示例：
////
////    MyHashMap hashMap = new MyHashMap();
////    hashMap.put(1, 1);
////    hashMap.put(2, 2);
////    hashMap.get(1);            // 返回 1
////    hashMap.get(3);            // 返回 -1 (未找到)
////    hashMap.put(2, 1);         // 更新已有的值
////    hashMap.get(2);            // 返回 1
////    hashMap.remove(2);         // 删除键为2的数据
////    hashMap.get(2);            // 返回 -1 (未找到)
////
////    注意：
////
////    所有的值都在 [1, 1000000]的范围内。
////    操作的总数目在[1, 10000]范围内。
////    不要使用内建的哈希库。

class DesignHashmap {

    private int buckets = 1000;

    private int itemsPerBucket = 1001;

    private boolean[][] table;

    /**
     * Initialize your data structure here.
     */
    public DesignHashmap() {
        table = new boolean[buckets][];
    }

    public void add(int key) {
        int hashkey = hash(key);

        if (table[hashkey] == null) {
            table[hashkey] = new boolean[itemsPerBucket];
        }
        table[hashkey][pos(key)] = true;
    }

    public int hash(int key) {
        return key % buckets;
    }

    public int pos(int key) {
        return key / buckets;
    }

    public void remove(int key) {
        int hashkey = hash(key);

        if (table[hashkey] != null) {
            table[hashkey][pos(key)] = false;
        }
    }

    /**
     * Returns true if this set did not already contain the specified element
     */
    public boolean contains(int key) {
        int hashkey = hash(key);
        return table[hashkey] != null && table[hashkey][pos(key)];
    }

}
