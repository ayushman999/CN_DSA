package DSA2.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CostPath {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int m=Integer.parseInt(br.readLine());
        int[][] arr=new int[n][m];
        for(int i=0;i<n;i++)
        {
            String[] input=br.readLine().split(" ");
            for(int j=0;j<m;j++)
            {
                arr[i][j]=Integer.parseInt(input[j]);
            }
        }
        int[][] cheap=new int[n][m];
        System.out.println(checkDP(arr));
        System.out.println(check(arr,0,0,cheap));
        System.out.println(check(arr,0,0));
    }

    private static int checkDP(int[][] arr)
    {
        int[][] cheap=new int[arr.length][arr[0].length];
        cheap[arr.length-1][arr[0].length-1]=arr[arr.length-1][arr[0].length-1];
        for(int i= arr.length-1;i>=0;i--)
        {
            for(int j=arr[0].length-1;j>=0;j--)
            {
                int e=Integer.MAX_VALUE;
                int s=Integer.MAX_VALUE;
                int d=Integer.MAX_VALUE;
                if(i==(arr.length-1) && j==(arr[0].length-1))
                {
                    cheap[i][j]=arr[i][j];
                    continue;
                }
                if(i<(arr.length-1))
                {
                    s=cheap[i+1][j];
                }
                if(j<(arr[0].length-1))
                {
                    e=cheap[i][j+1];
                }
                if(i<(arr.length-1) && j<(arr[0].length-1))
                {
                    d=cheap[i+1][j+1];
                }
                int min=Math.min(e,Math.min(s,d));
                cheap[i][j]=min+arr[i][j];
            }
        }
        return cheap[0][0];
    }

    private static int check(int[][] arr,int i,int j,int[][] cheap)
    {
        if(i==(arr.length-1) && j==(arr[0].length-1))
        {
            cheap[i][j]=arr[i][j];
            return cheap[i][j];
        }
        if(cheap[i][j]!=0)
        {
            return cheap[i][j];
        }
        int e=Integer.MAX_VALUE;
        int s=Integer.MAX_VALUE;
        int d=Integer.MAX_VALUE;
        if(i<(arr.length-1))
        {
            s=check(arr,i+1,j,cheap);
        }
        if(j<(arr[0].length-1))
        {
            e=check(arr,i,j+1,cheap);
        }
        if(i<(arr.length-1) && j<(arr[0].length-1))
        {
            d=check(arr,i+1,j+1,cheap);
        }
        int min=Math.min(e,Math.min(s,d));
        cheap[i][j]=arr[i][j]+min;
        return cheap[i][j];
    }

    private static int check(int[][] arr,int i,int j) {
        if(i==(arr.length-1) && j==(arr[0].length-1))
        {
            return arr[i][j];
        }

        int e=Integer.MAX_VALUE;
        int s=Integer.MAX_VALUE;
        int d=Integer.MAX_VALUE;
        if(i<(arr.length-1))
        {
            e=check(arr,i+1,j);
        }
        if(j<(arr[0].length-1))
        {
            s=check(arr,i,j+1);
        }
        if(i<(arr.length-1) && j<(arr[0].length-1))
        {
            d=check(arr,i+1,j+1);
        }
        return Math.min(Math.min(e,s),d)+arr[i][j];
    }
}
