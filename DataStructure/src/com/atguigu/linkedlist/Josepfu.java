package com.atguigu.linkedlist;

public class Josepfu {
    public static void main(String[] args) {
        //测试环形链表构建和遍历
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(125);
        circleSingleLinkedList.showBoy();

        //测试小孩出圈是否正确
        circleSingleLinkedList.countBoy(10,20,125);
    }
}


/**
 * 先创建一个Boy类,表示一个节点
 * 编号
 * 指向下一个节点,默认null
 */
class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}

/**
 * 创建一个环形的单向链表
 */
class CircleSingleLinkedList {
    //创建一个first节点，没有编号

    private Boy first = new Boy(-1);

    /**
     * 添加小孩节点，构建一个环形的链表
     */
    public void addBoy(int nums) {
        //验证nums 做一个数据校验
        if (nums < 2) {
            System.out.println("nums的值不正确");
            return;
        }
        //辅助指针，帮助构建环形链表
        Boy curBoy = null;
        //使用for循环创建我们的环形链表
        for (int i = 1; i <= nums; i++) {
            //根据变量，创建Boy节点
            Boy boy = new Boy(i);
            //如果是第一个Boy
            if (i == 1) {
                first = boy;
                //构成环
                first.setNext(first);
                //让curBoy指向第一个Boy
                curBoy = first;
            } else {
                //三部曲 1.前指后 2.后指头 3.辅助指针后移
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    /**
     * 遍历当前的环形链表
     */
    public void showBoy() {
        //判断当前链表是否为空
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        //因为first不能动，因此我们需要一个辅助指针完成遍历
        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩的编号 %d \n", curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            }
            //后移一位
            curBoy = curBoy.getNext();
        }
    }

    /**
     * 根据用户的输入，计算出小孩出圈的顺序
     *
     * @param startNo  表示从第几个小孩开始数数
     * @param countNum 表示数几下
     * @param nums     表示最初有多少小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {
        //先对数据进行校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误，请重新进行输入");
            return;
        }
        //创建一个辅助指针，帮助完成小孩出圈
        Boy helper = first;
        while (true) {
            if (helper.getNext() == first) {
                //说明helper指向最后小孩节点
                break;
            }
            helper = helper.getNext();
        }

        //小孩报数前，先让first和helper （k-1）次  --> 移动到第k个小孩
        for (int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        //当小孩报数时，让first和helper 指针同时移动 （m-1）次， 然后出圈
        //这里是一个循环操作，知道圈中只有一个节点
        while (true) {
            if (helper == first) {
                //说明圈中只有一人
                break;
            }
            //让first和helper 指针同时移动 （countNum - 1）次
            for (int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //这时first指向的节点，就是要出圈的小孩节点
            System.out.printf("小孩%d出圈\n", first.getNo());
            //这时让小孩出圈,删除节点
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号%d \n",helper.getNo());
    }
}

