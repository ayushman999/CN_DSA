package DSA2.DP;

public class LongesIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr={2,13,52,52,3,24,42,24,5,66,2,23,92,13,52,52,3,24,42,24,5,66,2,23,9};
        int[][] storage=new int[arr.length+1][arr.length+1];
        for(int i=0;i<=arr.length;i++)
        {
            for(int j=0;j<=arr.length;j++)
            {
                storage[i][j]=-1;
            }
        }
        for(int i=0;i<=arr.length;i++)
        {
            storage[0][i]=0;
            storage[i][0]=0;
        }
        System.out.println(checkDP(arr));
        System.out.println(check(-1,1,0,arr,storage));
        System.out.println(check(0,0,arr));
    }

    private static int checkDP(int[] arr)
    {
        int[][] storage=new int[arr.length+1][arr.length+1];
        for(int i=arr.length;i>=1;i--)
        {
            for(int j=0;j<i;j++)
            {
                if(i==arr.length)
                {
                    if(j!=0 && arr[i-1]<arr[j-1])
                    {
                        storage[i][j]=0;
                        continue;
                    }
                    else {
                        storage[i][j]=1;
                        continue;
                    }
                }
                if(j==0)
                {
                    int x=storage[i+1][i]+1;
                    int y=storage[i+1][0];
                    storage[i][j]=Math.max(x,y);
                }
                else
                {
                    int prev=arr[j-1];
                    if(arr[i-1]<prev)
                    {
                        storage[i][j]=storage[i+1][j];
                    }
                    else
                    {
                        int x=storage[i+1][i]+1;
                        int y=storage[i+1][j];
                        storage[i][j]=Math.max(x,y);
                    }
                }
            }
        }
        return storage[1][0];
    }

    private static int check(int prev,int i,int j,int[] arr,int[][] storage)
    {
        //memoization
        if((i-1)==arr.length)
        {
            return 0;
        }
        if(prev!=-1 && storage[i][j]!=-1)
        {
            return storage[i][j];
        }
        else
        {
            if(prev==-1 || prev<=arr[i-1])
            {
                int x=1+check(arr[i-1],i+1,i,arr,storage);
                int y=check(prev,i+1,j,arr,storage);
                if(prev!=-1) {
                    storage[i][j] = Math.max(x, y);
                    return storage[i][j];
                }
                else
                {
                    storage[i][0]=Math.max(x,y);
                    return storage[i][0];
                }

            }
            else
            {
                storage[i][j]= check(prev,i+1,j,arr,storage);
                return storage[i][j];
            }
        }
    }

    private static int check(int prev, int i, int[] arr) {
        //recursion
        if(i==arr.length)
        {
            return 0;
        }
        if(prev==-1 || prev<=arr[i])
        {
            int x=1+check(arr[i],i+1,arr);
            int y=check(prev,i+1,arr);
            return Math.max(x,y);
        }
        else
        {
            return check(prev,i+1,arr);
        }
    }
}
