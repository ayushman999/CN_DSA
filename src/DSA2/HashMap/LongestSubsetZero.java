package DSA2.HashMap;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class LongestSubsetZero {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int[] arr=new int[size];
        for(int i=0;i<size;i++)
        {
            arr[i]=sc.nextInt();
        }
        int max=0;
        int sum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<size;i++)
        {
            sum+=arr[i];
            if(sum==0)
            {
                if(max<i)
                {
                    max=i+1;
                }
            }
            if(map.containsKey(sum))
            {
                int res=i-map.get(sum);
                if(res>max)
                {
                    max=res;
                }
            }
            else
            {
                map.put(sum,i);
            }
        }
    }
}
