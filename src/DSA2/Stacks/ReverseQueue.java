package DSA2.Stacks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=5;i++)
        {
            q.add(i);
        }
        System.out.println(q);
        reverse(q);
        System.out.println(q);
    }

    private static void reverse(Queue<Integer> q) {
        if(q.isEmpty())
        {
            return;
        }
        int temp=q.poll();
        reverse(q);
        q.add(temp);
    }
}
