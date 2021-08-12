package DSA2.Stacks;

import DSA2.LinkedList.Node;

public class QueueInLL {
    private Node<Integer> front;
    private Node<Integer> rear;
    private int size;
    QueueInLL()
    {
        front=null;
        rear=null;
        size=0;
    }
    public int size()
    {
        return size;
    }
    public void enqueue(int data)
    {
        Node<Integer> newNode=new Node<>(data);
        if(front==null)
        {
            front=newNode;
            rear=newNode;
            size++;
            return;
        }
        rear.next=newNode;
        rear=rear.next;
        size++;

    }
    public int dequeue() throws QueueIsEmptyException {
        if(size()==0)
        {
            throw new QueueIsEmptyException();
        }
        size--;
        int temp=front.data;
        front=front.next;
        return temp;
    }
    public int front() throws StackIsEmptyException {
        if(size()==0)
        {
            throw new StackIsEmptyException();
        }
        return front.data;
    }
    public boolean isempty()
    {
        return size()==0;
    }
}
