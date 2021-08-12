package DSA2.LinkedList;

import java.util.Scanner;

public class UseDouble {
    public static void main(String[] args) {
        DoubleNode<Integer> head=insert();
        printforward(head);
        printreverse(head);
    }

    private static void printreverse(DoubleNode<Integer> head) {
        DoubleNode<Integer> temp=head;
        while (temp.next!=null)
        {
            temp=temp.next;
        }
        while (temp!=null)
        {
            System.out.print(temp.data+" ");
            temp= temp.prev;
        }
    }

    private static void printforward(DoubleNode<Integer> head) {
        while (head!=null)
        {
            System.out.print(head.data+" ");
            head=head.next;
        }
        System.out.println();
    }

    private static DoubleNode<Integer> insert() {
        Scanner sc=new Scanner(System.in);
        int data=sc.nextInt();
        DoubleNode<Integer> head=null;
        DoubleNode<Integer> tail=null;
        while (data!=-1){
            DoubleNode<Integer> newNode=new DoubleNode<>(data);
            if(head==null)
            {
                head=newNode;
                tail=newNode;
            }
            else
            {
                newNode.prev=tail;
                tail.next=newNode;
                tail=tail.next;
            }
            data=sc.nextInt();
        }
        return head;
    }
}
