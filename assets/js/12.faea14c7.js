(window.webpackJsonp=window.webpackJsonp||[]).push([[12],{366:function(t,a,v){"use strict";v.r(a);var _=v(14),r=Object(_.a)({},(function(){var t=this,a=t._self._c;return a("ContentSlotsDistributor",{attrs:{"slot-key":t.$parent.slotKey}},[a("h1",{attrs:{id:"堆"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#堆"}},[t._v("#")]),t._v(" 堆")]),t._v(" "),a("h2",{attrs:{id:"什么是堆"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#什么是堆"}},[t._v("#")]),t._v(" 什么是堆？")]),t._v(" "),a("p",[t._v("堆（Heap）是一个可以被看成近似完全二叉树的数组。")]),t._v(" "),a("ul",[a("li",[a("strong",[t._v("堆是一个完全二叉树")]),t._v("。完全二叉树要求，除了最后一层，其他层的节点个数都是满的，最后一层的节点都靠左排列。")]),t._v(" "),a("li",[a("strong",[t._v("堆中每一个节点的值都必须大于等于（或小于等于）其子树中每个节点的值")]),t._v("。")])]),t._v(" "),a("p",[t._v("堆可以分为大顶堆和小顶堆。")]),t._v(" "),a("ul",[a("li",[a("p",[t._v("对于每个节点的值都大于等于子树中每个节点值的堆，叫作“"),a("strong",[t._v("大顶堆")]),t._v("”。")])]),t._v(" "),a("li",[a("p",[t._v("对于每个节点的值都小于等于子树中每个节点值的堆，叫作“"),a("strong",[t._v("小顶堆")]),t._v("”。")])])]),t._v(" "),a("h2",{attrs:{id:"如何实现堆"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#如何实现堆"}},[t._v("#")]),t._v(" 如何实现堆")]),t._v(" "),a("p",[t._v("完全二叉树比较适合用数组来存储。用数组来存储完全二叉树是非常节省存储空间的。因为我们不需要存储左右子节点的指针，单纯地通过数组的下标，就可以找到一个节点的左右子节点和父节点。")]),t._v(" "),a("p",[a("img",{attrs:{src:"https://raw.githubusercontent.com/dunwu/images/master/snap/20220311112542.jpg",alt:"img"}})]),t._v(" "),a("p",[t._v("堆常见的操作：")]),t._v(" "),a("ul",[a("li",[t._v("HEAPIFY 建堆：把一个乱序的数组变成堆结构的数组，时间复杂度为 $$O(n)$$。")]),t._v(" "),a("li",[t._v("HEAPPUSH：把一个数值放进已经是堆结构的数组中，并保持堆结构，时间复杂度为 $$O(log N)$$")]),t._v(" "),a("li",[t._v("HEAPPOP：从最大堆中取出最大值或从最小堆中取出最小值，并将剩余的数组保持堆结构，时间复杂度为 $$O(log N)$$。")]),t._v(" "),a("li",[t._v("HEAPSORT：借由 HEAPFY 建堆和 HEAPPOP 堆数组进行排序，时间复杂度为$$ O(N log N)$$，空间复杂度为 $$O(1)$$。")])]),t._v(" "),a("h2",{attrs:{id:"堆的应用场景"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#堆的应用场景"}},[t._v("#")]),t._v(" 堆的应用场景")]),t._v(" "),a("h3",{attrs:{id:"求-top-n"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#求-top-n"}},[t._v("#")]),t._v(" 求 TOP N")]),t._v(" "),a("p",[t._v("堆结构的一个常见应用是建立优先队列（Priority Queue）。")]),t._v(" "),a("p",[t._v("求 Top K 的问题抽象成两类。一类是针对静态数据集合；另一类是针对动态数据集合")]),t._v(" "),a("h3",{attrs:{id:"优先级队列"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#优先级队列"}},[t._v("#")]),t._v(" 优先级队列")]),t._v(" "),a("p",[t._v("在优先级队列中，数据的出队顺序不是先进先出，而是按照优先级来，优先级最高的，最先出队。")]),t._v(" "),a("p",[t._v("堆和优先级队列非常相似：往优先级队列中插入一个元素，就相当于往堆中插入一个元素；从优先级队列中取出优先级最高的元素，就相当于取出堆顶元素。")]),t._v(" "),a("blockquote",[a("p",[t._v("参考：Java 的 "),a("code",[t._v("PriorityQueue")]),t._v(" 类")])]),t._v(" "),a("h3",{attrs:{id:"求中位数"}},[a("a",{staticClass:"header-anchor",attrs:{href:"#求中位数"}},[t._v("#")]),t._v(" 求中位数")])])}),[],!1,null,null,null);a.default=r.exports}}]);