package com.atguigu.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {

    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建一个链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //加入
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero2);

        //测试一个单链表的反转功能
        System.out.println("原链表~~");
        singleLinkedList.list();

//        System.out.println("反转之后的链表~~");
//        reverseList(singleLinkedList.getHead());
//        singleLinkedList.list();

        System.out.println("逆序打印单链表，没有改变链表本身的结构~~");
        reversetList(singleLinkedList.getHead());

        // 加入按照编号的顺序
/*
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);

        //显示一把
        singleLinkedList.list();

        //要测试修改节点
        HeroNode newHeroNode = new HeroNode(2, "小卢", "小麒麟");
        singleLinkedList.update(newHeroNode);

        System.out.println("修改后的链表情况~~");
        singleLinkedList.list();

        //删除一个节点
        singleLinkedList.delete(1);
        singleLinkedList.delete(4);
        singleLinkedList.delete(2);
        singleLinkedList.delete(3);
        System.out.println("删除节点后的情况~~");
        singleLinkedList.list();
        */

        //从尾打印单链表，栈（先进后出）


    }

    /**
     * 将单链表反转
     * 这个利用单链表的头插法
     * 从而建立反转链表
     */
    public static void reverseList(HeroNode head) {
        //如果当前链表为空，或者只有一个节点，无须反转，直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }

        //定义一个辅助指针(变量) 帮助我们遍历原来的链表
        HeroNode cur = head.next;
        //指向[cur]的下一个节点
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, "", "");
        //并从头遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead 的最前端
        while (cur != null) {
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        // 将head，next 指向reverse.head 实现反转
        head.next = reverseHead.next;
    }

    /**
     * 利用栈结构，将各个节点压入栈中，先进后出，逆序打印
     */
    public static void reversetList(HeroNode head){
        if (head.next == null){
            return ;
        }

        //创建一个栈，将各个节点压入栈中
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;
        //将所有的节点都压入栈中
        while(cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        //将栈中的节点打印
        while (stack.size()>0){
            //pop the stack,stack的热点是先进后出
            System.out.println(stack.pop());
        }
    }
}


/**
 * 定义一个SingleLinkedList 管理我们的英雄
 */
class SingleLinkedList {
    /**
     * 先初始化一个头结点,头结点不要动
     */
    private HeroNode head = new HeroNode(0, "", "");

    /**
     * 添加节点到单向链表
     * 思路：当不考虑编号顺序时
     * 1. 找到当前链表的最后节点
     * 2. 将最后这个节点的 next域 指向 新的节点
     */
    public void add(HeroNode heroNode) {
        // 因为HeroNode不能动，因此需要一个辅助变量 temp
        HeroNode temp = head;
        // 遍历链表，找到最后
        while (true) {
            //找到链表最后
            if (temp.next == null) {
                break;
            }
            //如果没有找到,就将tamp后移
            temp = temp.next;
        }
        //将最后这个节点的next指向 新的节点
        temp.next = heroNode;
    }

    /**
     * 第二种方式在添加英雄时，根据排名将英雄插入到指定位置
     * （如果有这个排名，则添加失败，并给出提示）
     */
    public void addByOrder(HeroNode heroNode) {
        //因为头结点不能动，所以我们任然通过一个辅助指针 temp 来帮助找到添加的位置
        //因为是单链表，因为我们找的 temp 是位于 添加位置 的前一个节点，否则 插入不了
        HeroNode temp = head;
        //标志添加的编号是否存在，默认为false
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                //位置找对了，插入到temp后面
                break;
            } else if (temp.next.no == heroNode.no) {
                //希望添加的heroNode的 编号 已然存在
                flag = true;
                break;
            }
            temp = temp.next;
            //后移，遍历当前链表
        }
        //判断flag的值
        if (flag) {
            //不能添加，说明编号存在
            System.out.printf("准备插入英雄的编号 %d 已经存在了，不能加入\n", heroNode.no);
        } else {
            //插入到链表中， temp 后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }

    }

    /**
     * 修改节点的信息，根据编号来修改，即no无法修改
     * 1. 根据newHeroNode 的 no 来修改即可
     */
    public void update(HeroNode newHeroNode) {
        // 判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点，根据no编号
        //定义一个辅助变量
        HeroNode temp = head.next;
        // flag表示 是否找到
        boolean flag = false;
        while (true) {
            if (temp == null) {
                // 已经遍历完链表
                break;
            }
            if (temp.no == newHeroNode.no) {
                // 找到了
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 根据flag 判断是否找到要修改的节点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            // 没有找到
            System.out.printf("没有找到编号等于%d 的节点\n", newHeroNode.no);
        }
    }

    /**
     * 删除节点
     * 思路：
     * 1. head节点不能动，因此需要一个temp辅助节点， 找到要删除节点的前一个节点
     * 2. 在比较时，是temp.next.no == 要删除的节点.no 进行比较
     */
    public void delete(int no) {
        HeroNode temp = head;
        // flag 标识是否找到
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                //表示已经遍历到链表最后
                //也已含链表为空的情况
                break;
            }
            if (temp.next.no == no) {
                // 找到了待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            //表示找到，可以删除
            temp.next = temp.next.next;
        } else {
            //否则没有找到待删除的节点
            System.out.printf("没有找到编号为%d 的英雄\n", no);
        }
    }

    /**
     * 显示链表【遍历】
     */
    public void list() {
        //先判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空~~");
            return;
        }
        //因为头结点，不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将temp后移
            temp = temp.next;
        }
    }

    /**
     * @return 头结点
     */
    public HeroNode getHead() {
        return head;
    }
}

/**
 * 定义一个HeroNode ， 每一个HeroNode对象就是一个节点
 * next 指向下一个节点
 */
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    /**
     * 构造器
     */
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    /**
     * 为了显示方便，我们重写toString
     */
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname +
                "'}";
    }
}