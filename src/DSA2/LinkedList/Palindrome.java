package DSA2.LinkedList;

public class Palindrome {
    public static void main(String[] args) {
        Node<Integer> head=PinkedList.insert();
        Node<Integer> temp=getDuplicate(head);
        Node<Integer> reversed=reversedList(temp);
        check(head,reversed);


    }

    private static Node<Integer> getDuplicate(Node<Integer> h) {
        Node<Integer> head=null;
        Node<Integer> tail=null;
        while (h!=null)
        {
            Node<Integer> newNode=new Node<>(h.data);
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
            h=h.next;
        }
        return head;
    }

    private static void check(Node<Integer> head, Node<Integer> reversed) {
        while (head!=null)
        {
            if(head.data!=reversed.data)
            {
                System.out.println("Not a palindrome.");
                return;
            }
            head=head.next;
            reversed=reversed.next;
        }
        System.out.println("Palindrome number");
        return;
    }

    private static Node<Integer> reversedList(Node<Integer> head) {
        /*if(head==null || head.next==null)
        {
            return head;
        }
        Node<Integer> newNode=reversedList(head.next);
        head.next.next=head;
        head.next=null;
        return newNode;*/
        Node<Integer> prev=null;
        Node<Integer> current=head;
        Node<Integer> next;
        while (current!=null)
        {
            next=current.next;
            current.next=prev;

            prev=current;
            current=next;
        }
        return prev;
    }
}
