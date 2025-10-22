package io.github.dunwu.algorithm.tree.btree.divide;

import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/verify-preorder-serialization-of-a-binary-tree/">331. 验证二叉树的前序序列化</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-15
 */
public class 验证二叉树的前序序列化 {

    public static void main(String[] args) {
        Assertions.assertTrue(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        Assertions.assertFalse(isValidSerialization("1,#"));
        Assertions.assertFalse(isValidSerialization("9,#,#,1"));
    }

    public static boolean isValidSerialization(String preorder) {
        // 将字符串转化成列表
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : preorder.split(",")) {
            nodes.addLast(s);
        }
        return deserialize(nodes) && nodes.isEmpty();
    }

    public static boolean deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return false;
        }

        // ***** 前序遍历位置 *****
        // 列表最左侧就是根节点
        String first = nodes.removeFirst();
        if (first.equals("#")) return true;
        // *********************

        return deserialize(nodes) && deserialize(nodes);
    }

}
