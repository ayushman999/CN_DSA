package DSA2.Graphs;

import java.util.*;

public class HasPath {
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
        System.out.println("Enter starting node");
        int sn=sc.nextInt();
        System.out.println("Enter ending node");
        int en=sc.nextInt();
        printIfPossible(adj,sn,en);
        getPathBFS(adj,sn,en);
    }

    private static void getPathBFS(int[][] adj,int sn, int en)
    {
        boolean[] visited=new boolean[adj.length];
        System.out.println(getPathBFSHelper(adj,sn,en,visited));
    }

    private static ArrayList<Integer> getPathBFSHelper(int[][] adj, int sn, int en, boolean[] visited) {
        HashMap<Integer,Integer> map=new HashMap<>();
        Queue<Integer> q=new LinkedList<>();
        ArrayList<Integer> result=new ArrayList<>();
        q.add(sn);
        visited[sn]=true;
        while (!q.isEmpty())
        {
            int s=q.poll();
            if(adj[s][en]==1)
            {
                result.add(en);
                map.put(en,s);
                break;
            }
            for(int i=0;i< adj.length;i++)
            {
                if(adj[s][i]==1 && !visited[i])
                {
                    q.add(i);
                    visited[i]=true;
                    map.put(i,s);
                }
            }
        }
        if(!result.isEmpty())
        {
            int r=result.get(0);
            while (r!=0)
            {
                r=map.get(r);
                result.add(0,r);
            }
        }
        return result;
    }

    private static void getPathDFS(int[][] adj, int sn, int en) {
        boolean[] visited=new boolean[adj.length];
        System.out.println(getPathHelper(adj,sn,en,visited));
    }

    private static ArrayList<Integer> getPathHelper(int[][] adj, int sn, int en, boolean[] visited) {
        if(adj[sn][en]==1)
        {
            ArrayList<Integer> list=new ArrayList<>();
            list.add(en);
            return list;
        }
        visited[sn]=true;
        for(int i=0;i<adj.length;i++)
        {

            if(adj[sn][i]==1 && !visited[i])
            {
                visited[i]=true;
                ArrayList<Integer> result=getPathHelper(adj,i,en,visited);
                if(result!=null) {
                    result.add(0, i);
                    return result;
                }
            }
        }
        return null;
    }

    private static void printIfPossible(int[][] adj, int sn, int en) {
        boolean[] visited=new boolean[adj.length];
        System.out.println(printHelper(adj,sn,en,visited));
    }

    private static boolean printHelper(int[][] adj, int sn, int en, boolean[] visited) {
        if(adj[sn][en]==1)
        {
            return true;
        }
        visited[sn]=true;
        for(int i=0;i<adj.length;i++)
        {
            if(adj[sn][i]==1 && !visited[i])
            {
                return printHelper(adj,i,en,visited);
            }
        }
        return false;
    }
}
