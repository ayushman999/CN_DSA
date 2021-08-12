package DSA2.LinkedList;

import java.util.Scanner;

public class PinkedList {

    public static Node<Integer> insert()
    {
        Scanner sc=new Scanner(System.in);
        Node<Integer> head=null;
        Node<Integer> tail=null;
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
        return head;
    }
    public static void print(Node<Integer> head)
    {
        while (head!=null)
        {
            System.out.print(head.data+" ");
            head=head.next;
        }
        System.out.println();
    }
}
