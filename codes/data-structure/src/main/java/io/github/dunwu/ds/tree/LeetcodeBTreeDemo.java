package io.github.dunwu.ds.tree;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-01-18
 */
public class LeetcodeBTreeDemo {

    /**
     * <code>二叉树的最近公共祖先</code> 算法实现
     * <p>
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     * <p>
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     * <p>
     * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
     * <p>
     * 示例 1:
     *
     * <pre>
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     * 输出: 3
     * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
     * </pre>
     * <p>
     * 示例 2:
     *
     * <pre>
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
     * 输出: 5
     * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
     * </pre>
     * <p>
     * 说明:
     * <p>
     * 所有节点的值都是唯一的。
     * <p>
     * p、q 为不同节点且均存在于给定的二叉树中。
     *
     * @see <a href="https://leetcode-cn.com/explore/featured/card/bytedance/244/linked-list-and-tree/1026/">二叉树的最近公共祖先</a>
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    }

    public static class TreeNode {

        int val;

        TreeNode left;

        TreeNode right;

        public TreeNode(int val) { this.val = val; }

    }

}
