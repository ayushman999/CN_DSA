package DSA2.PriorityQueue;

import java.util.ArrayList;

public class PQMin {
    public ArrayList<Integer> heap;

    PQMin() {
        heap = new ArrayList<>();
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

    public int getSize() {
        return heap.size();
    }

    public int getMin() throws PQEmptyException {
        if (isEmpty()) {
            throw new PQEmptyException();
        } else {
            return heap.get(0);
        }
    }

    public void insert(int data) {
        heap.add(data);
        int child = getSize() - 1;
        int parent = (child - 1) / 2;
        while (child > 0) {
            if (heap.get(child) < heap.get(parent)) {
                int temp = heap.get(child);
                heap.set(child, heap.get(parent));
                heap.set(parent, temp);
                child = parent;
                parent = (child - 1) / 2;
            } else {
                return;
            }
        }
    }

    public int deleteMin() throws PQEmptyException {
        if (isEmpty()) {
            throw new PQEmptyException();
        } else {
            int temp = heap.get(0);
            heap.set(0, heap.get(getSize() - 1));
            heap.remove(getSize() - 1);
            int index = 0;
            int min = index;
            int childX = 1;
            int childY = 2;
            while (childX < getSize()) {
                if (heap.get(childX) < heap.get(min)) {
                    min = childX;
                }
                if (childY<getSize() && heap.get(childY) < heap.get(min)) {
                    min = childY;
                }
                if (min == index) {
                    break;
                } else {
                    int t = heap.get(min);
                    heap.set(min, heap.get(index));
                    heap.set(index, t);
                    childX = min * 2 + 1;
                    childY = min * 2 + 2;
                    index = min;
                }
            }

            return temp;
        }
    }

    public ArrayList<Integer> getHeap()
    {
        return heap;
    }

    public ArrayList<Integer> heapify(ArrayList<Integer> list) throws PQEmptyException {
        int n=((list.size()-1)/2);
        while (n>=0)
        {
            if (isEmpty()) {
                throw new PQEmptyException();
            } else {
                int index = n;
                int min = index;
                int childX = n + 1;
                int childY = n + 2;
                while (childX < list.size()) {
                    if (list.get(childX) < list.get(min)) {
                        min = childX;
                    }
                    if (childY < list.size() && list.get(childY) < list.get(min)) {
                        min = childY;
                    }
                    if (min == index) {
                        break;
                    } else {
                        int t = list.get(min);
                        list.set(min, list.get(index));
                        list.set(index, t);
                        childX = min * 2 + 1;
                        childY = min * 2 + 2;
                        index = min;
                    }
                }
            }
            n--;
        }
        return list;
    }

    public void setHeap(ArrayList<Integer> heap)
    {
        this.heap=new ArrayList<>(heap);
    }

}
