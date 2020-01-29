package io.github.dunwu.ds.tree;

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
public class MinDiffInBST {

    public static void main(String[] args) {
        MinDiffInBST demo = new MinDiffInBST();
        TreeNode tree = TreeUtils.buildTree(4, 2, 6, 1, 3, null, null);
        System.out.println("result = " + demo.minDiffInBST(tree));
    }

    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList();
        dfs(root, list);
        Collections.sort(list);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; ++i) {
            min = Math.min(min, list.get(i + 1) - list.get(i));
        }

        return min;
    }

    public void dfs(TreeNode node, List<Integer> list) {
        if (node == null) { return; }
        list.add(node.val);
        dfs(node.left, list);
        dfs(node.right, list);
    }

}
