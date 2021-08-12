package DSA2.LinkedList;

public class MergeInterval {


    static Node<Integer> merge(Node<Integer> t1, Node<Integer> t2) {
        Node<Integer> t=null;
        Node<Integer> head=null;
        while (t1!=null && t2!=null)
        {
            if(t1.data>t2.data)
            {
                if(t==null)
                {
                    t=t2;
                    t2=t2.next;
                    head=t;
                }
                else
                {
                    t.next=t2;
                    t=t.next;
                    t2=t2.next;
                }
            }
            else
            {
                if(t==null)
                {
                    t=t1;
                    t1=t1.next;
                    head=t;
                }
                else
                {
                    t.next=t1;
                    t=t.next;
                    t1=t1.next;
                }
            }
        }
        if(t1!=null)
        {
            t.next=t1;
        }
        if(t2!=null)
        {
            t.next=t2;
        }
        return head ;
    }
}
