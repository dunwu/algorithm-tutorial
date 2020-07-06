# 数据结构 - 树

## 一、树的简介

在计算机科学中，**树**（英语：tree）是一种[抽象数据类型](https://zh.wikipedia.org/wiki/抽象資料型別)（ADT）或是实现这种抽象数据类型的[数据结构](https://zh.wikipedia.org/wiki/資料結構)，用来模拟具[有树状结构](https://zh.wikipedia.org/wiki/樹狀結構)性质的数据集合。它是由 n（n>0）个有限节点组成一个具有层次关系的[集合](https://zh.wikipedia.org/wiki/集合)。把它叫做“树”是因为它看起来像一棵倒挂的树，也就是说它是根朝上，而叶朝下的。

它具有以下的特点：

- 每个节点都只有有限个子节点或无子节点。
- 树有且仅有一个根节点。
- 根节点没有父节点；非根节点有且仅有一个父节点。
- 每个非根节点可以分为多个不相交的子树。
- 树里面没有环路。

### 树的术语

- **节点的度**：一个节点含有的子树的个数称为该节点的度；
- **树的度**：一棵树中，最大的节点度称为树的度；
- **叶子节点**或**终端节点**：度为零的节点；
- **非终端节点**或**分支节点**：度不为零的节点；
- **父节点**：若一个节点含有子节点，则这个节点称为其子节点的父节点；
- **子节点**：一个节点含有的子树的根节点称为该节点的子节点；
- **兄弟节点**：具有相同父节点的节点互称为兄弟节点；
- 节点的**层次**：从根开始定义起，根为第 1 层，根的子节点为第 2 层，以此类推；
- **深度**：对于任意节点 n,n 的深度为从根到 n 的唯一路径长，根的深度为 0；
- **高度**：对于任意节点 n,n 的高度为从 n 到一片树叶的最长路径长，所有树叶的高度为 0；
- **堂兄弟节点**：父节点在同一层的节点互为堂兄弟；
- **节点的祖先**：从根到该节点所经分支上的所有节点；
- **子孙**：以某节点为根的子树中任一节点都称为该节点的子孙。
- **森林**：由 m（m>=0）棵互不相交的树的集合称为森林；

### 树的性质

- 树中的节点数等于所有节点的度数加 1。
- 度为 m 的树中第 i 层上至多有 $$m^{i-1}$$ 个节点（$$i ≥ 1$$）。
- 高度为 h 的 m 次树至多有 $$(m^h-1)/(m-1)$$ 个节点。
- 具有 n 个节点的 m 次树的最小高度为 $$\log_m{(n(m-1)+1)}$$ 。

### 树的种类

**无序树**：树中任意节点的子节点之间没有顺序关系，这种树称为无序树，也称为[自由树](https://zh.wikipedia.org/wiki/自由树)；

**有序树**：树中任意节点的子节点之间有顺序关系，这种树称为有序树；

- 二叉树：每个节点最多含有两个子树的树称为二叉树；
  - **完全二叉树**：对于一颗二叉树，假设其深度为 d（d>1）。除了第 d 层外，其它各层的节点数目均已达最大值，且第 d 层所有节点从左向右连续地紧密排列，这样的二叉树被称为完全二叉树；
- [满二叉树](https://zh.wikipedia.org/wiki/满二叉树)：所有叶节点都在最底层的完全二叉树；
- [平衡二叉树](https://zh.wikipedia.org/wiki/平衡二叉树)（[AVL 树](https://zh.wikipedia.org/wiki/AVL树)）：当且仅当任何节点的两棵子树的高度差不大于 1 的二叉树；
- [排序二叉树](https://zh.wikipedia.org/wiki/排序二元樹)([二叉查找树](https://zh.wikipedia.org/wiki/二叉查找树)（英语：Binary Search Tree))：也称二叉搜索树、有序二叉树；
- [霍夫曼树](https://zh.wikipedia.org/wiki/霍夫曼树)：[带权路径](https://zh.wikipedia.org/w/index.php?title=带权路径&action=edit&redlink=1)最短的二叉树称为哈夫曼树或最优二叉树；
- [B 树](https://zh.wikipedia.org/wiki/B树)：一种对读写操作进行优化的自平衡的二叉查找树，能够保持数据有序，拥有多于两个子树。

### 二叉树

二叉树是 N 个节点的有限集合，它或者是空树，或者是由一个根节点及两棵不想交的且分别称为左右子树的二叉树所组成。

#### 二叉树的性质

1. 二叉树第 i 层上的结点数目最多为 **2<sup>i-1</sup>** (i≥1)。
2. 深度为 k 的二叉树至多有 **2<sup>k</sup>-1** 个结点(k≥1)。
3. 包含 n 个结点的二叉树的高度至少为 **log<sub>2</sub>(n+1)**。
4. 在任意一棵二叉树中，若终端结点的个数为 n0，度为 2 的结点数为 n2，则 n0=n2+1。

#### 满二叉树

定义：高度为 h，并且由 **2<sup>h</sup>–1** 个结点的二叉树，被称为满二叉树。

![img](http://dunwu.test.upcdn.net/cs/data-structure/tree/满二叉树.png)

#### 完全二叉树

定义：一棵二叉树中，只有最下面两层结点的度可以小于 2，并且最下一层的叶结点集中在靠左的若干位置上。这样的二叉树称为完全二叉树。

特点：叶子结点只能出现在最下层和次下层，且最下层的叶子结点集中在树的左部。显然，一棵满二叉树必定是一棵完全二叉树，而完全二叉树未必是满二叉树。

![img](http://dunwu.test.upcdn.net/cs/data-structure/tree/完全二叉树.png)

## 二、算法要点

## 三、练习

### 二叉树经典题

#### 深度优先搜索（DFS）

在这个策略中，我们采用 深度 作为优先级，以便从跟开始一直到达某个确定的叶子，然后再返回到达另一个分支。深度优先搜索策略又可以根据根节点、左孩子和右孩子的相对顺序被细分为**先序遍历**，**中序遍历**和**后序遍历**。

- [二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal)
- [二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal)
- [二叉树的后序遍历](https://leetcode-cn.com/problems/binary-tree-postorder-traversal)

#### 宽度优先搜索（BFS）

我们按照高度顺序一层一层的访问整棵树，高层次的节点将会比低层次的节点先被访问到。

- [二叉树的层序遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal)

#### 二叉树和递归

- [二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree)
- [对称二叉树](https://leetcode-cn.com/problems/symmetric-tree)
- [路径总和](https://leetcode-cn.com/problems/path-sum)

#### 其他

- [ ] [maximum-depth-of-binary-tree](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/)
- [ ] [balanced-binary-tree](https://leetcode-cn.com/problems/balanced-binary-tree/)
- [ ] [binary-tree-maximum-path-sum](https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/)
- [ ] [lowest-common-ancestor-of-a-binary-tree](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/)
- [ ] [binary-tree-level-order-traversal](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)
- [ ] [binary-tree-level-order-traversal-ii](https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/)
- [ ] [binary-tree-zigzag-level-order-traversal](https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/)
- [ ] [validate-binary-search-tree](https://leetcode-cn.com/problems/validate-binary-search-tree/)
- [ ] [insert-into-a-binary-search-tree](https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/)

### 二叉搜索树经典题

- [ ] [validate-binary-search-tree](https://leetcode-cn.com/problems/validate-binary-search-tree/)
- [ ] [insert-into-a-binary-search-tree](https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/)
- [ ] [delete-node-in-a-bst](https://leetcode-cn.com/problems/delete-node-in-a-bst/)
- [ ] [balanced-binary-tree](https://leetcode-cn.com/problems/balanced-binary-tree/)

## 参考资料

- [https://zh.wikipedia.org/wiki/树\_(数据结构)](<https://zh.wikipedia.org/wiki/树_(数据结构)>)
