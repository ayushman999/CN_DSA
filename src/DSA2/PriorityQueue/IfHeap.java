package DSA2.PriorityQueue;

import java.util.Scanner;

public class IfHeap {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println(check(arr,0));

    }

    private static boolean check(int[] arr, int parent) {
        int childX=2*parent+1;
        int childY=2*parent+2;
        int size=arr.length;
        if (childX<size) {
            if (childY < size) {
                if (arr[parent] > arr[childX] || arr[parent] > arr[childY]) {
                    return false;
                }
            }
            boolean istrue = check(arr, childX);
            istrue &= check(arr,childY);
            return istrue;
        }
        return true;
    }
}
