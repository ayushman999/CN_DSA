package DSA2.LinkedList;

import java.util.Scanner;

public class SwapNodes {
    public static void main(String[] args) {
        Node<Integer> head=PinkedList.insert();
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        head=check(head,m,n);
        PinkedList.print(head);
    }

    private static Node<Integer> check(Node<Integer> head, int m, int n) {
        Node<Integer> h=head;
        Node<Integer> p1=head;
        Node<Integer> p2=head;
        Node<Integer> tail=head;
        int t=0;
        while (tail.next!=null)
        {
            t++;
            tail=tail.next;
        }
        int i=0,j=0;
        while (i!=m)
        {
            i++;
            p1=p1.next;
        }
        while (j!=n)
        {
            j++;
            p2=p2.next;
        }
        if(m==0 && n==1)
        {
            p1.next=p2.next;
            p2.next=p1;
            h=p2;
        }
        else if((n-m)==1)
        {
            Node<Integer> P=head;
            while (P.next!=p1)
            {
                P=P.next;
            }
            P.next=P.next.next;
            p1.next=p2.next;
            p2.next=p1;
        }
        else if(m>0)
        {
            Node<Integer> pr1=head;
            Node<Integer> pr2=head;
            Node<Integer> n1=p1.next;
            Node<Integer> n2=p2.next;
            while (pr1.next!=p1)
            {
                pr1=pr1.next;
            }
            while (pr2.next!=p2)
            {
                pr2=pr2.next;
            }
            pr1.next=p2;
            pr2.next=p1;
            p1.next=n2;
            p2.next=n1;
        }
        else if(m==0)
        {
            Node<Integer> pr1=head;
            Node<Integer> n1=p2.next;
            while (pr1.next!=p2)
            {
                pr1=pr1.next;
            }
            p2.next=p1.next;
            pr1.next=p1;
            p1.next=n1;
            h=p2;
        }
        return h;
    }
}
