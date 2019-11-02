## 链表

- SingleLinkedList : 单链表

- 测试题

  -  求单链表中有效节点的个数  getLength
  -  查找单链表中的倒数第 k 个节点  findLastIndexNode
  -  单链表的反转 
    ```
  思路:
  1. 先定义一个节点 reverseHead = new HeroNode();
  2. 从头到尾遍历原来的链表,每遍历一个节点,就将其取出,并放在新的链表的最前端
  3. 原来的链表的 head.next = reverseHead.next
    ```
  -  从尾到头打印单链表
  -  合并两个有序的单链表,合并之后的链表依然有序