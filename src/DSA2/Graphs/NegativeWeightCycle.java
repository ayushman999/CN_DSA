package DSA2.Graphs;


import java.util.Scanner;

public class NegativeWeightCycle {
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
        }
        System.out.println(isNegativeWeightCycle(v,adj));

    }

    private static int isNegativeWeightCycle(int n, int[][] edges) {
         boolean[] visited=new boolean[n];
         int i=checkEdges(visited,edges,)

    }
    public static int check(boolean[] visited, int[][] edges, int sum, int index,int parent)
    {
        visited[index]=true;
        for(int i=0;i<visited.length;i++)
        {
            if(edges[index][i]!=0 && visited[i] && i!=parent)
            {
                return sum;
            }
            if(!visited[i] && edges[index][i]!=0)
            {
                sum=check(visited,edges,sum,i,index);
                if(sum==Integer.MAX_VALUE)
                {
                    return 0;
                }
                sum=sum+edges[index][i];
                if(sum<0)
                {
                    return sum;
                }
            }

        }
        return Integer.MAX_VALUE;
    }
}
