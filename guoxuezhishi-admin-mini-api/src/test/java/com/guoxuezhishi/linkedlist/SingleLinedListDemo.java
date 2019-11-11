package com.guoxuezhishi.linkedlist;

/**
 * @author: jiang
 * @date: 2019/9/2
 * 带头的链表
 */
public class SingleLinedListDemo {

    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        //创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
/*        //加入链表
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);*/

        //按照编号加入链表
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero4);

        //显示链表
        singleLinkedList.list();

        //测试修改节点的代码
        HeroNode newHeroNode = new HeroNode(2, "卢", "玉");
        HeroNode newHeroNode2 = new HeroNode(5, "卢", "玉");
        singleLinkedList.update(newHeroNode);
        singleLinkedList.update(newHeroNode2);
        //显示链表
        System.out.println("修改后的链表：");
        singleLinkedList.list();
        //删除一个节点
        singleLinkedList.del(1);
        singleLinkedList.del(3);
        //显示链表
        System.out.println("删除后的链表：");
        singleLinkedList.list();
    }

}

//定义SingleLinkedList 管理英雄链表
class SingleLinkedList {
    //先初始化一个头节点，头节点不要动，不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    //添加节点到单向链表
    //第一种方式不考虑编号顺序
    //1. 找到当前链表的最后节点
    //2. 将最后这个节点的next 指向新的节点
    public void add(HeroNode heroNode) {
        //因为head 节点不能动，因为我们需要一个辅助变量temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                break;
            }
            //如果没有找到最后, 就将temp 后移
            temp = temp.next;
        }
        //当退出while 循环时，temp 指向了链表的最后
        //将最后这个节点的next 指向新的节点
        temp.next = heroNode;
    }

    //第二种方式在添加英雄时，根据排名将英雄插入到指定位置
    //如果有这个排名，则添加失败，并给出提示
    public void addByOrder(HeroNode heroNode) {
        //因为head 节点不能动，因为我们需要一个辅助变量temp
        HeroNode temp = head;
        //因为单链表，因此找到的temp是位于添加位置的前一个节点，否则插入不了
        // flag表示添加的编号是否存在，默认为false
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                //说明temp已经在链表的最后
                break;
            }
            if (temp.next.no > heroNode.no) {
                //位置找到，就在temp的后面插入
                break;
            } else if (temp.next.no == heroNode.no) {
                //说明添加的heroNode的编号已经存在
                flag = true;
                break;
            }
            //没有找到，继续遍历当前链表
            temp = temp.next;
        }
        if (flag) {
            //不能添加，说明编号存在
            System.out.printf("准备插入的英雄的编号%d已经存在，不能加入\n", heroNode.no);
        } else {
            //插入到链表中，temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //修改节点的信息，根据no编号来来修改，即no编号不能改
    //根据newHeroNode的no来修改
    public void update(HeroNode newHeroNode) {
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点，根据no编号
        //定义一个辅助变量
        HeroNode temp = head.next;
        //flag表示是否找到该节点
        boolean flag = false;
        while (true) {
            if (temp == null) {
                //已经遍历完链表
                break;
            }
            if (temp.no == newHeroNode.no) {
                //找到no
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到要修改的节点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.printf("没有找到编号%d的节点，不能修改\n", newHeroNode.no);
        }

    }

    //删除节点
    //1、head不能动，因此需要一个temp辅助节点找到待删除节点的前一个节点
    //2.比较时，temp.next.no和需要删除的节点no进行比较
    public void del(int no) {
        HeroNode temp = head;
        //标志是否找到待删除节点的前一个节点
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                //已经到链表的最后
                break;
            }
            if (temp.next.no == no) {
                //找到待删除节点的前一个节点
                flag = true;
                break;
            }
            //temp后移，继续遍历
            temp = temp.next;
        }
        //判断是否找到
        if (flag) {
            //删除
            temp.next = temp.next.next;
        } else {
            System.out.println("要删除的%d节点不存在\n" + no);
        }
    }

    //显示英雄链表---遍历
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
                break;
            }
            //输出节点信息
            System.out.println(temp);
            //将temp后移
            temp = temp.next;
        }

    }

}

//定义HeroNode ,每个HeroNode 对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;//指向下个节点

    //构造器
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
