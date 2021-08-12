package DSA2.Stacks;

import java.util.EmptyStackException;

public class StackByArray {
    private int[] stack;
    private int top;
    StackByArray()
    {
        stack=new int[10];
        top=-1;
    }
    StackByArray(int capacity)
    {
        stack=new int[capacity];
        top=-1;
    }
    public int size()
    {
        return top+1;
    }
    public void push(int item) {
        if(size()==stack.length)
        {
            int[] newStack=new int[stack.length*2];
            for(int i=0;i<stack.length;i++)
            {
                newStack[i]=stack[i];
            }
            stack=newStack;
        }
        top+=1;
        stack[top]=item;
    }
    public int pop() throws StackIsEmptyException {
        if(size()==0)
        {
            throw new StackIsEmptyException();
        }
        int temp=stack[top];
        top--;
        return temp;
    }
    public int peek() throws StackIsEmptyException {
        if(size()==0)
        {
            throw new StackIsEmptyException();
        }
        return stack[top];
    }
}
