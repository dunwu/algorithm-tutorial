package io.github.dunwu.algorithm.tree.btree.bfs;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/">LCR 151. 彩灯装饰记录 III</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2025-10-28
 */
public class 彩灯装饰记录3 {

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = TreeNode.buildTree(8, 17, 21, 18, null, null, 6);
        List<List<Integer>> expectList = new ArrayList<>();
        expectList.add(Arrays.asList(8));
        expectList.add(Arrays.asList(21, 17));
        expectList.add(Arrays.asList(18, 6));
        List<List<Integer>> output = s.decorateRecord(root);
        for (int i = 0; i < expectList.size(); i++) {
            Assertions.assertArrayEquals(expectList.get(i).toArray(), output.get(i).toArray());
        }
    }

    static class Solution {

        public List<List<Integer>> decorateRecord(TreeNode root) {
            List<List<Integer>> res = new LinkedList<>();
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            boolean reverse = false;
            while (!queue.isEmpty()) {
                LinkedList<Integer> list = new LinkedList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node == null) { continue; }
                    if (reverse) {
                        list.addFirst(node.val);
                    } else {
                        list.addLast(node.val);
                    }
                    if (node.left != null) { queue.offer(node.left); }
                    if (node.right != null) { queue.offer(node.right); }
                }
                if (list.size() != 0) {
                    res.add(list);
                }
                reverse = !reverse;
            }
            return res;
        }

    }

}
