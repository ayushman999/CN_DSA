package DSA2.Stacks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SortQueue {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Queue<Integer> q=new LinkedList<>();
        int size=sc.nextInt();
        for(int i=0;i<size;i++)
        {
            q.add(sc.nextInt());
        }
        rev(q);
        System.out.println(q);
    }

    private static void rev(Queue<Integer> q) {
        if(q.size()==1)
        {
            return;
        }
        int res=q.poll();
        rev(q);
        int head=q.peek();
        if(res<head)
        {
            addTostart(res,q);
        }
        else 
        {
            adjust(q,res);
            q.add(res);
            while (q.peek()!=head)
            {
                q.add(q.poll());
            }
        }
    }

    private static void adjust(Queue<Integer> q, int res) {
        int i=0;
        while (res>q.peek() && i<q.size())
        {
            i++;
            q.add(q.poll());
        }
    }

    private static void addTostart(int res, Queue<Integer> q) {
        q.add(res);
        while (q.peek()!=res)
        {
            q.add(q.poll());
        }
    }

}
