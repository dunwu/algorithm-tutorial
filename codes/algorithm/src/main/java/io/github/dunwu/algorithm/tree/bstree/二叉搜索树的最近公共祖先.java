package io.github.dunwu.algorithm.tree.bstree;

import io.github.dunwu.algorithm.tree.TreeNode;
import io.github.dunwu.algorithm.tree.TreeUtils;
import io.github.dunwu.algorithm.tree.btree.二叉树的最近公共祖先;
import org.junit.jupiter.api.Assertions;

/**
 * <code>235. 二叉搜索树的最近公共祖先</code> 算法实现
 *
 * @see 二叉树的最近公共祖先 可以使用二叉树的最近公共祖先，但没有利用二叉搜索树特性，性能略差
 * @see <a href="https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/">235. 二叉搜索树的最近公共祖先</a>
 */
public class 二叉搜索树的最近公共祖先 {

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildTree(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5);
        TreeNode p = TreeUtils.find(root, 2);
        TreeNode q = TreeUtils.find(root, 8);
        // TreeNode treeNode = lowestCommonAncestor(root, p, q);
        TreeNode treeNode = lowestCommonAncestor2(root, p, q);
        Assertions.assertNotNull(treeNode);
        Assertions.assertEquals(6, treeNode.val);
        System.out.println("公共祖先节点 = " + treeNode.val);

        TreeNode root2 = TreeUtils.buildTree(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5);
        TreeNode p2 = TreeUtils.find(root2, 2);
        TreeNode q2 = TreeUtils.find(root2, 4);
        // TreeNode treeNode2 = lowestCommonAncestor(root2, p2, q2);
        TreeNode treeNode2 = lowestCommonAncestor2(root2, p2, q2);
        Assertions.assertNotNull(treeNode2);
        Assertions.assertEquals(2, treeNode2.val);
        System.out.println("公共祖先节点 = " + treeNode2.val);
    }

    /**
     * 递归方式求解
     * <p>
     * 时间复杂度：O(N) 线性级
     * <p>
     * 空间复杂度：O(2) 常数级
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 如果当前节点为空，直接返回
        // 或当前节点就是 p 或 q 其中一个，显然就是要找的最近公共祖先，直接返回
        if (root == null || root == p || root == q) return root;

        if (root.val > p.val && root.val > q.val) { // 如果当前节点值同时大于 p、q 的值，说明 p、q 肯定都在左子树
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) { // 如果当前节点值同时小于 p、q 的值，说明 p、q 肯定都在右子树
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    /**
     * 非递归方式求解
     * <p>
     * 时间复杂度：O(N) 线性级
     * <p>
     * 空间复杂度：O(2) 常数级
     */
    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        // 如果当前节点为空，直接返回
        // 或当前节点就是 p 或 q 其中一个，显然就是要找的最近公共祖先，直接返回
        if (root == null || root == p || root == q) return root;

        TreeNode curr = root;
        while (curr != null) {
            if (curr.val > p.val && curr.val > q.val) { // 如果当前节点值同时大于 p、q 的值，说明 p、q 肯定都在左子树
                curr = curr.left;
            } else if (curr.val < p.val && curr.val < q.val) { // 如果当前节点值同时小于 p、q 的值，说明 p、q 肯定都在右子树
                curr = curr.right;
            } else {
                return curr;
            }
        }
        return curr;
    }

}
