package DSA2.Graphs.Algos;

import DSA2.PriorityQueue.PQMin;

import java.util.*;

public class KruskalsAlgo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();
        PriorityQueue<Triplets> pq=new PriorityQueue<>(new compareTriplets());

        for(int i=0;i<e;i++)
        {
            int fv=sc.nextInt();
            int lv=sc.nextInt();
            int wv=sc.nextInt();
            pq.add(new Triplets(fv, lv, wv));
        }
/*
        int[][] result=check(v,pq);
*/
        int[][] betterResult=checkCN(v,pq);

    }

    private static int[][] checkCN(int v, PriorityQueue<Triplets> pq) {
        //union find algorithm
        int[][] arr=new int[v][v];
        int[] parent=new int[v];
        for(int i=0;i<v;i++)
        {
            parent[i]=i;
        }
        while (!pq.isEmpty())
        {
            Triplets triplets=pq.poll();
            if(!cyclic(triplets,parent))
            {
                int s=triplets.sv;
                int e=triplets.ev;
                int w=triplets.wv;
                arr[s][e]=w;
                arr[e][s]=w;
            }
        }
        return arr;
    }
    private static boolean cyclic(Triplets triplets, int[] parent) {
        int v1=triplets.sv;
        int v2=triplets.ev;
        int a=parent[v1];
        while (a!=parent[a])
        {
            a=parent[a];
        }
        int p1=a;
        a=parent[v2];
        while (a!=parent[a])
        {
            a=parent[a];
        }
        int p2=a;
        if(p1==p2)
        {
            return true;
        }
        else
        {
            parent[v2]=p1;
            return false;
        }

    }

    private static int[][] check(int e, PriorityQueue<Triplets> pq) {
        int[][] arr=new int[e][e];
        int count=0;
        while (!pq.isEmpty())
        {
            Triplets t=pq.poll();
            boolean[] visited=new boolean[e];
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
