package DSA2.Stacks;

import DSA2.LinkedList.Node;

public class StackInLL {
    private Node<Integer> linkedList;
    private Node<Integer> top;
    private int s;
    StackInLL()
    {
        top=null;
        s=0;
    }
    public void push(int i)
    {
        Node<Integer> newNode=new Node<>(i);
        if(top==null)
        {
            s++;
            top=newNode;
        }
        else
        {
            s++;
            newNode.next=top;
            top=newNode;
        }
    }
    public int pop() throws StackIsEmptyException {
        if(top==null)
        {
            throw new StackIsEmptyException();
        }
        else
        {
            int temp=top.data;
            top=top.next;
            s--;
            return temp;
        }
    }
    public int peek() throws StackIsEmptyException {
        if(top==null)
        {
            throw new StackIsEmptyException();
        }
        else
        {
            return top.data;
        }
    }
    public int size()
    {
        return s;
    }
}
