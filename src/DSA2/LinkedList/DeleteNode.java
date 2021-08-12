package DSA2.LinkedList;

import java.util.Scanner;

public class DeleteNode {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Node<Integer> head=PinkedList.insert();
        int M=sc.nextInt();
        int N=sc.nextInt();
        head=check(head,M,N);
        PinkedList.print(head);
    }

    private static Node<Integer> check(Node<Integer> head, int m, int n) {
        Node<Integer> res=head;
        Node<Integer> temp=head;
        int i=1;int j=1;
        boolean traversing=false;
        while (temp!=null)
        {
            if(i!=m)
            {
                temp=temp.next;
                i++;
            }
            else if(i==m && j!=n)
            {
                if(!traversing)
                {
                    head=temp;
                    temp=temp.next;
                    traversing=true;
                }
                temp=temp.next;
                j++;
            }
            else if(i==m && j==n)
            {
                head.next=temp.next;
                temp=temp.next;
                head=temp;
                traversing=false;
                i=1;
                j=1;
            }
        }
        if(head!=null && temp==null)
        {
            head.next=null;
        }
        return res;
    }
}
