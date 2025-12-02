package io.github.dunwu.algorithm.tree.ntree;

import io.github.dunwu.algorithm.tree.Node;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/n-ary-tree-preorder-traversal/">589. N 叉树的前序遍历</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-10-27
 */
public class N叉树的前序遍历 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Node node3 = new Node(3);
        node3.children.add(new Node(5));
        node3.children.add(new Node(6));
        Node root = new Node(1);
        root.children.add(node3);
        root.children.add(new Node(2));
        root.children.add(new Node(4));
        Assertions.assertArrayEquals(new Integer[] { 1, 3, 5, 6, 2, 4 }, s.preorder(root).toArray());
    }

    static class Solution {

        public List<Integer> preorder(Node root) {
            List<Integer> res = new ArrayList<>();
            dfs(root, res);
            return res;
        }

        public void dfs(Node root, List<Integer> res) {
            if (root == null) { return; }
            res.add(root.val);
            for (int i = 0; i < root.children.size(); i++) {
                dfs(root.children.get(i), res);
            }
        }

    }

}
