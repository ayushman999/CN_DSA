package DSA2.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LootHouse {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int[] house={5,5,10,100,10,5};
        int[][] storage=new int[house.length+1][3];
        for(int i=0;i<=house.length;i++) {
            for (int j = 0; j <= 2; j++)
                storage[i][j] = -1;
        }
        for(int i=0;i<=house.length;i++)
        {
            storage[i][0]=0;
        }
        for(int j=0;j<=2;j++)
        {
            storage[0][j]=0;
        }
        System.out.println(checkDP(house));
        System.out.println(check(house,2,1,storage));
        System.out.println(check(house,2,0));
    }

    private static int checkDP(int[] house)
    {
        //DP approach
        int[][] storage=new int[house.length+1][3];
        for(int i=house.length;i>=1;i--)
        {
            for(int j=1;j<=2;j++)
            {
                if(i==house.length)
                {
                    storage[i][j]=house[i-1];
                    continue;
                }
                int x=storage[i+1][j-1]+house[i-1];
                int y=storage[i+1][j];
                storage[i][j]=Math.max(x,y);
            }
        }
        return storage[1][2];
    }

    private static int check(int[] house,int n,int i,int[][] storage)
    {
        //memoization
        if(n==0 || i>house.length)
        {
            return 0;
        }
        if(storage[i][n]!=-1)
        {
            return storage[i][n];
        }
        else
        {
            int x=house[i-1]+check(house,n-1,i+1,storage);
            int y=check(house,n,i+1,storage);
            storage[i][n]=Math.max(x,y);
            return storage[i][n];
        }
    }

    private static int check(int[] house,int n,int i) {
        //recursive approach
        if(n==0 || i>house.length-1)
        {
            return 0;
        }
        int x=house[i]+check(house,n-1,i+1);
        int y=check(house,n,i+1);
        int max=Math.max(x,y);
        return max;
    }
}
