package io.github.dunwu.algorithm.tree;

import java.util.List;

/**
 * 基本示例
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-10-27
 */
public class BaseCase {

    public static class Node extends NTree<Node> {

        public Node(int val) {
            super(val);
        }

        public Node(int val, List<Node> children) {
            super(val, children);
        }

    }

}
