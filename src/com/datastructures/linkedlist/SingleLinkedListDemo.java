package com.datastructures.linkedlist;

/**
 * Create with by IntelliJ IDEA
 *
 * @author: dragon
 * Date: 2019/11/2
 * Time: 10:59 下午
 **/

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        // 进行测试
        // 先创建一个节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        // 创建一个链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        // 加入
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
        System.out.println("修改前");
        singleLinkedList.list();

        // 测试修改节点的方法
        HeroNode hero5 = new HeroNode(2, "小卢", "玉麒麟~~");
        singleLinkedList.updateNode(hero5);
        System.out.println("修改后");
        // 显示
        singleLinkedList.list();

        // 测试一下 求单链表中有效节点的个数
        System.out.println("有效节点的个数=" + getLength(singleLinkedList.getHead()));

        // 测试一下,是否得到了倒数第 k 个节点
        HeroNode res = findLastIndexNode(singleLinkedList.getHead(), 2);
        System.out.println("res=" + res);

        // 测试一下,第三题,反转单链表
        System.out.println("原始链表~~~");
        singleLinkedList.list();
        System.out.println("反转单链表后");
        reverseList(singleLinkedList.getHead());
        singleLinkedList.list();
        /*
        // 测试删除节点
        singleLinkedList.deleteNode(1);
        singleLinkedList.deleteNode(4);
        singleLinkedList.deleteNode(2);
        singleLinkedList.deleteNode(3);
        System.out.println("删除后链表情况");
        singleLinkedList.list();
        */

    }

    // 测试题 1.获取单链表有效节点个数
    // 方法: 获取到单链表的节点的个数(如果是带头节点的链表,需求不统计头节点)

    /**
     *
     * @param head 链表的头节点
     * @return 返回的就是有效节点的个数
     */
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int lenght = 0;
        // 顶一个辅助的变量, 这里没有统计头节点
        HeroNode cur = head.next;
        while (cur != null) {
            lenght++;
            cur = cur.next;
        }
        return lenght;
    }

    // 测试题 2 查找单链表中的倒数第 k 个节点
    // 思路:
    // 1. 编写一个方法,接收 head 节点,同事接收一个 index
    // 2. index 标识倒数第 index 个节点
    // 3. 先把链表从头到尾遍历,得到链表的总的长度 getLength
    // 4. 得到 size 后,我们从链表的第一个开始遍历(size-index)个.就可以得到
    // 5. 如果找到了,则返回该节点,如果找不到返回一个 null
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        // 判断如果链表为空,返回 null
        if (head.next == null) {
            return null;
        }
        // 第一次遍历得到链表的长度
        int size = getLength(head);
        // 第二次遍历  size-index 位置,就是倒数第 k 个节点
        // 先做一个 index 校验
        if (index <= 0 || index > size) {
            return null;
        }
        // 定义一个辅助变量, for 循环定位到倒数的 index
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    // 测试题 3 将单链表反转
    public static void reverseList(HeroNode head) {
        // 如果当前链表为空,或者只有一个节点,无需反转,直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }
        // 定义一个辅助的指针(变量),帮助我们遍历原来的链表
        HeroNode cur = head.next;
        // 指向当前节点[cur]的下一个节点
        HeroNode next = null;

        HeroNode reverseHead = new HeroNode(0, "", "");
        // 遍历原来的链表
        // 并从头到尾遍历原来的链表,每遍历一个节点,就将其取出,并放在新的链表的最前端
        while (cur != null) {
            // 先暂时保存当前节点的下一个节点,因为后面需要使用
            next = cur.next;
            // 将 cur 的下一个节点指向新的链表的最前端
            cur.next = reverseHead.next;
            // 将 cur 连接到新的链表上
            reverseHead.next = cur;
            // 让 cur 后移
            cur = next;
        }
        // 将 head.next 指向 reverseHead.next, 实现单链表的反转
        head.next = reverseHead.next;
    }

}
