package com.atguigu.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {

    public static void main(String[] args) {
        // 测试数组
        //创建一个环形队列
        CircleArray queue = new CircleArray(4);
        //接收用户输入
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        // 输出一个菜单
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出队列");
            System.out.println("h(head):查看队列头的数据");
            //接收字符
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数字");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;

                default:
                    break;
            }
        }
        System.out.println("程序退出~~");
    }

}

class CircleArray {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        //front rear 默认为0
    }

    /**
     * 判断队列是否满
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
     * 入队
     */
    public void addQueue(int n) {
        // 判断队列是否为满
        if (isFull()) {
            System.out.println("队列满，不能加入数据~~");
            return;
        }
        //  直接将数据加入
        arr[rear] = n;
        // 将rear后移，这里必须取模
        rear = (rear + 1) % maxSize;
    }

    /**
     * 出队
     */
    public int getQueue() {
        // 判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        }
        // 这里分析出front是指向队列的第一个元素
        // 1. 先把front对应的值保存到临时变量
        // 2. 将front后移,考虑取模，避免数组越界
        // 3. 将临时保存的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    /**
     * 显示队列所有的数据
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据~~");
            return;
        }
        // 思路：从front开始遍历，遍历多少个元素
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    /**
     * 求出队列中有效数据的个数
     */
    public int size() {
        return (rear - front + maxSize) % maxSize;
    }

    /**
     * 显示队列的头数据，注意不是取数据
     */
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据~~");
        }
        return arr[front];
    }
}