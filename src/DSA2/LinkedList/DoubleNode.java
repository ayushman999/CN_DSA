package DSA2.LinkedList;

public class DoubleNode<T> {
    DoubleNode<T> prev;
    DoubleNode<T> next;
    T data;
    DoubleNode(T data)
    {
        this.data=data;
        prev=null;
        next=null;
    }
}
