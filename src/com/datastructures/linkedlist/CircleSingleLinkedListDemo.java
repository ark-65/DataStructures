package com.datastructures.linkedlist;

/**
 * Create with by IntelliJ IDEA
 *
 * @author: dragon
 * Date: 2019/11/3
 * Time: 4:02 下午
 **/

public class CircleSingleLinkedListDemo {
    public static void main(String[] args) {
        //
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();

        circleSingleLinkedList.addBoy(25);
        circleSingleLinkedList.showBoy();

        // 测试小孩出圈是否正确
        circleSingleLinkedList.countBoy(1, 2, 25);

    }
}
