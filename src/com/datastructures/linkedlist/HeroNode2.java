package com.datastructures.linkedlist;

/**
 * Create with by IntelliJ IDEA
 *
 * @author: dragon
 * Date: 2019/11/3
 * Time: 1:24 下午
 **/

public class HeroNode2 {
    public int no;
    public String name;
    public String nickName;
    /**
     * 指向下一个节点
     */
    public HeroNode2 next;
    /**
     * 指向前一个节点,默认为 null
     */
    public HeroNode2 pre;
    // 构造器

    /**
     * @param hNo 编号
     * @param hName 名称
     * @param nickName 昵称
     */
    public HeroNode2(int hNo, String hName, String nickName) {
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
