package com.datastructures.queue;

/**
 * Create with by IntelliJ IDEA
 *
 * @author: dragon
 * Date: 2019/11/2
 * Time: 1:08 上午
 **/

public class CircleArray {
    /**
     * 表示数组的最大容量
     */
    private int maxSize;
    /**
     * 队列头
     * front 变量的含义,环形队列中,front 就指向队列的第一个元素,也就是说 arr[front]
     * front 的初始值 = 0
     */
    private int front;
    /**
     * 队列尾
     * rear 变量的含义,环形队列中,rear 就指向队列的最优一个元素的后一个位置,因为希望空出一个位置存放新的数据
     */
    private int rear;
    /**
     * 该数据用于存放数据,模拟队列
     */
    private int[] arr;
    /**
     * 创建队列的构造器
     */
    public CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }
    /**
     * 判断队列是否已满
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }
    /**
     * 判断队列是否为空
     */
    public boolean isEmpty() {
        return rear == front;
    }
    /**
     * 添加数据到队列
     */
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满,不能加入数据");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }
    /**
     * 获取队列的数据,出队列
     */
    public int getQueue() {
        // 判断队列是否为空
        if (isEmpty()) {
            // 通过抛出异常处理
            throw new RuntimeException("队列空,不能取数据");
        }
        // 这里需要分析出 front 是指向队列的第一个元素
        // 1. 先把 front 的对应的值保存到一个临时变量
        // 2. 将 front 后移,考虑取模
        // 3. 将临时保存的变量返回
        int val = arr[front];
        front = (front + 1) % maxSize;
        return val;
    }
    /**
     * 显示队列的所有数据
     */
    public void showQueue() {
        // 遍历
        if (isEmpty()) {
            System.out.println("队列空的,没有数据");
            return;
        }
        // 从 front 开始遍历,遍历多少个元素
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i%maxSize, arr[i%maxSize]);
        }
    }
    /**
     * 求出当前队列有效数据的个数,否则无法遍历
     */
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }
    /**
     * 显示队列的头数据,不是取出数据
     */
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空的,没有数据");
        }
        return arr[front];

    }
}









