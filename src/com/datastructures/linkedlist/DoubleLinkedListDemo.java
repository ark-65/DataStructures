package com.datastructures.linkedlist;

/**
 * Create with by IntelliJ IDEA
 *
 * @author: dragon
 * Date: 2019/11/3
 * Time: 1:46 下午
 **/

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        System.out.println("双向链表的测试");
        // 先创建节点
//        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        // 创建一个双线链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
//        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);
        System.out.println("显示链表");
        doubleLinkedList.list();

        // 修改测试
        HeroNode2 newHeroNode = new HeroNode2(4, "公孙胜", "入云龙");
        doubleLinkedList.updateNode(newHeroNode);
        System.out.println("修改后的链表情况");
        doubleLinkedList.list();

        // 删除测试
        System.out.println("删除测试");
        doubleLinkedList.deleteNode(4);
        doubleLinkedList.list();

        // 测试按照顺序插入
        System.out.println("测试按照编号顺序插入");
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero5 = new HeroNode2(4, "林冲", "豹子头");
        doubleLinkedList.addByOrder(hero1);
        doubleLinkedList.list();
        System.out.println("再次插入");
        doubleLinkedList.addByOrder(hero5);
        doubleLinkedList.list();
    }
}
