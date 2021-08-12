package DSA2.LinkedList;

import java.util.Scanner;

public class FindNode {
    static int num=0;
    public static void main(String[] args) {
        Node<Integer> head=insert();
        System.out.println(check(head,num));
    }

    private static int check(Node<Integer> head, int num) {
        int i=0;
        while (head!=null)
        {
            if(head.data==num)
            {
                return i;
            }
            else
            {
                i++;
                head=head.next;
            }
        }
        return -1;
    }

    static void print(Node<Integer> head)
    {
        while (head!=null)
        {
            System.out.print(head.data+" ");
            head=head.next;
        }
        System.out.println();
    }
    static Node<Integer> insert() {
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
        System.out.println("Enter number:");
        num=sc.nextInt();
        return head;
    }
}
