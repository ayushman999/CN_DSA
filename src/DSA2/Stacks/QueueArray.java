package DSA2.Stacks;

public class QueueArray {
    private int front;
    private int rear;
    private int size;
    private int[] arr;
    QueueArray(int capacity)
    {
        arr=new int[capacity];
        front=-1;
        rear=-1;
        size=0;
    }
    QueueArray()
    {
        arr=new int[10];
        front=-1;
        rear=-1;
        size=0;
    }
    public boolean isempty()
    {
        return size()==0;
    }
    public int size()
    {
        return size;
    }
    public void enqueue(int data) throws QueueIsFullException {
        if(size()==arr.length)
        {
            duplicate();
        }
        if(size()==0)
        {
            front=0;
        }
        size++;
        rear=(rear+1)%arr.length;
        arr[rear]=data;
    }

    private void duplicate() {
        int[] temp=arr;
        arr=new int[temp.length*2];
        int pos=0;
        for(int t=front;t< temp.length;t++)
        {
            arr[pos]=temp[t];
            pos++;
        }
        for(int i=0;i<front;i++)
        {
            arr[pos]=temp[i];
            pos++;
        }
        front=0;
        rear=temp.length-1;
    }

    public int front() throws QueueIsEmptyException {
        if(size()==0)
        {
            throw new QueueIsEmptyException();
        }
        return arr[front];
    }
    public int dequeue() throws QueueIsEmptyException {
        if(size()==0)
        {
            throw new QueueIsEmptyException();
        }
        int temp=arr[front];
        front=(front+1)%arr.length;
        size--;
        return temp;
    }
}
