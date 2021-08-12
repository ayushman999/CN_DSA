package DSA2.LinkedList;

public class Beechkaadmi {
    static Node<Integer> slow=null;
    static Node<Integer> fast=null;
    public static void main(String[] args) {
        Node<Integer> head=PinkedList.insert();
        Node<Integer> mid=getMid(head,null);
        Node<Integer> left=getMid(head,mid);
        Node<Integer> right=getMid(mid.next,null);
        System.out.println(left.data+" "+right.data);
    }

    static Node<Integer> getMid(Node<Integer> l, Node<Integer> r ) {
        slow=l;
        fast=l;
        while (fast.next!=r && fast!=r)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    static Node<Integer> getTail(Node<Integer> tail)
    {
        while (tail.next!=null)
        {
            tail=tail.next;
        }
        return tail;
    }
}
