package DSA2.PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Tickets {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        maxcompare max=new maxcompare();
        PriorityQueue<Integer> pq=new PriorityQueue<>(max);
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        int temp=arr[k];
        int reps=0;
        for(int i=0;i<n;i++)
        {
            pq.add(arr[i]);
            if(i<=k && arr[i]==temp)
            {
                reps++;
            }
        }
        int time=0;
        while (reps!=0)
        {
            if(pq.peek()==temp)
            {
                time++;
                reps--;
            }
            else
            {
                time++;
            }
            pq.poll();
        }
        System.out.println(time-1);

    }
    static class maxcompare implements Comparator<Integer>
    {

        @Override
        public int compare(Integer o1, Integer o2) {
            if(o1>o2)
            {
                return -1;
            }
            else
            {
                return 1;
            }
        }
    }
}
