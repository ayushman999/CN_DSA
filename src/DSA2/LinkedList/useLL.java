package DSA2.LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class useLL {
    public static void main(String[] args) {
        LinkedList<Integer> ll=new LinkedList<>();
        ll=insert();
        print(ll);
        ll.add(4,69);
        print(ll);
    }

    private static void print(LinkedList<Integer> ll) {
        for(int i=0;i<ll.size();i++)
        {
            System.out.print(ll.get(i)+" ");
        }
        System.out.println();
    }

    private static LinkedList<Integer> insert() {
        LinkedList<Integer> ll=new LinkedList<>();
        Scanner sc=new Scanner(System.in);
        int data=sc.nextInt();
        while (data!=-1)
        {
            ll.add(data);
            data=sc.nextInt();
        }
        return ll;
    }
}
