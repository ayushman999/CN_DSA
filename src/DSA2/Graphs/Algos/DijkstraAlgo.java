package DSA2.Graphs.Algos;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DijkstraAlgo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();
        int[][] adj=new int[v][v];
        for(int i=0;i<e;i++)
        {
            int fv=sc.nextInt();
            int lv=sc.nextInt();
            int wv=sc.nextInt();
            adj[fv][lv]=wv;
            adj[lv][fv]=wv;
        }
        check(adj);
    }

    private static void check(int[][] adj) {
        boolean[] visited=new boolean[adj.length];
        int[] distance=new int[adj.length];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[0]=0;
        for(int i=0;i< adj.length;i++)
        {
            int min=getMin(visited,distance);
            visited[min]=true;
            for(int j=0;j<adj.length;j++)
            {
                if(adj[min][j]!=0 && !visited[j])
                {
                    int d=distance[min]+adj[min][j];
                    if(distance[j]>d)
                    {
                        distance[j]=d;
                    }
                }
            }
        }
    }

    private static int getMin(boolean[] visited, int[] distance) {
        int min=-1;
        for(int i=0;i<distance.length;i++)
        {
            if(min==-1 && visited[i])
            {
                continue;
            }
            else if(min==-1 && !visited[i])
            {
                min=i;
                continue;
            }
            if(distance[i]<distance[min])
            {
                min=i;
            }
        }
        return min;
    }
}
