package DSA2.Graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class SeperatedGraph {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();
        int[][] adj=new int[v][v];
        for(int i=0;i<e;i++)
        {
            int sv=sc.nextInt();
            int ev=sc.nextInt();
            adj[sv][ev]=1;
            adj[ev][sv]=1;
        }
        System.out.println(printAll(adj));
    }

    private static ArrayList<ArrayList<Integer>> printAll(int[][] adj) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        boolean[] visited=new boolean[adj.length];
        for(int i=0;i<adj.length;i++)
        {
            if(!visited[i])
            {
                ArrayList<Integer> l=printAllHelper(adj,i,visited);
                list.add(l);
            }
        }
        return list;
    }

    private static ArrayList<Integer> printAllHelper(int[][] adj,int sv, boolean[] visited) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<adj.length;i++) {
            if (adj[sv][i] == 1 && !visited[i]) {
                visited[i] = true;
                list.addAll(printAllHelper(adj, i, visited));
                list.add(i);
            }
        }

        return list;
    }

}
