package com.datastructures.linkedlist;

/**
 * Create with by IntelliJ IDEA
 *
 * @author: dragon
 * Date: 2019/11/3
 * Time: 1:23 下午
 **/

public class DoubleLinkedList {
    /**
     * 先初始化一个头节点,头节点不要动,头节点如果发生变化就找不到链表了
     */
    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
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
        HeroNode2 temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp.toString());
            temp = temp.next;
        }

    }
    /**
     * 添加一个节点到双向链表的最后
     */
    public void add(HeroNode2 heroNode) {
        // 因为 head 节点不能动,因此我们需要一个辅助变量 temp
        HeroNode2 temp = head;
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
        // 形成一个双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    /**
     * 添加节点   按照顺序
     */
    public void addByOrder(HeroNode2 heroNode2) {
        HeroNode2 temp = head;
        boolean isNoExist = false;

        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode2.no) {
                break;
            } else if (temp.next.no == heroNode2.no) {
                isNoExist = true;
                break;
            }
            temp = temp.next;
        }
        if (isNoExist) {
            System.out.printf("准备插入的英雄的编号 %d 已经存在了,不能加入\n", heroNode2.no);
        } else {
            heroNode2.next = temp.next;
            temp.next = heroNode2;
            heroNode2.pre = temp;
        }
    }
    /**
     * 修改一个节点的内容,和单向链表思路一样
     */
    public void updateNode(HeroNode2 newHeroNode) {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 找到需要修改的节点,根据 no 编号
        // 先定义一个辅助变量
        HeroNode2 temp = head.next;
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
     * 从双向链表中删除节点,根据编号
     * 1.对于双向链表,我们可以直接找到要删除的这个节点
     * 2. 找到后,自我删除
     */
    public void deleteNode(int no) {

        // 判断当前链表是否为空
        if (head.next == null) {
            System.out.println("链表为空,无可删除");
            return;
        }
        // 辅助指针
        HeroNode2 temp = head.next;
        // 标识是否找到了待删除的节点
        boolean isNoExist = false;
        while (true) {
            // 已经找到链表最后
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                isNoExist = true;
                break;
            }
            temp = temp.next;
        }
        if (isNoExist) {
//            temp.next = temp.next.next;[单向链表]
            temp.pre.next = temp.next;
            // 如果是最后一个节点就不需要执行下面这句话,否则会出现空指针异常
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("要删除的'%d'的节点不存在\n", no);
        }


    }

}
