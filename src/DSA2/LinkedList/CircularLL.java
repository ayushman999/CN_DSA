package DSA2.LinkedList;

import java.util.Scanner;

public class CircularLL {
    public static void main(String[] args) {
        Node<Integer> head=insert();
        Node<Integer> tail=head;
        while (tail.next!=head)
        {
            tail=tail.next;
        }
        head=insertNode(0,69,head,tail);
        printCircularList(head);
    }

    private static Node<Integer> insertNode(int pos, int data, Node<Integer> head,Node<Integer> tail) {
        Node<Integer> newNode=new Node<>(data);
        if(pos==0)
        {
            newNode.next=head;
            tail.next=newNode;
            head=newNode;
            return head;
        }
        else
        {
            Node<Integer> temp=head;
            int i=0;
            while (i!=pos-1)
            {
                temp=temp.next;
                i++;
            }
            newNode.next=temp.next;
            temp.next=newNode;
            return head;
        }
    }


    private static void printCircularList(Node<Integer> head) {
        Node<Integer> temp=head;
        System.out.println(temp.data);
        head=head.next;
        while (head!=temp)
        {
            System.out.println(head.data);
            head=head.next;
        }
    }

    private static Node<Integer> insert() {
        Node<Integer> head=null;
        Node<Integer> tail=null;
        Scanner sc=new Scanner(System.in);
        int data=sc.nextInt();
        while (data!=-1)
        {
            Node<Integer> newNode=new Node<>(data);
            if(head==null)
            {
                head=newNode;
                tail=newNode;
            }
            else
            {
                tail.next=newNode;
                tail=tail.next;
            }
            data=sc.nextInt();
        }
        tail.next=head;
        return head;
    }
}
