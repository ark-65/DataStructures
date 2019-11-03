package com.datastructures.linkedlist;

/**
 * Create with by IntelliJ IDEA
 *
 * @author: dragon
 * Date: 2019/11/3
 * Time: 11:24 上午
 **/

import java.util.Stack;

/**
 * 用来掩饰 Stack 的基本使用
 */
public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        // 入栈
        stack.add("Jack");
        stack.add("Tom");
        stack.add("Smith");

        // 出栈
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }
}
