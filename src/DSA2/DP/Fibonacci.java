package DSA2.DP;

import java.io.BufferedReader;

public class Fibonacci {
    public static void main(String[] args) {
        int n=45;
        int[] arr=new int[n+1];
        for(int i=0;i<=n;i++)
        {
            arr[i]=-1;
        }
        System.out.println(fibo(n,arr));
        System.out.println(fibo(n));
        System.out.println(fiboDP(n));
    }

    private static int fiboDP(int n)
    {
        int[] arr=new int[n+1];
        arr[0]=0;
        arr[1]=1;
        for(int i=2;i<=n;i++)
        {
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n];
    }

    private static int fibo(int n) {
        if(n==1 || n==0)
        {
            return n;
        }
        return fibo(n-1)+fibo(n-2);
    }
    private static int fibo(int n,int[] arr)
    {
        if(n==1 || n==0)
        {
            arr[n]=n;
            return arr[n];
        }
        if(arr[n]!=-1)
        {
            return arr[n];
        }
        arr[n]=fibo(n-1,arr)+fibo(n-2,arr);
        return arr[n];
    }
}
