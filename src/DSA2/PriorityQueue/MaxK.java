package DSA2.PriorityQueue;

import java.util.PriorityQueue;
import java.util.Scanner;

public class MaxK {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int[] arr=new int[size];
        for(int i=0;i<size;i++)
        {
            arr[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int i=0;
        for(;i<k;i++)
        {
            pq.add(arr[i]);
        }
        for(;i<arr.length;i++)
        {
            if(arr[i]>pq.peek())
            {
                pq.poll();
                pq.add(arr[i]);
            }
        }
        while (!pq.isEmpty())
        {
            System.out.println(pq.poll());
        }
    }
}
