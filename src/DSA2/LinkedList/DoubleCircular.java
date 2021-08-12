package DSA2.LinkedList;

import java.util.Scanner;

public class DoubleCircular {
    public static void main(String[] args) {
        DoubleNode<Integer> head=insert();
        print(head);
        head=insertNode(head,0,69);
        print(head);
        head=delete(0,head);
        print(head);
    }
    private static DoubleNode<Integer> delete(int pos,DoubleNode<Integer> head)
    {
        if(pos==0)
        {
            DoubleNode<Integer> next=head.next;
            DoubleNode<Integer> prev=head.prev;
            prev.next=next;
            next.prev=prev;
            return next;
        }
        delete(pos-1,head.next);
        return head;
    }
    private static DoubleNode<Integer> insertNode(DoubleNode<Integer> head, int i, int data) {
       if(i==0)
       {
           DoubleNode<Integer> newNode=new DoubleNode<>(data);
           newNode.next=head;
           DoubleNode<Integer> prev=head.prev;
           prev.next=newNode;
           newNode.prev=prev;
           return newNode;
       }
       insertNode(head.next,i-1,data);
       return head;
    }

    private static void reversePrint(DoubleNode<Integer> head) {
        DoubleNode<Integer> temp=head.next;
        while (temp.next!=head)
        {
            temp=temp.next;
        }
        DoubleNode<Integer> tail=temp;
        do {
            System.out.print(tail.data+" ");
            tail=tail.prev;
        }
        while (tail!=head.prev);
        System.out.println();
    }

    private static void print(DoubleNode<Integer> head) {
        DoubleNode<Integer> temp=head;
        do {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        while (temp!=head);
        System.out.println();
    }

    private static DoubleNode<Integer> insert() {
        DoubleNode<Integer> head=null;
        DoubleNode<Integer> tail=null;
        Scanner sc=new Scanner(System.in);
        int data=sc.nextInt();
        while (data!=-1)
        {
            DoubleNode<Integer> newNode=new DoubleNode<>(data);
            if(head==null)
            {
                head=newNode;
                tail=newNode;
            }
            else
            {
                tail.next=newNode;
                newNode.prev=tail;
                tail=tail.next;
            }
            data=sc.nextInt();
        }
        tail.next=head;
        head.prev=tail;
        return head;
    }
}
