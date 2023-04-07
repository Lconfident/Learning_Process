package com.atguigu.linkedlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        System.out.println("双向链表的测试");
        // 先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        //新建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();

        //修改
        HeroNode2 newHeroNode = new HeroNode2(4, "公孙胜", "入云龙");
        doubleLinkedList.update(newHeroNode);
        System.out.println("更新后的链表~~");
        doubleLinkedList.list();

        //删除
        doubleLinkedList.delete(3);
        System.out.println("删除后的链表情况~~");
        doubleLinkedList.list();
    }
}

//创建一个双向链表的类
class DoubleLinkedList {
    /**
     * 先初始化一个头结点,头结点不要动
     */
    private HeroNode2 head = new HeroNode2(0, "", "");

    //返回头节点
    public HeroNode2 getHead() {
        return head;
    }

    //遍历双向链表

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
        HeroNode2 temp = head.next;
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
     * 添加一个节点到双向链表的最后
     */
    public void add(HeroNode2 heroNode) {
        // 因为HeroNode不能动，因此需要一个辅助变量 temp
        HeroNode2 temp = head;
        // 遍历链表，找到最后
        while (true) {
            //找到链表最后
            if (temp.next == null) {
                break;
            }
            //如果没有找到,就将tamp后移
            temp = temp.next;
        }
        //退出while循环时，temp指向链表的最后
        //形成双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    /**
     * 修改一个节点的内容
     */
    public void update(HeroNode2 newHeroNode) {
        // 判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点，根据no编号
        //定义一个辅助变量
        HeroNode2 temp = head.next;
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
     * 从双向链表中删除一个节点
     */
    public void delete(int no) {
        if (head.next == null) {
            System.out.println("链表为空，无法删除");
            return;
        }
        //辅助指针
        HeroNode2 temp = head.next;
        // flag 标识是否找到
        boolean flag = false;
        while (true) {
            if (temp == null) {
                //表示已经遍历到链表最后
                //也已含链表为空的情况
                break;
            }
            if (temp.no == no) {
                // 找到了待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            //表示找到，可以删除
            temp.pre.next = temp.next;
            //如果是最后一个节点，就不需要执行下面这句话，否则会出现空指针异常
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            //否则没有找到待删除的节点
            System.out.printf("没有找到编号为%d 的英雄\n", no);
        }
    }

}

/**
 * 定义一个HeroNode ， 每一个HeroNode对象就是一个节点
 * next 指向下一个节点
 */
class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;

    /**
     * 构造器
     */
    public HeroNode2(int no, String name, String nickname) {
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