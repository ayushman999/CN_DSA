package DSA2.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinSteps {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[n+1];
        System.out.println(checkRecursive(n,arr));
        System.out.println(checkDp(n));
        System.out.println(checkRecursive(n));
    }

    private static int checkRecursive(int n,int[] arr)
    {
        if(n==1)
        {
            arr[n]=0;
            return arr[n];
        }
        int min=Integer.MAX_VALUE;
        if(arr[n-1]!=0)
        {
            min=arr[n-1];
        }
        else
        {
            min=checkRecursive(n-1,arr);
        }
        if(n%3==0)
        {
            if(arr[n/3]!=0 && min>arr[n/3])
            {
                min=arr[n/3];
            }
            else
            {
                int s=checkRecursive(n/3,arr);
                if(min>s)
                {
                    min=s;
                }
            }
        }
        if((n&1)==0)
        {
            if(arr[n/2]!=0 && min>arr[n/2])
            {
                min=arr[n/2];
            }
            else
            {
                int s=checkRecursive(n/2,arr);
                if(min>s)
                {
                    min=s;
                }
            }
        }
        arr[n]=min+1;
        return arr[n];

    }

    private static int checkRecursive(int n) {
        if(n==1)
        {
            return 0;
        }
        int s1=Integer.MAX_VALUE;
        int s2=Integer.MAX_VALUE;
        int s3=Integer.MAX_VALUE;
        if((n%3)==0)
        {
            s1=checkRecursive(n/3);
        }
        if((n&1)==0)
        {
            s2=checkRecursive(n/2);
        }
        s3=checkRecursive(n-1);
        return Math.min(s1,Math.min(s2,s3))+1;
    }

    private static int checkDp(int n)
    {
        int[] arr=new int[n+1];
        arr[1]=0;
        for(int i=2;i<=n;i++)
        {
            int min=arr[i-1];
            if(i%3==0)
            {
                if(arr[i/3]<min)
                {
                    min=arr[i/3];
                }
            }
            if(i%2==0)
            {
                if(arr[i/2]<min)
                {
                    min=arr[i/2];
                }
            }
            arr[i]=min+1;
        }
        return arr[n];
    }
}
