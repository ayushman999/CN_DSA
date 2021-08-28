package DSA2.Graphs.Algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FloydWarshall {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();
        int[][] adj=new int[v][v];
        for(int i=0;i<v;i++)
        {
            Arrays.fill(adj[i],Integer.MAX_VALUE);
            adj[i][i]=0;
        }
        for(int i=0;i<e;i++)
        {
            int fv=sc.nextInt();
            int lv=sc.nextInt();
            int wv=sc.nextInt();
            adj[fv][lv]=wv;
        }
        check(adj,v);
        for(int i=0;i<v;i++)
        {
            for(int j=0;j<v;j++)
            {
                System.out.println(i+" -> "+j+": "+adj[i][j]);
            }
        }
    }

    private static void check(int[][] adj, int v) {
        for(int k=0;k<v;k++)
        {
            for(int i=0;i<v;i++)
            {
                for(int j=0;j<v;j++)
                {
                    if(adj[i][k]==Integer.MAX_VALUE || adj[k][j]==Integer.MAX_VALUE)
                    {
                        continue;
                    }
                    int d=adj[i][k]+adj[k][j];
                    if(adj[i][j]>d)
                    {
                        adj[i][j]=d;
                    }
                }
            }
        }
    }
}
