(window.webpackJsonp=window.webpackJsonp||[]).push([[18],{373:function(t,_,v){"use strict";v.r(_);var a=v(14),s=Object(a.a)({},(function(){var t=this,_=t._self._c;return _("ContentSlotsDistributor",{attrs:{"slot-key":t.$parent.slotKey}},[_("h1",{attrs:{id:"跳表"}},[_("a",{staticClass:"header-anchor",attrs:{href:"#跳表"}},[t._v("#")]),t._v(" 跳表")]),t._v(" "),_("h2",{attrs:{id:"什么是跳表"}},[_("a",{staticClass:"header-anchor",attrs:{href:"#什么是跳表"}},[t._v("#")]),t._v(" 什么是跳表")]),t._v(" "),_("p",[t._v("对于一个有序数组，可以使用高效的二分查找法，其时间复杂度为 "),_("code",[t._v("O(log n)")]),t._v("。")]),t._v(" "),_("p",[t._v("但是，即使是有序的链表，也只能使用低效的顺序查找，其时间复杂度为 "),_("code",[t._v("O(n)")]),t._v("。")]),t._v(" "),_("p",[_("img",{attrs:{src:"https://raw.githubusercontent.com/dunwu/images/master/snap/20220323113532.png",alt:"img"}})]),t._v(" "),_("p",[t._v("如何提高链表的查找效率呢？")]),t._v(" "),_("p",[t._v("我们可以对链表加一层索引。具体来说，可以每两个结点提取一个结点到上一级，我们把抽出来的那一级叫作"),_("strong",[t._v("索引")]),t._v("或"),_("strong",[t._v("索引层")]),t._v("。索引节点中通过一个 down 指针，指向下一级结点。通过这样的改造，就可以支持类似二分查找的算法。我们把改造之后的数据结构叫作"),_("strong",[t._v("跳表")]),t._v("（Skip list）。")]),t._v(" "),_("p",[_("img",{attrs:{src:"https://raw.githubusercontent.com/dunwu/images/master/snap/20220323155309.png",alt:"img"}})]),t._v(" "),_("p",[t._v("随着数据的不断增长，一级索引层也变得越来越长。此时，我们可以为一级索引再增加一层索引层：二级索引层。")]),t._v(" "),_("p",[_("img",{attrs:{src:"https://raw.githubusercontent.com/dunwu/images/master/snap/20220323155346.png",alt:"img"}})]),t._v(" "),_("p",[t._v("随着数据的膨胀，当二级索引层也变得很长时，我们可以继续为其添加新的索引层。"),_("strong",[t._v("这种链表加多级索引的结构，就是跳表")]),t._v("。")]),t._v(" "),_("p",[_("img",{attrs:{src:"https://raw.githubusercontent.com/dunwu/images/master/snap/20220323114408.png",alt:"img"}})]),t._v(" "),_("h3",{attrs:{id:"跳表的时间复杂度"}},[_("a",{staticClass:"header-anchor",attrs:{href:"#跳表的时间复杂度"}},[t._v("#")]),t._v(" 跳表的时间复杂度")]),t._v(" "),_("p",[t._v("在一个具有多级索引的跳表中，第一级索引的结点个数大约就是 "),_("code",[t._v("n/2")]),t._v("，第二级索引的结点个数大约就是 "),_("code",[t._v("n/4")]),t._v("，第三级索引的结点个数大约就是 "),_("code",[t._v("n/8")]),t._v("，依次类推，也就是说，第 "),_("code",[t._v("k")]),t._v(" 级索引的结点个数是第 "),_("code",[t._v("k-1")]),t._v(" 级索引的结点个数的 "),_("code",[t._v("1/2")]),t._v("，那第 k 级索引结点的个数就是 "),_("code",[t._v("n/(2k)")]),t._v("。所以"),_("strong",[t._v("跳表查询数据的时间复杂度就是 "),_("code",[t._v("O(logn)")])]),t._v("。")]),t._v(" "),_("h3",{attrs:{id:"跳表的空间复杂度"}},[_("a",{staticClass:"header-anchor",attrs:{href:"#跳表的空间复杂度"}},[t._v("#")]),t._v(" 跳表的空间复杂度")]),t._v(" "),_("p",[t._v("比起单纯的单链表，跳表需要存储多级索引，肯定要消耗更多的存储空间。")]),t._v(" "),_("p",[t._v("假设原始链表大小为 n，那第一级索引大约有 n/2 个结点，第二级索引大约有 n/4 个结点，以此类推，每上升一级就减少一半，直到剩下 2 个结点。如果我们把每层索引的结点数写出来，就是一个等比数列。")]),t._v(" "),_("div",{staticClass:"language- extra-class"},[_("pre",{pre:!0,attrs:{class:"language-text"}},[_("code",[t._v("索引节点数 = n/2 + n/4 + n/8 … + 8 + 4 + 2 = n-2\n")])])]),_("p",[t._v("所以，跳表的空间复杂度是 "),_("code",[t._v("O(n)")]),t._v("。")]),t._v(" "),_("p",[t._v("跳表的存储空间其实还有压缩空间。比如，我们增加索引节点的范围，由『每两个节点抽一个上级索引节点』改为『每五个节点抽一个上级索引节点』，可以显著节省存储空间。")]),t._v(" "),_("p",[t._v("实际上，在软件开发中，我们不必太在意索引占用的额外空间。在讲数据结构和算法时，我们习惯性地把要处理的数据看成整数，但是在实际的软件开发中，原始链表中存储的有可能是很大的对象，而索引结点只需要存储关键值和几个指针，并不需要存储对象，所以当对象比索引结点大很多时，那索引占用的额外空间就可以忽略了。")]),t._v(" "),_("h2",{attrs:{id:"跳表的操作"}},[_("a",{staticClass:"header-anchor",attrs:{href:"#跳表的操作"}},[t._v("#")]),t._v(" 跳表的操作")]),t._v(" "),_("p",[t._v("跳表是一种各方面性能都比较优秀的"),_("strong",[t._v("动态数据结构")]),t._v("，可以支持快速的插入、删除、查找操作，写起来也不复杂，甚至可以替代"),_("a",{attrs:{href:"https://zh.wikipedia.org/wiki/%E7%BA%A2%E9%BB%91%E6%A0%91",target:"_blank",rel:"noopener noreferrer"}},[t._v("红黑树"),_("OutboundLink")],1),t._v("（Red-black tree）。")]),t._v(" "),_("h3",{attrs:{id:"高效的动态插入和删除"}},[_("a",{staticClass:"header-anchor",attrs:{href:"#高效的动态插入和删除"}},[t._v("#")]),t._v(" 高效的动态插入和删除")]),t._v(" "),_("p",[t._v("跳表不仅支持查找操作，还支持动态的插入、删除操作，而且插入、删除操作的时间复杂度也是 "),_("code",[t._v("O(logn)")]),t._v("。")]),t._v(" "),_("p",[_("img",{attrs:{src:"https://raw.githubusercontent.com/dunwu/images/master/snap/20220323155933.png",alt:"img"}})]),t._v(" "),_("ul",[_("li",[_("strong",[t._v("插入操作")]),t._v("：对于纯粹的单链表，需要遍历每个结点，来找到插入的位置。但是，对于跳表来说，我们讲过查找某个结点的的时间复杂度是 "),_("code",[t._v("O(log n)")]),t._v("，所以这里查找某个数据应该插入的位置，方法也是类似的，时间复杂度也是 "),_("code",[t._v("O(log n)")]),t._v("。")]),t._v(" "),_("li",[_("strong",[t._v("删除操作")]),t._v("：如果这个结点在索引中也有出现，我们除了要删除原始链表中的结点，还要删除索引中的。因为单链表中的删除操作需要拿到要删除结点的前驱结点，然后通过指针操作完成删除。所以在查找要删除的结点的时候，一定要获取前驱结点。当然，如果我们用的是双向链表，就不需要考虑这个问题了。")])]),t._v(" "),_("h3",{attrs:{id:"跳表索引动态更新"}},[_("a",{staticClass:"header-anchor",attrs:{href:"#跳表索引动态更新"}},[t._v("#")]),t._v(" 跳表索引动态更新")]),t._v(" "),_("p",[t._v("当我们不停地往跳表中插入数据时，如果我们不更新索引，就有可能出现某 2 个索引结点之间数据非常多的情况。极端情况下，跳表还会退化成单链表。")]),t._v(" "),_("p",[_("img",{attrs:{src:"https://raw.githubusercontent.com/dunwu/images/master/snap/20220323161942.png",alt:"img"}})]),t._v(" "),_("p",[t._v("如红黑树、AVL 树这样的平衡二叉树，是通过左右旋的方式保持左右子树的大小平衡，而跳表是通过随机函数来维护前面提到的“平衡性”。")]),t._v(" "),_("p",[t._v("当我们往跳表中插入数据的时候，我们可以选择同时将这个数据插入到部分索引层中。如何选择加入哪些索引层呢？可以通过一个随机函数，来决定将这个结点插入到哪几级索引中，比如随机函数生成了值 K，那我们就将这个结点添加到第一级到第 K 级这 K 级索引中。")]),t._v(" "),_("h2",{attrs:{id:"为什么需要跳表"}},[_("a",{staticClass:"header-anchor",attrs:{href:"#为什么需要跳表"}},[t._v("#")]),t._v(" 为什么需要跳表")]),t._v(" "),_("p",[t._v("跳表是一种动态数据结构，支持快速的插入、删除、查找操作，时间复杂度都是 "),_("code",[t._v("O(logn)")]),t._v("。")]),t._v(" "),_("p",[t._v("跳表的空间复杂度是 "),_("code",[t._v("O(n)")]),t._v("。不过，跳表的实现非常灵活，可以通过改变索引构建策略，有效平衡执行效率和内存消耗。虽然跳表的代码实现并不简单，但是作为一种动态数据结构，比起红黑树来说，实现要简单多了。所以很多时候，我们为了代码的简单、易读，比起红黑树，我们更倾向用跳表。")]),t._v(" "),_("h2",{attrs:{id:"跳表的应用场景"}},[_("a",{staticClass:"header-anchor",attrs:{href:"#跳表的应用场景"}},[t._v("#")]),t._v(" 跳表的应用场景")]),t._v(" "),_("p",[t._v("经典实现：Redis 的 Sorted Set、JDK 的 "),_("code",[t._v("ConcurrentSkipListMap")]),t._v(" 和 "),_("code",[t._v("ConcurrentSkipListSet")]),t._v(" 都是基于跳表实现。")]),t._v(" "),_("p",[t._v("为什么 Redis 要用跳表来实现有序集合，而不是红黑树？")]),t._v(" "),_("p",[t._v("Redis 中的有序集合支持的核心操作主要有下面这几个：")]),t._v(" "),_("ul",[_("li",[t._v("插入一个数据；")]),t._v(" "),_("li",[t._v("删除一个数据；")]),t._v(" "),_("li",[t._v("查找一个数据；")]),t._v(" "),_("li",[t._v("按照区间查找数据（比如查找值在 [100, 356] 之间的数据）；")]),t._v(" "),_("li",[t._v("迭代输出有序序列。")])]),t._v(" "),_("p",[t._v("其中，插入、删除、查找以及迭代输出有序序列这几个操作，红黑树也可以完成，时间复杂度跟跳表是一样的。但是，按照区间来查找数据这个操作，红黑树的效率没有跳表高。")]),t._v(" "),_("h2",{attrs:{id:"参考资料"}},[_("a",{staticClass:"header-anchor",attrs:{href:"#参考资料"}},[t._v("#")]),t._v(" 参考资料")]),t._v(" "),_("ul",[_("li",[_("a",{attrs:{href:"https://time.geekbang.org/column/intro/100017301",target:"_blank",rel:"noopener noreferrer"}},[t._v("数据结构与算法之美"),_("OutboundLink")],1)])])])}),[],!1,null,null,null);_.default=s.exports}}]);