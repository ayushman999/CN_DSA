package DSA2.LinkedList;

public class MergeSort {
    static Node<Integer> head;
    public static void main(String[] args) {
        head=PinkedList.insert();
        Node<Integer> last=head;
        while (last.next!=null)
        {
            last=last.next;
        }
        head=mergeSort(head,last);
        PinkedList.print(head);
    }

    private static Node<Integer> mergeSort(Node<Integer> l, Node<Integer> r) {
        if(l.equals(r) || l.next==null)
        {
            Node<Integer> newNode=new Node<>(l.data);
            return newNode;
        }
        Node<Integer> mid=Beechkaadmi.getMid(l,r);
        Node<Integer> lhs=mergeSort(l,mid);
        Node<Integer> rhs=mergeSort(mid.next,r);
        return merge(lhs,rhs);
    }

    private static Node<Integer> merge(Node<Integer> lhs, Node<Integer> rhs) {
        Node<Integer> head=null;
        Node<Integer> t=null;
        while (lhs!=null && rhs!=null)
        {
            if(lhs.data> rhs.data)
            {
                if(head==null)
                {
                    head=rhs;
                    t=rhs;
                    rhs=rhs.next;
                }
                else
                {
                    t.next=rhs;
                    t=t.next;
                    rhs=rhs.next;
                }
            }
            else
            {
                if(head==null)
                {
                    head=lhs;
                    t=lhs;
                    lhs=lhs.next;
                }
                else
                {
                    t.next=lhs;
                    t=t.next;
                    lhs=lhs.next;
                }
            }

        }
        if(lhs!=null)
        {
            t.next=lhs;
        }
        if(rhs!=null)
        {
            t.next=rhs;
        }
        return head;
    }

}
