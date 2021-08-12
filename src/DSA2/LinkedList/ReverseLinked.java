package DSA2.LinkedList;

public class ReverseLinked {
    public static void main(String[] args) {
        Node<Integer> head=PinkedList.insert();
        /*head=reverseLinkedList(head);*/
        head=recursiveCheck(head);
        PinkedList.print(head);
    }

    private static Node<Integer> recursiveCheck(Node<Integer> head) {
        if(head==null || head.next==null)
        {
            return head;
        }
        Node<Integer> newNode=recursiveCheck(head.next);
        head.next.next=head;
        head.next=null;
        return newNode;
    }

    private static Node<Integer> reverseLinkedList(Node<Integer> head) {
        Node<Integer> prev=null;
        Node<Integer> curr=head;
        Node<Integer> next;
        while (curr!=null)
        {
            next=curr.next;
            curr.next=prev;

            prev=curr;
            curr=next;
        }
        return prev;
    }
}
