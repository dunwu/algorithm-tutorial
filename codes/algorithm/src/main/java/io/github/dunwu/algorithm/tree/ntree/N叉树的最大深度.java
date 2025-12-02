package io.github.dunwu.algorithm.tree.ntree;

import io.github.dunwu.algorithm.tree.Node;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/">559. N叉树的最大深度</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2020-03-23
 */
public class N叉树的最大深度 {

    public static void main(String[] args) {
        Solution s = new Solution();
        io.github.dunwu.algorithm.tree.Node node3 = new io.github.dunwu.algorithm.tree.Node(3);
        node3.children.add(new io.github.dunwu.algorithm.tree.Node(5));
        node3.children.add(new io.github.dunwu.algorithm.tree.Node(6));
        io.github.dunwu.algorithm.tree.Node root = new io.github.dunwu.algorithm.tree.Node(1);
        root.children.add(node3);
        root.children.add(new io.github.dunwu.algorithm.tree.Node(2));
        root.children.add(new io.github.dunwu.algorithm.tree.Node(4));
        Assertions.assertEquals(3, s.maxDepth(root));
    }

    static class Solution {

        private int max = 0;

        public int maxDepth(Node root) {
            max = 0;
            dfs(root);
            return max;
        }

        public int dfs(Node root) {
            if (root == null) { return 0; }

            int depth = 0;
            for (int i = 0; i < root.children.size(); i++) {
                depth = Math.max(depth, dfs(root.children.get(i)));
            }
            max = Math.max(max, depth + 1);
            return depth + 1;
        }

    }

}
