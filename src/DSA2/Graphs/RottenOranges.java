package DSA2.Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public int orangesRotting(int[][] grid)
    {
        // Code here
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        int rotten=0;
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==2)
                {
                    count++;
                    rotten++;
                    q.add(new Pair(i,j));
                }
                else if(grid[i][j]==1)
                {
                    count++;
                }
            }
        }
        return check(grid,n,m,count,rotten,q);
    }

    public int check(int[][] grid,int n,int m,int count,int rotten, Queue<Pair> q)
    {
        int time=0;
        while(!q.isEmpty())
        {

            if(count==rotten)
            {
                return time;
            }
            time+=1;
            int size=q.size();
            for(int I=0;I<size;I++)
            {
                Pair p=q.poll();
                int j=p.j;
                int i=p.i;
                if(isValid(p.i+1,j,grid) && grid[i+1][j]==1)
                {
                    rotten++;
                    q.add(new Pair(i+1,j));
                    grid[i+1][j]=2;
                }
                if(isValid(i-1,j,grid) && grid[i-1][j]==1)
                {
                    rotten++;
                    q.add(new Pair(i-1,j));
                    grid[i-1][j]=2;
                }
                if(isValid(i,j+1,grid) && grid[i][j+1]==1)
                {
                    rotten++;
                    q.add(new Pair(i,j+1));
                    grid[i][j+1]=2;
                }
                if(isValid(i,j-1,grid) && grid[i][j-1]==1)
                {
                    rotten++;
                    q.add(new Pair(i,j-1));
                    grid[i][j-1]=2;
                }
            }
        }
        if(rotten==count)
        {
            return time;
        }
        else
        {
            return -1;
        }
    }

    public boolean isValid(int i,int j, int[][]grid )
    {
        return (i<grid.length && i>=0 && j<grid[0].length && j>=0);
    }
}
class Pair{
    int i;
    int j;
    Pair(int i,int j)
    {
        this.i=i;
        this.j=j;
    }
}
