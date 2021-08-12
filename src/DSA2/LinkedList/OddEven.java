package DSA2.LinkedList;

import java.util.PrimitiveIterator;

public class OddEven {
    public static void main(String[] args) {
        Node<Integer> head=PinkedList.insert();
        head=betterSeg(head);
        PinkedList.print(head);
    }

    private static Node<Integer> betterSeg(Node<Integer> head) {
        Node<Integer> p=head;
        Node<Integer> c=head;
        Node<Integer> t=head;
        while (t.next!=null)
        {
            t=t.next;
        }
        Node<Integer> tail=null;
        Node<Integer> h=null;
        while (t.next!=null)
        {
            t=t.next;
        }
        while (c!=tail)
        {
            if((c.data&1)==0 && h==null && tail==null)
            {
                p=c.next;
                c.next=null;
                t.next=c;
                t=t.next;
                tail=t;
                c=p;
            }
            else if((c.data&1)==0 && h==null && tail!=null)
            {
                p=c.next;
                c.next=null;
                t.next=c;
                t=t.next;
                c=p;
            }
            else if((c.data&1)==1 && h==null)
            {
                h=c;
                c=c.next;
            }
            else if((c.data&1)==1 && h!=null)
            {
                p=c;
                c=c.next;
            }
            else if((c.data&1)==0 && h!=null)
            {
                if(tail==null)
                {
                    tail=c;
                }
                p.next=p.next.next;
                c.next=t.next;
                t.next=c;
                t=t.next;
                c=p.next;
            }
        }
        return h;

    }

    private static Node<Integer> segregate(Node<Integer> head) {
        Node<Integer> h=head;
        Node<Integer> even=null;
        Node<Integer> odd=null;
        Node<Integer> temp1=null,temp2 = null;
        while (h!=null)
        {
            if((h.data&1)==0)
            {
                if(even==null)
                {
                    even=new Node<>(h.data);
                    temp1=even;
                    h=h.next;
                }
                else
                {
                    Node<Integer> newNode=new Node(h.data);
                    even.next=newNode;
                    even=even.next;
                    h=h.next;
                }
            }
            else
            {
                if(odd==null)
                {
                    odd=new Node<>(h.data);
                    temp2=odd;
                    h=h.next;
                }
                else
                {
                    Node<Integer> newNode=new Node(h.data);
                    odd.next=newNode;
                    odd=odd.next;
                    h=h.next;
                }
            }
        }
        odd.next=temp1;
        return temp2;
    }
}
