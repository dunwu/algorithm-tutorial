package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import io.github.dunwu.algorithm.tree.TreeUtils;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <code>叶子相似的树</code> 算法实现
 *
 * <pre>
 * 请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 *
 *
 *
 * 举个例子，如上图所示，给定一颗叶值序列为 (6, 7, 4, 9, 8) 的树。
 *
 * 如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 *
 * 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 *
 * 提示：
 *
 * 给定的两颗树可能会有 1 到 100 个结点。
 * </pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/leaf-similar-trees/">叶子相似的树</a>
 */
public class 叶子相似的树 {

    public static void main(String[] args) {
        TreeNode tree1 = TreeUtils.asTree(3, 5, 1, 6, 2, 9, 8, null, null, 7, 4);
        TreeNode tree2 = TreeUtils.asTree(3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8);
        Assertions.assertTrue(leafSimilar(tree1, tree2));
    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafs1 = new LinkedList<>();
        List<Integer> leafs2 = new LinkedList<>();
        leafNodes(root1, leafs1);
        leafNodes(root2, leafs2);
        return Arrays.equals(leafs1.toArray(), leafs2.toArray());
    }

    public static void leafNodes(TreeNode root, List<Integer> leafs) {
        if (root == null) { return; }
        if (root.left == null && root.right == null) { leafs.add(root.val); }
        leafNodes(root.left, leafs);
        leafNodes(root.right, leafs);
    }

}
