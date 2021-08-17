package DSA2.DP;

public class AllPossibleWays {

    public static void main(String[] args) {
        int i=5;
        System.out.println(check(i));
    }

    private static int check(int i) {
        if(i==0)
        {
            return 1;
        }
        int count=0;
        for(int j=1;j<=i;j++)
        {
            if(j*j<=i)
            {
                count+=check(i-j*j);
            }
            else
            {
                return count;
            }
        }
        return count;
    }
}

