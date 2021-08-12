package DSA2.PriorityQueue;

import java.util.PriorityQueue;
import java.util.Scanner;

public class RunningMedian {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //For input
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        // Let's start with the logic part

        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(new MaxCom());

        for (int i = 0; i < n; i++)
        {
            if(max.isEmpty() || max.peek()>arr[i])
            {
                max.add(arr[i]);
            }
            else
            {
                min.add(arr[i]);
            }
            if(max.size()>(min.size()+1))
            {
                min.add(max.poll());
            }
            else if(min.size()>(max.size()+1))
            {
                max.add(min.poll());
            }
            if(max.size()>min.size())
            {
                System.out.println(max.peek());
            }
            else if(min.size()>max.size())
            {
                System.out.println(min.peek());
            }
            else
            {
                System.out.println((max.peek()+min.peek())/2);
            }

        }
    }
}
