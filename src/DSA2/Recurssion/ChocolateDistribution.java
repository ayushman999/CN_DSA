package DSA2.Recurssion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ChocolateDistribution {
    public static void main(String[] args) {
        ArrayList<Long> arr=new ArrayList<>();
        arr.add(3L);
        arr.add(4L);
        arr.add(1L);
        arr.add(9L);
        arr.add(56L);
        arr.add(7L);
        arr.add(9L);
        arr.add(12L);
        int k=5;
        System.out.println(check(arr,k));
    }

    private static long check(ArrayList<Long> arr, long k) {
        long diff=Long.MAX_VALUE;
        Collections.sort(arr);
        for(Long i=0l;i<arr.size()-k+1;i++)
        {
            if(diff>(arr.get((int) (i+k-1l))-arr.get(Math.toIntExact(i))))
            {
                diff=arr.get((int) (i+k-1))-arr.get(Math.toIntExact(i));
            }
        }
        return diff;
    }
}
