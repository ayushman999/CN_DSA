package DSA2.Graphs.Algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BellmanFord {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<ArrayList<ArrayList<Integer>>> adj=new ArrayList<>();
        int v=sc.nextInt();
        int e=sc.nextInt();
        ArrayList<Edge> edge=new ArrayList<>();
        for(int i=0;i<v;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<e;i++)
        {
            int sv=sc.nextInt();
            int ev=sc.nextInt();
            int wv=sc.nextInt();
            ArrayList<Integer> list=new ArrayList<>();
            list.add(ev);
            list.add(wv);
            ArrayList<Integer> list1=new ArrayList<>();
            list1.add(sv);
            list1.add(wv);
            adj.get(ev).add(list1);
            adj.get(sv).add(list);
            edge.add(new Edge(sv,ev,wv));
        }
        check(v,edge);
    }

    private static void check( int v,ArrayList<Edge> edge) {

        int[] distance=new int[v];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[0]=0;
        for(int i=1;i<v;i++)
        {
            for(int j=0;j<edge.size();j++)
            {
                Edge p=edge.get(j);
                int sv=p.sv;
                int ev=p.ev;
                int d= distance[sv]+p.weight;
                if(d<distance[ev])
                {
                    distance[ev]=d;
                }
            }
        }
    }

}
class Edge{
    int sv,ev,weight;

    public Edge(int sv, int ev, int weight) {
        this.sv = sv;
        this.ev = ev;
        this.weight = weight;
    }
}
