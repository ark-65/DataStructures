package com.datastructures.linkedlist;

/**
 * Create with by IntelliJ IDEA
 *
 * @author: dragon
 * Date: 2019/11/3
 * Time: 3:07 下午
 **/

/**
 * 创建环形单向链表
 */
public class CircleSingleLinkedList {
    /**
     * 创建一个 first 节点,当前没有编号
     */
    private Boy first = null;

    /**
     * 添加小孩节点,构建成一个环形的链表
     * @param nums 创建节点总数
     */
    public void addBoy(int nums) {
        // nums 做一个数据校验
        if (nums < 1) {
            System.out.println("nums 的值不正确");
            return;
        }
        // 辅助指针,帮助我们构建环形链表
        Boy curBoy = null;
        // 使用 for 循环创建环形链表
        for (int i = 1; i <= nums; i++) {
            // 根据编号创建小孩节点
            Boy boy = new Boy(i);
            // 如果是第一个小孩
            if (i == 1) {
                first = boy;
                // 构成环
                first.setNext(first);
                // 让 curBoy 指向第一个小孩
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    // 遍历当前的环形链表
    public void showBoy() {
        // 先判断链表是否为空
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        // 因为 first 不能动,因此仍然使用辅助指针,完成遍历
        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩的编号%d\n", curBoy.getNo());
            // 已经遍历完毕
            if (curBoy.getNext() == first) {
                break;
            }
            // curBoy后移
            curBoy = curBoy.getNext();
        }
    }

    /**
     *
     * @param startNo 表示从第几个小孩开始数数
     * @param countNum  表示数几下
     * @param nums  表示最初有多少小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {
        // 先对数据进行校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误,请重新输入");
            return;
        }
        // 创建一个辅助指针,帮助完成小孩出圈
        Boy helper = first;
        // 需求创建一个辅助指针(变量) helper,事先应该指向环形链表的最后这个节点

        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        // 小孩报数前,先让 first 和 helper 移动 k-1 次
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        // 当小孩报数时,让 first 和 helper 指针同事的移动 m-1 次,然后出圈
        // 这里是一个循环操作,直到圈中只有一个节点
        while (true) {
            // 说明圈中只有一个节点
            if (helper == first) {
                break;
            }
            // 让 first 和 helper 同时移动 countNum -1 次
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            // 这时,first 指向的这个节点,就是要出圈的小孩节点
            System.out.printf("小孩%d 出圈\n",first.getNo());
            // 这时将 first 指向小孩的节点出圈
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号 %d \n",first.getNo());
    }
}
