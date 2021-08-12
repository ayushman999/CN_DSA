package DSA2.DP;

public class KnapSack {
    public static void main(String[] args) {
        int[] weight= {1,2,4,5};
        int[] value={5,4,8,6};
        int max=5;
        int[][] storage=new int[weight.length+1][max+1];
        for(int i=0;i<=weight.length;i++) {
            for (int j = 0; j <= max; j++) {
                storage[i][j] = -1;
            }
        }
        for(int i=0;i<=max;i++)
        {
            storage[0][i]=0;
        }
        for(int j=0;j<=weight.length;j++)
        {
            storage[j][0]=0;
        }
        System.out.println(checkDP(weight,value,max));
        System.out.println(check(weight,value,max,1,storage));
        System.out.println(check(weight,value,max,0));
    }

    private static int checkDP(int[] weight,int[] value,int max)
    {
        int[][] storage=new int[weight.length+1][max+1];
        for(int i=weight.length;i>=1;i--)
        {
            for(int j=1;j<=max;j++)
            {
                if(i==weight.length )
                {
                    if(weight[i-1]<=j)
                    {
                        storage[i][j]=value[i-1];
                    }
                    continue;
                }
                if(weight[i-1]<=j)
                {
                    int x=storage[i+1][j-weight[i-1]]+value[i-1];
                    int y=storage[i+1][j];
                    storage[i][j]=Math.max(x,y);
                }

            }
        }
        return storage[1][max];
    }

    private static int check(int[] weight, int[] value,int max,int i,int[][] storage)
    {
        int m=weight.length;
        int n=storage[0].length;
        if(i>m || max<=0)
        {
            return 0;
        }
        if(storage[i][max]!=-1)
        {
            return storage[i][max];
        }
        else
        {
            if(weight[i-1]<=max)
            {
                int x=value[i-1]+check(weight,value,max-weight[i-1],i+1,storage);
                int y=check(weight,value,max,i+1,storage);
                storage[i][max]=Math.max(x,y);
                return storage[i][max];
            }
            else
            {
                storage[i][max]=check(weight,value,max,i+1,storage);
                return storage[i][max];
            }
        }
    }

    private static int check(int[] weight, int[] value, int max, int i) {
        //recursion
        if(i>=value.length)
        {
            return 0;
        }
        if(weight[i]<max)
        {
            int x=value[i]+check(weight,value,max-weight[i],i+1);
            int y=check(weight,value,max,i+1);
            return Math.max(x,y);
        }
        else if(weight[i]==max)
        {
            return value[i];
        }
        else
        {
            int x= check(weight,value,max,i+1);
            return x;
        }

    }
}
