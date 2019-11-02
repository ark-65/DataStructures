package com.datastructures.linkedlist;

import org.jetbrains.annotations.Contract;

/**
 * Create with by IntelliJ IDEA
 *
 * @author: dragon
 * Date: 2019/11/2
 * Time: 10:36 下午
 **/

public class HeroNode {
    public int no;
    public String name;
    public String nickName;
    /**
     * 指向下一个节点
     */
    public HeroNode next;
    // 构造器

    /**
     * @param hNo 编号
     * @param hName 名称
     * @param nickName 昵称
     */
    @Contract(pure = true)
    public HeroNode(int hNo, String hName, String nickName) {
        this.no = hNo;
        this.name = hName;
        this.nickName = nickName;
    }
    // 为了显示方便,重写 toString


    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
//                ", next=" + next +
                '}';
    }
}
