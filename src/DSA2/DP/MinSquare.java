package DSA2.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinSquare {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while (t>0)
        {
            System.out.println("Daal de");
            int n=Integer.parseInt(br.readLine());
            int[] arr=new int[n+1];
            arr[1]=1;
            arr[2]=2;
            arr[3]=3;
            System.out.println(check(n,n,arr));
            System.out.println(checkDP(n));
            System.out.println(check(n,0));
            t--;
        }

    }

    private static int check(int n,int k,int[] arr)
    {
        //Using memoization
        int min=Integer.MAX_VALUE;
        if(k==0)
        {
            return 1;
        }
        for(int i=1;i<=n;i++)
        {
            if((k-(i*i))>0)
            {
                if(arr[k-i*i]!=0 && min>arr[k-i*i])
                {
                    int t=arr[k-i*i]+1;
                    if(min>t) {
                        arr[k] = arr[k - i * i] + 1;
                        min = arr[k];
                    }
                }
                else
                {
                    int j=check(n,k-i*i,arr);
                    if(min>j)
                    {
                        arr[k-i*i]=j;
                        min=arr[k-i*i]+1;
                    }
                }
            }
            else if((k-i*i)<0)
            {
                return min;
            }
            else if((k-i*i)==0)
            {
                return 1;
            }
        }

        return min;
    }

    private static int check(int n,int k){
        int min=Integer.MAX_VALUE;
        if(k==n)
        {
            return 1;
        }
        for(int i=1;i<=n;i++)
        {
            if((k+(i*i))<n) {
                int r = check(n, k+(i * i))+1;
                if(min>r)
                {
                    min=r;
                }
            }
            else if((k+(i*i))==n)
            {
                return 1;
            }
            else {
                return min;
            }
        }
        return min;
    }

    private static int checkDP(int n)
    {   //DP solution
        int[] arr=new int[n+1];
        arr[1]=1;
        arr[2]=2;
        arr[3]=3;
        for(int k=4;k<=n;k++)
        {
            int min=arr[k-1]+1;
            for(int i=1;i<=n;i++)
            {
                int sub=k-i*i;
                if(sub>0)
                {
                    int res=arr[sub]+1;
                    if(res<min)
                    {
                        min=res;
                        arr[k]=min;
                    }
                }
                else if(sub==0)
                {
                    arr[k]=1;
                    min=1;
                }
                else
                {
                    break;
                }
            }
            arr[k]=min;
        }
        return arr[n];
    }
}
