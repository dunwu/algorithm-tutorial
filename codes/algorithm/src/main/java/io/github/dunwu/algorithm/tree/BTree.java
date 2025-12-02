package io.github.dunwu.algorithm.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * 二叉树
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-01-28
 */
public class BTree<T extends Comparable<T>> {

    /**
     * 二叉树根节点
     */
    private TreeNode<T> root;

    public BTree() {
        this.root = null;
    }

    public BTree(TreeNode<T> root) {
        this.root = root;
    }

    public static <T extends Comparable<T>> BTree<T> build(T... array) {
        BTree<T> tree = new BTree<>();
        List<TreeNode<T>> list = new ArrayList<>();

        for (T value : array) {
            // 创建结点，每一个结点的左结点和右结点为null
            TreeNode<T> node;
            if (value == null) {
                node = null;
            } else {
                node = new TreeNode<>(value, null, null);
            }
            // list中存着每一个结点
            list.add(node);
        }

        // 构建二叉树
        if (list.size() > 0) {
            // i表示的是根节点的索引，从0开始
            for (int i = 0; i < array.length / 2 - 1; i++) {
                if (list.get(2 * i + 1) != null) {
                    // 左结点
                    list.get(i).left = list.get(2 * i + 1);
                }
                if (list.get(2 * i + 2) != null) {
                    // 右结点
                    list.get(i).right = list.get(2 * i + 2);
                }
            }
            // 判断最后一个根结点：因为最后一个根结点可能没有右结点，所以单独拿出来处理
            int lastIndex = array.length / 2 - 1;
            // 左结点
            list.get(lastIndex).left = list.get(lastIndex * 2 + 1);
            // 右结点，如果数组的长度为奇数才有右结点
            if (array.length % 2 == 1) {
                list.get(lastIndex).right = list.get(lastIndex * 2 + 2);
            }

            tree.root = list.get(0);
        } else {
            tree.root = null;
        }
        return tree;
    }

    /**
     * 判断两颗二叉树是否完全一致
     * <p>
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     *
     * @param tree1 {@link BTree}
     * @param tree2 {@link BTree}
     * @param <T>   元素类型
     * @return true / false
     */
    public static <T extends Comparable<T>> boolean isEquals(final BTree<T> tree1, final BTree<T> tree2) {
        return TreeNode.isEquals(tree1.root, tree2.root);
    }

    /**
     * 判断两颗二叉树的叶子节点是否相似
     *
     * @param tree1 {@link BTree}
     * @param tree2 {@link BTree}
     * @return true / false
     * @see <a href="https://leetcode-cn.com/problems/leaf-similar-trees/">叶子相似的树</a>
     */
    public static <T extends Comparable<T>> boolean isLeafSimilar(final BTree<T> tree1, final BTree<T> tree2) {
        List<T> leafs1 = TreeNode.getLeafNodes(tree1.root);
        List<T> leafs2 = TreeNode.getLeafNodes(tree2.root);
        return Arrays.equals(leafs1.toArray(), leafs2.toArray());
    }

    /**
     * 获取叶子节点
     */
    public List<T> getLeafNodes() {
        return TreeNode.getLeafNodes(this.root);
    }

    /**
     * 返回二叉树的最大深度
     *
     * @return 二叉树的最大深度
     */
    public int maxDepth() {
        return TreeNode.maxDepth(this.root);
    }

    /**
     * 返回二叉树的最小深度
     *
     * @return 二叉树的最小深度
     */
    public int minDepth() {
        return TreeNode.minDepth(this.root);
    }

    // ------------------------------------------------------------- 遍历元素

    /**
     * 将二叉树按层次遍历顺序转换为列表，即广度优先搜索（BFS）
     *
     * @return {@link List<List<T>>}
     */
    public List<List<T>> levelOrderLists() {
        return TreeNode.levelOrderLists(this.root);
    }

    public static class TreeNode<T extends Comparable<T>> {

        T val;

        TreeNode<T> left;

        TreeNode<T> right;

        public TreeNode(T val) {
            this.val = val;
        }

        public TreeNode(T val, TreeNode<T> left, TreeNode<T> right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof TreeNode)) return false;
            TreeNode treeNode = (TreeNode) o;
            return Objects.equals(val, treeNode.val) &&
                Objects.equals(left, treeNode.left) &&
                Objects.equals(right, treeNode.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, left, right);
        }

        public static <T extends Comparable<T>> TreeNode<T> build(T... values) {

            if (values == null || values.length == 0 || values[0] == null) {
                return null;
            }

            Queue<TreeNode<T>> queue = new LinkedList<>();
            TreeNode<T> root = new TreeNode<>(values[0]);
            queue.offer(root);

            int i = 1;
            while (!queue.isEmpty()) {
                TreeNode<T> current = queue.poll();

                // 处理左子节点
                if (i < values.length && values[i] != null) {
                    current.left = new TreeNode<T>(values[i]);
                    queue.offer(current.left);
                }
                i++;

                // 处理右子节点
                if (i < values.length && values[i] != null) {
                    current.right = new TreeNode<T>(values[i]);
                    queue.offer(current.right);
                }
                i++;
            }

            return root;
        }

        public static <T extends Comparable<T>> TreeNode<T> find(TreeNode<T> root, T val) {
            if (root == null || Objects.equals(root.val, val)) { return root; }
            TreeNode<T> left = find(root.left, val);
            if (left != null) return left;
            return find(root.right, val);
        }

        public static <T extends Comparable<T>> List<TreeNode<T>> toList(TreeNode<T> root) {
            List<TreeNode<T>> list = new ArrayList<>();
            if (root == null) {
                return list;
            }

            Queue<TreeNode<T>> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode<T> node = queue.poll();
                list.add(node);
                if (node == null) continue;
                queue.add(node.left);
                queue.add(node.right);
            }

            // 删除队列尾部的所有 null
            int last = list.size() - 1;
            while (last > 0 && list.get(last) == null) {
                last--;
            }
            return list.subList(0, last + 1);
        }

        public static <T extends Comparable<T>> List<T> toValueList(TreeNode<T> root) {
            List<T> list = new ArrayList<>();
            if (root == null) {
                return list;
            }

            Queue<TreeNode<T>> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode<T> node = queue.poll();
                if (node == null) {
                    list.add(null);
                    continue;
                } else {
                    list.add(node.val);
                }

                queue.add(node.left);
                queue.add(node.right);
            }

            // 删除队列尾部的所有 null
            int last = list.size() - 1;
            while (last > 0 && list.get(last) == null) {
                last--;
            }
            return list.subList(0, last + 1);
        }

        /**
         * 判断两颗二叉树是否完全一致
         *
         * @param root1 二叉树根节点，类型：{@link BTree#root}
         * @param root2 二叉树根节点，类型：{@link BTree#root}
         * @param <T>   元素类型
         * @return true / false
         * @see <a href="https://leetcode-cn.com/problems/same-tree/">相同的树</a>
         */
        private static <T extends Comparable<T>> boolean isEquals(TreeNode<T> root1, TreeNode<T> root2) {
            if (root1 == null && root2 == null) { return true; }
            if (root1 == null || root2 == null) { return false; }
            if (!root1.val.equals(root2.val)) { return false; }
            return isEquals(root1.left, root2.left) && isEquals(root1.right, root2.right);
        }

        /**
         * 获取叶子节点
         *
         * @param root {@link TreeNode}
         * @param <T>  元素类型
         */
        public static <T extends Comparable<T>> List<T> getLeafNodes(TreeNode<T> root) {
            List<T> res = new ArrayList<>();
            getLeafNodes(root, res);
            return res;
        }

        /**
         * 获取叶子节点
         *
         * @param root  {@link TreeNode}
         * @param leafs [出参]叶子节点列表{@link List}
         * @param <T>   元素类型
         */
        private static <T extends Comparable<T>> void getLeafNodes(TreeNode<T> root, List<T> leafs) {
            if (root == null) { return; }
            if (root.left == null && root.right == null) { leafs.add(root.val); }
            getLeafNodes(root.left, leafs);
            getLeafNodes(root.right, leafs);
        }

        /**
         * 采用递归方法获取二叉树的最大深度
         *
         * @param root 二叉树根节点，类型：{@link BTree#root}
         * @return 二叉树的最大深度
         * @see <a href="https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/">二叉树的最大深度</a>
         */
        public static <T extends Comparable<T>> int maxDepth(TreeNode<T> root) {
            if (root == null) { return 0; }
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }

        /**
         * 采用递归方法获取二叉树的最小深度
         *
         * @param root 二叉树根节点，类型：{@link BTree#root}
         * @return 二叉树的最小深度
         * @see <a href="https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/">二叉树的最小深度</a>
         */
        public static <T extends Comparable<T>> int minDepth(TreeNode<T> root) {
            if (root == null) { return 0; }
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            if (left == 0 || right == 0) {
                return left + right + 1;
            }
            return Math.min(left, right) + 1;
        }

        /**
         * 将二叉树按层次遍历顺序转换为列表，即广度优先搜索（BFS）
         *
         * @return {@link List<List<T>>}
         * @see <a href="https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/">二叉树的层次遍历 II</a>
         */
        public static <T extends Comparable<T>> List<List<T>> levelOrderLists(TreeNode<T> root) {
            List<List<T>> lists = new ArrayList<>();
            if (root == null) { return lists; }
            Queue<TreeNode<T>> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<T> list = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode<T> node = queue.poll();
                    list.add(node.val);
                    if (node.left != null) { queue.offer(node.left); }
                    if (node.right != null) { queue.offer(node.right); }
                }
                lists.add(list);
            }
            return lists;
        }

    }

}
