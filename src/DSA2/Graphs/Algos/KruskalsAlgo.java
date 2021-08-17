package DSA2.Graphs.Algos;

import DSA2.PriorityQueue.PQMin;

import java.util.*;

public class KruskalsAlgo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();
        int[][] adj=new int[v][v];
        PriorityQueue<Triplets> pq=new PriorityQueue<>(new compareTriplets());

        for(int i=0;i<e;i++)
        {
            boolean[] visited=new boolean[v];
            int fv=sc.nextInt();
            int lv=sc.nextInt();
            int wv=sc.nextInt();
            adj[fv][lv] = wv;
            adj[lv][fv] = wv;
            pq.add(new Triplets(fv, lv, wv));
        }
        int[][] result=check(adj,pq);



    }

    private static int[][] check(int[][] adj, PriorityQueue<Triplets> pq) {
        int[][] arr=new int[adj.length][adj.length];
        int count=0;
        while (!pq.isEmpty())
        {
            Triplets t=pq.poll();
            boolean[] visited=new boolean[adj.length];
            arr[t.sv][t.ev]=t.wv;
            arr[t.ev][t.sv]=t.wv;
            if(isCircular(arr,visited,-1,t.sv))
            {
                arr[t.sv][t.ev]=0;
                arr[t.ev][t.sv]=0;
            }
            else
            {
                count++;
            }
            if(count==arr.length-1)
            {
                return arr;
            }
        }
        return arr;
    }

    static class Triplets{
        int sv;
        int ev;
        int wv;

        public Triplets(int sv, int ev, int wv) {
            this.sv = sv;
            this.ev = ev;
            this.wv = wv;
        }
    }

    static boolean isCircular(int[][] adj,boolean[] visited,int parent,int head)
    {
        visited[head]=true;
        boolean t=false;
        for(int i=0;i<adj.length;i++)
        {
            if(adj[head][i]!=0 && visited[i])
            {
                if(i!=parent)
                {
                    return true;
                }
            }
            else if(adj[head][i]!=0 && !visited[i])
            {

                t=isCircular(adj,visited,head,i);
                if(t)
                {
                    return t;
                }
            }
        }
        return t;
    }
}
class compareTriplets implements Comparator<KruskalsAlgo.Triplets>
{

    @Override
    public int compare(KruskalsAlgo.Triplets o1, KruskalsAlgo.Triplets o2) {
        if(o1.wv>=o2.wv)
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }
}
