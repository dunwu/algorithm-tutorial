package io.github.dunwu.algorithm.tree.btree.bfs;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/">LCR 149. 彩灯装饰记录 I</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2025-10-28
 */
public class 彩灯装饰记录 {

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = TreeNode.buildTree(8, 17, 21, 18, null, null, 6);
        Assertions.assertArrayEquals(new int[] { 8, 17, 21, 18, 6 }, s.decorateRecord(root));
    }

    static class Solution {

        public int[] decorateRecord(TreeNode root) {
            ArrayList<Integer> list = new ArrayList<>();
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node == null) { continue; }
                list.add(node.val);
                if (node.left != null) { queue.offer(node.left); }
                if (node.right != null) { queue.offer(node.right); }
            }
            return list.stream().mapToInt(Integer::intValue).toArray();
        }

    }

}
