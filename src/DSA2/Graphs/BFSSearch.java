package DSA2.Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSSearch {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();
        int[][] adjMat=new int[v][v];
        for(int i=0;i<e;i++)
        {
            int fv=sc.nextInt();
            int sv=sc.nextInt();
            adjMat[fv][sv]=1;
            adjMat[sv][fv]=1;
        }
        print(adjMat);
    }

    private static void print(int[][] adjMat) {
        boolean[] visited=new boolean[adjMat.length];
        printHelper(adjMat,0,visited);
    }

    private static void printHelper(int[][] adjMat, int sv, boolean[] visited) {
        Queue<Integer> q=new LinkedList<>();
        q.add(sv);
        visited[sv]=true;
        while (!q.isEmpty())
        {
            int s=q.poll();
            System.out.println(s);
            for(int i=0;i<adjMat.length;i++)
            {
                if(adjMat[s][i]==1 && !visited[i])
                {
                    q.add(i);
                    visited[i]=true;
                }
            }
        }

    }
}
