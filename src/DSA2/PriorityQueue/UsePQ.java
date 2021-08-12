package DSA2.PriorityQueue;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class UsePQ {
    public static void main(String[] args) throws PQEmptyException {
        Scanner sc=new Scanner(System.in);
        int data=sc.nextInt();
        ArrayList<Integer> list=new ArrayList<>();
        while (data!=-1)
        {
            list.add(data);
            data=sc.nextInt();
        }
        list=new InPlaceSort().inplacesort(list);
        System.out.println(list);
        PQMin pq=new PQMin();
        pq.setHeap(list);
        while (!pq.isEmpty())
        {
            System.out.print(pq.deleteMin()+" ");
        }

    }
}
