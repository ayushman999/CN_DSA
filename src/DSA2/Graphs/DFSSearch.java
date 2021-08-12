package DSA2.Graphs;

import java.util.Scanner;

public class DFSSearch {
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
        for(int i=0;i< adjMat.length;i++) {
            if(!visited[i]) {
                printHelper(adjMat, i, visited);
            }
        }
    }

    private static void printHelper(int[][] adjMat, int sv, boolean[] visited) {
        System.out.println(sv);
        visited[sv]=true;
        for(int i=0;i< adjMat.length;i++)
        {
            if(adjMat[sv][i]==1 && !visited[i])
            {
                printHelper(adjMat,i,visited);
            }
        }
    }
}
