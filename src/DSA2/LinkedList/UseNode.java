package DSA2.LinkedList;

import java.util.Scanner;

public class UseNode {
    public static void main(String[] args) {
        Node<Integer> head=getNode();
        print(head);
        Node<Integer> newNode=recursiveDelete(head,3);
        print(newNode);
    }
    private static Node<Integer> recursiveDelete(Node<Integer> head,int pos)
    {
        if(pos==1)
        {
            head.next=head.next.next;
            return head;
        }
        if(head==null)
        {
            return head;
        }
        return recursiveDelete(head.next,pos-1);
    }
    private static Node<Integer> recursiveInsert(Node<Integer> head,int pos,int data)
    {
        if(pos==0)
        {
            Node<Integer> newNode=new Node<>(data);
            newNode.next=head;
            return newNode;
        }
        if(head==null)
        {
            return head;
        }
        Node<Integer> newNode=recursiveInsert(head.next,pos-1,data);
        head.next=newNode;
        return head;
    }
    private static Node<Integer> delete(Node<Integer> head,int pos)
    {
        Node<Integer> temp=head;
        if(pos==0)
        {
            head=head.next;
            return head;
        }
        else
        {
            int i=0;
            while (i<pos-1)
            {
                temp=temp.next;
                if(temp.next==null)
                {
                    System.out.println("Kya kar rha hai laude!");
                    return null;
                }
                i++;
            }
            temp.next=temp.next.next;
            return head;
        }
    }
    private static Node<Integer> insert(Node<Integer> head,int data,int pos)
    {
        Node<Integer> newNode=new Node<>(data);
        if(pos==0)
        {
            newNode.next=head;
            head=newNode;
            return head;
        }
        else
        {
            Node<Integer> temp=head;
            int i=0;
            while (i<pos-1)
            {
                head=head.next;
                i++;
            }
            newNode.next=head.next;
            head.next=newNode;
            return temp;
        }
    }

    private static Node<Integer> getNode() {
        Node<Integer> head=null;
        Node<Integer> tail=null;
        Scanner sc=new Scanner(System.in);
        int data=sc.nextInt();
        while (data!=-1)
        {
            Node<Integer> node=new Node<>(data);
            if(head==null)
            {
                head=node;
                tail=node;
            }
            else
            {
                tail.next=node;
                tail=node;
            }
            data=sc.nextInt();
        }
        return head;
    }

    private static void print(Node<Integer> head) {
        while (head!=null)
        {
            System.out.print(head.data+" ");
            head=head.next;
        }
        System.out.println();
    }
}
