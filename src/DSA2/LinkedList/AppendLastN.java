package DSA2.LinkedList;

import java.util.Scanner;

public class AppendLastN {
    static int num=3;
    public static void main(String[] args) {
        Node<Integer> head=insert();
        head=check(head);
        print(head);
    }

    private static void print(Node<Integer> head) {
        while (head!=null)
        {
            System.out.print(head.data+" ");
            head=head.next;
        }
        System.out.println();
    }

    private static Node<Integer> check(Node<Integer> head) {
        int i=0;
        Node<Integer> temp=head;
        while (i<num-2)
        {
            temp=temp.next;
            i++;
        }
        Node<Integer> tail=temp;
        while (tail.next!=null)
        {
            tail=tail.next;
        }
        tail.next=head;
        head=temp.next;
        temp.next=null;
        return head;
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
                tail=newNode;
            }
            data=sc.nextInt();
        }
        System.out.println("Enter number:");
        num=sc.nextInt();
        return head;
    }
}
