package io.github.dunwu.algorithm.tree.btree.dfs;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <a href="https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/">LCR 149. 彩灯装饰记录 I</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2025-10-28
 */
public class 叶子相似的树 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertTrue(s.leafSimilar(TreeNode.buildTree(3, 5, 1, 6, 2, 9, 8, null, null, 7, 4),
            TreeNode.buildTree(3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8)));
    }

    static class Solution {

        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            List<Integer> root1Leafs = new ArrayList<>();
            List<Integer> root2Leafs = new ArrayList<>();
            getLeafs(root1, root1Leafs);
            getLeafs(root2, root2Leafs);
            if (root1Leafs.size() != root2Leafs.size()) {
                return false;
            }
            for (int i = 0; i < root1Leafs.size(); i++) {
                if (!Objects.equals(root1Leafs.get(i), root2Leafs.get(i))) {
                    return false;
                }
            }
            return true;
        }

        public void getLeafs(TreeNode root, List<Integer> leafs) {
            if (root == null) {
                return;
            }
            if  (root.left == null && root.right == null) {
                leafs.add(root.val);
            }
            getLeafs(root.left, leafs);
            getLeafs(root.right, leafs);
        }

    }

}
