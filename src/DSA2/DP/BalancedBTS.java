package DSA2.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BalancedBTS {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int mod=(int)Math.pow(10,9)+7;
        int t=Integer.parseInt(br.readLine());
        while (t>0)
        {
            System.out.println("Enter height:");
            int h=Integer.parseInt(br.readLine());
            System.out.println(calculateBST(h,mod));
            t--;
        }

    }

    private static int calculateBST(int h,int mod) {
        if(h==0 || h==1)
        {
            return 1;
        }
        int x=calculateBST(h-1,mod);
        int y=calculateBST(h-2,mod);
        long r1=(long)x*y;
        long r2=(long)x*x;
        int res1=(int)((2*r1)%mod);
        int res2=(int)(r2%mod);
        return (res1+res2)%mod;
    }
}
