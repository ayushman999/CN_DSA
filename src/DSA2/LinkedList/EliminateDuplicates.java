package DSA2.LinkedList;

import java.util.Scanner;

public class EliminateDuplicates {
    public static void main(String[] args) {
        Node<Integer> head=insertData();
        head=removeDuplicates(head);
        FindNode.print(head);
    }

    private static Node<Integer> removeDuplicates(Node<Integer> head) {
        Node<Integer> temp=head;
        while (temp.next!=null)
        {
            if(temp.data==(temp.next).data)
            {
                temp.next=temp.next.next;
            }
            else
            {
                temp=temp.next;
            }
        }
        temp=head;
        return temp;
    }

    private static Node<Integer> insertData() {
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
}
