package io.github.dunwu.algorithm.tree.btree.bfs;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/deepest-leaves-sum/">1302. 层数最深叶子节点的和</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-18
 */
public class 完全二叉树插入器 {

    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTree(1, 2);
        Solution cBTInserter = new Solution(root);
        cBTInserter.insert(3);  // 返回 1
        cBTInserter.insert(4);  // 返回 2
        cBTInserter.get_root(); // 返回 [1, 2, 3, 4]
    }

    static class Solution {

        private TreeNode root = null;
        private Queue<TreeNode> q = null;

        public Solution(TreeNode root) {
            this.root = root;
            this.q = new LinkedList<>();
            // 进行普通的 BFS，目的是找到底部可插入的节点
            Queue<TreeNode> temp = new LinkedList<>();
            temp.offer(root);
            while (!temp.isEmpty()) {
                TreeNode cur = temp.poll();
                if (cur.left != null) {
                    temp.offer(cur.left);
                }
                if (cur.right != null) {
                    temp.offer(cur.right);
                }
                if (cur.right == null || cur.left == null) {
                    // 找到完全二叉树底部可以进行插入的节点
                    q.offer(cur);
                }
            }
        }

        public int insert(int val) {
            TreeNode node = new TreeNode(val);
            TreeNode cur = q.peek();
            // 进行插入
            if (cur.left == null) {
                cur.left = node;
            } else if (cur.right == null) {
                cur.right = node;
                q.poll();
            }
            // 新节点的左右节点也是可以插入的
            q.offer(node);
            return cur.val;
        }

        public TreeNode get_root() {
            return root;
        }

    }

}
