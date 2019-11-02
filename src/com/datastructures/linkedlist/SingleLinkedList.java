package com.datastructures.linkedlist;

/**
 * Create with by IntelliJ IDEA
 *
 * @author: dragon
 * Date: 2019/11/2
 * Time: 10:34 下午
 **/

public class SingleLinkedList {
    /**
     * 先初始化一个头节点,头节点不要动,头节点如果发生变化就找不到链表了
     */
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    /**
     *     添加节点到单向链表
     *     思路:当不考虑编号顺序时
     *     1. 找到当前链表的最后节点
     *     2. 将最后这个节点的 next 指向新的节点
     *
     */
    public void add(HeroNode heroNode) {
        // 因为 head 节点不能动,因此我们需要一个辅助变量 temp
        HeroNode temp = head;
        // 遍历链表
        while (true) {
            // 找到链表的最后
            if (temp.next == null) {
                break;
            }
            // 如果没有找到最后,就将 temp 后移
            temp = temp.next;
        }
        // 当退出 while 循环式,temp 就指向了链表的最后
        temp.next = heroNode;
    }
    /**
     * 第二种添加节点到单链表,根据排名编号插入到指定位置
     * 如果存在这个排名,则添加失败
     */
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        // 标识添加编号是否存在,默认为 false
        boolean isNoExist = false;
        while (true) {
            // 说明 temp 已经在链表最后
            if (temp.next == null) {
                break;
            }
            // 位置找到了,就在 temp 的后面插入
            if (temp.next.no > heroNode.no) {
                break;
                // 说明希望添加的 heronode 的编号已经存在
            } else if (temp.next.no == heroNode.no) {
                isNoExist = true;
                break;
            }
            temp = temp.next;
        }
        // 判断 isNoExist,如果是 true 则不能添加,说明编号存在
        if (isNoExist) {
            System.out.printf("准备插入的英雄的编号 %d 已经存在了,不能加入\n", heroNode.no);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }
    /**
     * 显示链表
     */
    public void list() {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp.toString());
            temp = temp.next;
        }

    }
    /**
     * 修改节点的信息,根据编号来修改,编号不能修改
     * 说明:
     *    1. 根绝 newHeroNode 的 no 进行修改
     */
    public void updateNode(HeroNode newHeroNode) {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 找到需要修改的节点,根据 no 编号
        // 先定义一个辅助变量
        HeroNode temp = head.next;
        // 编号是否存在标识
        boolean isNoExist = false;
        while (true) {
            // 遍历完这个链表了
            if (temp == null) {
                break;
            }
            if (temp.no == newHeroNode.no) {
                // 找到
                isNoExist = true;
                break;
            }
            temp = temp.next;
        }
        // 根据 isNoExist 判断是否找到要修改的节点
        if (isNoExist) {
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        } else {
            System.out.printf("没有找到编号='%d'的节点\n", newHeroNode.no);
        }
    }

    /**
     * 删除节点,根据编号
     */
    public void deleteNode(int no) {
        if (head.next == null) {
            System.out.println("链表为空,无可删除");
            return;
        }
        HeroNode temp = head;
        boolean isNoExist = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                isNoExist = true;
                break;
            }
            temp = temp.next;
        }
        if (isNoExist) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("要删除的'%d'的节点不存在\n", no);
        }


    }
}
