# 链表

链表（Linked List）是一种常见的基础数据结构，是一种线性表，但是并不会按线性的顺序存储数据，而是在每一个节点里存到下一个节点的指针（Pointer）。

![img](http://dunwu.test.upcdn.net/snap/20200126095433.png)

由于不必须按顺序存储，链表在插入的时候可以达到 $$O(1)$$ 的复杂度，比另一种线性表 —— 顺序表快得多，但是查找一个节点或者访问特定编号的节点则需要 $$O(n)$$ 的时间，而顺序表相应的时间复杂度分别是 $$O(log N)$$ 和 $$O(1)$$。

使用链表结构可以克服数组链表需要预先知道数据大小的缺点，链表结构可以充分利用计算机内存空间，实现灵活的内存动态管理。但是链表失去了数组随机读取的优点，同时链表由于增加了结点的指针域，空间开销比较大。

在计算机科学中，链表作为一种基础的数据结构可以用来生成其它类型的数据结构。链表通常由一连串节点组成，每个节点包含任意的实例数据（data fields）和一或两个用来指向上一个/或下一个节点的位置的链接（links）。链表最明显的好处就是，常规数组排列关联项目的方式可能不同于这些数据项目在记忆体或磁盘上顺序，数据的访问往往要在不同的排列顺序中转换。而链表是一种自我指示数据类型，因为它包含指向另一个相同类型的数据的指针（链接）。

链表允许插入和移除表上任意位置上的节点，但是不允许随机存取。链表有很多种不同的类型：单向链表，双向链表以及循环链表。

链表通常可以衍生出循环链表，静态链表，双链表等。对于链表使用，需要注意头结点的使用。

## 单链表

单链表中的每个结点不仅包含数据值，还包含一个指针，指向其后继节点。通过这种方式，单链表将所有结点按顺序组织起来。

![img](http://dunwu.test.upcdn.net/snap/20200126095433.png)

与数组不同，我们无法在常量时间内访问单链表中的随机元素。 如果我们想要获得第 i 个元素，我们必须从头结点逐个遍历。 我们按 `索引` 来 `访问元素` 平均要花费 $$O(N)$$ 时间，其中 N 是链表的长度。

### 数据结构

```java
public class ListNode<E> {
    E value;
    ListNode<E> next; // 指向后继节点
}

public class SingleLinkList<E> {
    private ListNode<E> head; // 头节点
}
```

### 基本操作

#### 从头部添加节点

即头插法

```java
void addHead(E value) {
    ListNode<E> newNode = new ListNode<>(value, null);
    newNode.next = this.head.next;
    this.head.next = newNode;
}
```

#### 从尾部添加节点

即尾插法

```java
void addTail(E value) {
    // init new node
    ListNode<E> newNode = new ListNode<>(value, null);

    // find the last node
    ListNode<E> node = this.head;
    while (node.next != null) {
        node = node.next;
    }

    // add new node to tail
    node.next = newNode;
}
```

#### 删除节点

找到要删除元素的前驱节点，将前驱节点的 next 指针指向下一个节点。

```java
public void remove(E value) {
    ListNode<E> prev = this.head;
    while (prev.next != null) {
        ListNode<E> curr = prev.next;
        if (curr.value.equals(value)) {
            prev.next = curr.next;
            break;
        }
        prev = prev.next;
    }
}
```

#### 查找节点

从头开始查找，一旦发现有数值与查找值相等的节点，直接返回此节点。如果遍历结束，表明未找到节点，返回 null。

```java
public ListNode<E> find(E value) {
    ListNode<E> node = this.head.next;
    while (node != null) {
        if (node.value.equals(value)) {
            return node;
        }
        node = node.next;
    }
    return null;
}
```

## 双链表

双链表中的每个结点不仅包含数据值，还包含两个指针，分别指向指向其前驱节点和后继节点。

![img](http://dunwu.test.upcdn.net/snap/20200126095616.png)

双链表以类似的方式工作，但`还有一个引用字段`，称为`“prev”`字段。有了这个额外的字段，您就能够知道当前结点的前一个结点。

### 数据结构

```java
static class DListNode<E> {
    E value;
    DListNode<E> prev; // 指向前驱节点
    DListNode<E> next; // 指向后继节点
}

public class DoubleLinkList<E> {
    /** 头节点 */
    private DListNode<E> head;
    /** 尾节点 */
    private DListNode<E> tail;
}
```

### 基本操作

#### 从头部添加节点

```java
public void addHead(E value) {
    DListNode<E> newNode = new DListNode<>(null, value, null);

    this.head.next.prev = newNode;
    newNode.next = this.head.next;

    this.head.next = newNode;
    newNode.prev = this.head;
}
```

#### 从尾部添加节点

```java
public void addTail(E value) {
    DListNode<E> newNode = new DListNode<>(null, value, null);

    this.tail.prev.next = newNode;
    newNode.prev = this.tail.prev;

    this.tail.prev = newNode;
    newNode.next = this.tail;
}
```

#### 删除节点

```java
public void remove(E value) {
    DListNode<E> prev = this.head;
    while (prev.next != this.tail) {
        DListNode<E> curr = prev.next;
        if (curr.value.equals(value)) {
            prev.next = curr.next;
            curr.next.prev = prev;
            curr.next = null;
            curr.prev = null;
            break;
        }
        prev = prev.next;
    }
}
```

#### 查找节点

```java
public DListNode<E> find(E value) {
    DListNode<E> node = this.head.next;
    while (node != this.tail) {
        if (node.value.equals(value)) {
            return node;
        }
        node = node.next;
    }
    return null;
}
```

## 参考资料

- [数据结构（C语言版）](https://item.jd.com/12407475.html) -  [严蔚敏](https://book.jd.com/writer/严蔚敏_1.html)，[吴伟民](https://book.jd.com/writer/吴伟民_1.html)
- [数据结构：链表](https://www.jianshu.com/p/73d56c3d228c)
- [leetcode 链表题库](https://leetcode-cn.com/tag/linked-list/)

