package DSA2.DP;

public class EditDistance {
    public static void main(String[] args) {
        String a="yhbnlkjdsflksa";
        String b="ihgblkasdjflff";
        int[][] arr=new int[a.length()+1][b.length()+1];
        for(int i=0;i<=a.length();i++)
        {
            arr[i][0]=i;
        }
        for(int i=0;i<=b.length();i++)
        {
            arr[0][i]=i;
        }
        System.out.println(checkDP(a,b));
        System.out.println(check(a,b,arr));
        System.out.println(check(a,b));
    }

    private static int checkDP(String a,String b)
    {
        int[][] arr=new int[a.length()+1][b.length()+1];
        for(int i=0;i<=a.length();i++)
        {
            arr[i][0]=i;
        }
        for(int i=0;i<=b.length();i++)
        {
            arr[0][i]=i;
        }
        for(int i=1;i<=a.length();i++)
        {
            for(int j=1;j<=b.length();j++)
            {
                char x=a.charAt(a.length()-i);
                char y=b.charAt(b.length()-j);
                int m=arr[i][j-1];
                int n=arr[i-1][j];
                int o=arr[i-1][j-1];
                int min=Math.min(m,Math.min(n,o));
                if(x==y)
                {
                    arr[i][j]=min;
                }
                else {

                    arr[i][j] = min + 1;
                }
            }
        }
        return arr[a.length()][b.length()];
    }

    private static int check(String a,String b,int[][] arr)
    {
        int i=a.length();
        int j=b.length();
        if(i==0 && j==0)
        {
            return 0;
        }
        if(arr[i][j]!=0)
        {
            return arr[i][j];
        }
        else
        {

            if(a.charAt(0)==b.charAt(0))
            {
                arr[i][j]=check(a.substring(1),b.substring(1));
                return arr[i][j];
            }
            else
            {
                //delete
                int m=check(a.substring(1),b,arr);
                //insert
                int n=check(a,b.substring(1),arr);
                //substitute
                int o=check(a.substring(1),b.substring(1),arr);
                arr[i][j]=1+Math.min(m,Math.min(n,o));
                return arr[i][j];
            }
        }
    }

    private static int check(String a, String b) {
        if(a.length()==0)
        {
            return b.length();
        }
        else if(b.length()==0)
        {
            return a.length();
        }
        char x=a.charAt(0);
        char y=b.charAt(0);
        if(x==y)
        {
            int res=check(a.substring(1),b.substring(1));
            return res;
        }
        //insert
        int m=check(a.substring(1),b);
        //delete
        int n=check(a,b.substring(1));
        //substitute
        int o=check(a.substring(1),b.substring(1));
        return 1+Math.min(m,Math.min(n,o));
    }
}
