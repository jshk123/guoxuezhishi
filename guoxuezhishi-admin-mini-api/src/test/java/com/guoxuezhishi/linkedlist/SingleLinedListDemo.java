package com.guoxuezhishi.linkedlist;

/**
 * @author: jiang
 * @date: 2019/9/2
 * 带头的链表
 */
public class SingleLinedListDemo {

    public static void main(String[] args) {

    }

}

//定义SingleLinkedList 管理链表
class SingleLinkedList {
    //先初始化一个头节点，头节点不要动，不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    //添加节点到单向链表
    //思路，当前不考虑编号顺序
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
                ", next=" + next +
                '}';
    }
}
