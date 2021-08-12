package DSA2.DP;

import java.util.HashMap;
import java.util.Scanner;

public class LCS {
    public static void main(String[] args) {
        String a="adgeiabegiabegiabegiadgeiadgei";
        String b="abegiadgeiadgeiabegiadgeiadgei";
        String a1="adgei";
        String b1="abegi";
        int[][] arr=new int[a.length()+1][b.length()+1];
        for(int i=0;i<=a.length();i++)
        {
            for(int j=0;j<=b.length();j++)
            {
                arr[i][j]=-1;
            }
        }
        System.out.println(checkLCS(a,b,arr));
        System.out.println(checkDP(a,b));
        System.out.println(checkLCS(a,b));
    }

    private static int checkDP(String a,String b)
    {
        //through DP
        int[][] arr=new int[a.length()+1][b.length()+1];
        for(int i=1;i<=a.length();i++)
        {
            arr[i][1]=0;
        }
        for(int i=1;i<=b.length();i++)
        {
            arr[1][i]=0;
        }
        for(int i=1;i<=a.length();i++)
        {
            for(int j=1;j<=b.length();j++)
            {
                char m=a.charAt(a.length()-i);
                char n=b.charAt(b.length()-j);
                if(m==n)
                {
                    arr[i][j]=1+arr[i-1][j-1];
                }
                else
                {
                    int x=arr[i-1][j];
                    int y=arr[i][j-1];
                    arr[i][j]=Math.max(x,y);
                }
            }
        }

        return arr[a.length()][b.length()];
    }

    private static int checkLCS(String a, String b, int[][] arr)
    {
        //memoization using a matrix
        int x=a.length();
        int y=b.length();
        if(x==0 || y==0)
        {
            arr[x][y]=0;
            return 0;
        }
        if(arr[x][y]!=-1)
        {
            return arr[x][y];
        }
        char i=a.charAt(0);
        char j=b.charAt(0);
        if(i==j)
        {
            arr[x][y]=1+checkLCS(a.substring(1),b.substring(1),arr);
            return arr[x][y];
        }
        else
        {
            int m=checkLCS(a.substring(1),b,arr);
            int n=checkLCS(a,b.substring(1),arr);
            arr[x][y]=Math.max(m,n);
            return arr[x][y];
        }
    }

    private static int checkLCS(String a, String b) {
        if(a.length()==0 || b.length()==0)
        {
            return 0;
        }
        char a1=a.charAt(0);
        char a2=b.charAt(0);
        if(a1==a2)
        {
            return 1+checkLCS(a.substring(1),b.substring(1));
        }
        else
        {
            int x=checkLCS(a,b.substring(1));
            int y=checkLCS(a.substring(1),b);
            return Math.max(x,y);
        }
    }
}
