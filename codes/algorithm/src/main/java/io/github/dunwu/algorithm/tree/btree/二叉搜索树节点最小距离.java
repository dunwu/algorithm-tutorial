package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeUtils;
import io.github.dunwu.algorithm.tree.btree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <code>二叉搜索树结点最小距离</code> 算法实现
 *
 * <pre>
 * 给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。
 *
 * 示例：
 *
 * 输入: root = [4,2,6,1,3,null,null]
 * 输出: 1
 * 解释:
 * 注意，root是树结点对象(TreeNode object)，而不是数组。
 *
 * 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
 *
 *           4
 *         /   \
 *       2      6
 *      / \
 *     1   3
 *
 * 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
 * </pre>
 *
 * @see <a href="https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes">二叉搜索树结点最小距离</a>
 */
public class 二叉搜索树节点最小距离 {

    public static void main(String[] args) {
        TreeNode tree = TreeUtils.buildTree(4, 2, 6, 1, 3, null, null);
        System.out.println("result = " + minDiffInBST2(tree));
    }

    // -------------------------------------------------------------------------------------------------

    // 方法一：排序【通过】
    // 思路和算法：将树中所有节点的值写入数组，之后将数组排序。依次计算相邻数之间的差值，找出其中最小的值。

    public static int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList();
        dfs(root, list);
        Collections.sort(list);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; ++i) {
            min = Math.min(min, list.get(i + 1) - list.get(i));
        }

        return min;
    }

    public static void dfs(TreeNode node, List<Integer> list) {
        if (node == null) { return; }
        list.add(node.val);
        dfs(node.left, list);
        dfs(node.right, list);
    }

    // -------------------------------------------------------------------------------------------------

    // 方法二：中序遍历【通过】
    // 思路和算法：在二叉搜索树中，中序遍历会将树中节点按数值大小顺序输出。只需要遍历计算相邻数的差值，取其中最小的就可以了。

    public static Integer prev = null;
    public static Integer min = Integer.MAX_VALUE;

    public static int minDiffInBST2(TreeNode root) {
        if (root == null) return 0;
        dfs2(root);
        return min;
    }

    public static void dfs2(TreeNode node) {
        if (node == null) { return; }
        dfs2(node.left);
        if (prev != null) min = Math.min(min, node.val - prev);
        prev = node.val;
        dfs2(node.right);
    }

}
