package DSA2.Graphs.Algos;

import java.util.*;

public class DijkstraAlgo {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();

        ArrayList<ArrayList<ArrayList<Integer>>> adjacent=new ArrayList<>();
        for(int i=0;i<v;i++)
        {
            adjacent.add(new ArrayList<>());
        }
        for(int i=0;i<e;i++)
        {
            int fv=sc.nextInt();
            int lv=sc.nextInt();
            int wv=sc.nextInt();
            ArrayList<Integer> a=new ArrayList<>();
            a.add(fv);
            a.add(wv);
            ArrayList<Integer> b=new ArrayList<>();
            b.add(lv);
            b.add(wv);
            adjacent.get(fv).add(b);
            adjacent.get(lv).add(a);
        }

        check(adjacent);
    }

    private static void check(ArrayList<ArrayList<ArrayList<Integer>>> adjacent) {
        boolean[] visited=new boolean[adjacent.size()];
        int[] distance=new int[adjacent.size()];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[0]=0;
        for(int i=0;i< adjacent.size();i++)
        {
            int min=getMin(visited,distance);
            visited[min]=true;

            ArrayList<ArrayList<Integer>> arr= adjacent.get(min);
            for(ArrayList<Integer> list:arr)
            {
                if(!visited[list.get(0)])
                {
                    int d=distance[min]+list.get(1);
                    if(distance[list.get(0)]>d)
                    {
                        distance[list.get(0)]=d;
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
