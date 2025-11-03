package io.github.dunwu.algorithm.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * N 叉树
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-10-27
 */
public class NAryTree<T extends NAryTree<T>> {

    public int val;
    public List<T> children;

    public NAryTree() {
        val = -1;
        children = new LinkedList<>();
    }

    public NAryTree(int val) {
        this.val = val;
        this.children = new LinkedList<>();
    }

    public NAryTree(int val, List<T> children) {
        this.val = val;
        this.children = children;
    }

}
