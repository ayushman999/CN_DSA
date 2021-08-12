package DSA2.PriorityQueue;

import java.util.ArrayList;

public class PQMax {
    private ArrayList<Integer> heap;
    PQMax()
    {
        heap=new ArrayList<>();
    }

    public boolean isEmpty()
    {
        return heap.size()==0;
    }

    public int size()
    {
        return heap.size();
    }

    public int getData() throws PQEmptyException {
        if(isEmpty())
        {
            throw new PQEmptyException();
        }
        else
        {
            return heap.get(0);
        }
    }

    public void insert(int data)
    {
        heap.add(data);
        int child=size()-1;
        int parent=(child-1)/2;
        while (child>0)
        {
            if(heap.get(child)>heap.get(parent))
            {
                int temp=heap.get(child);
                heap.set(child,heap.get(parent));
                heap.set(parent,temp);
                child=parent;
                parent=(child-1)/2;
            }
            else
            {
                return;
            }
        }
    }

    public ArrayList<Integer> showHeap(){return heap;}

    public int delete() throws PQEmptyException {
        if(isEmpty())
        {
            throw new PQEmptyException();
        }
        int t=heap.get(0);
        heap.set(0,heap.get(size()-1));
        heap.remove(size()-1);
        int index=0;
        int max=index;
        int nodeX=1;
        int nodeY=2;
        while (nodeX<size())
        {
            if(heap.get(max)<heap.get(nodeX))
            {
                max=nodeX;
            }
            if(nodeY<size() && heap.get(max)<heap.get(nodeY))
            {
                max=nodeY;
            }
            if(index==max)
            {
                break;
            }
            int temp=heap.get(max);
            heap.set(max,heap.get(index));
            heap.set(index,temp);
            index=max;
            nodeX=max*2+1;
            nodeY=max*2+2;
        }
        return t;
    }
}
