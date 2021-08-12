package DSA2.Recurssion;

import java.sql.Array;
import java.util.ArrayList;

public class SubsetArray {
    public static void main(String[] args) {
        int[] arr={15,20,12};
        /*check(arr,0,"");*/
        String[] result=getResult(arr,0);
        for(String item:result)
        {
            System.out.println(item);
        }
    }

    private static String[] getResult(int[] arr, int i) {
        if(i==arr.length)
        {
            String[] result=new String[1];
            result[0]="";
            return result;
        }
        String[] res=getResult(arr,i+1);
        String[] result=new String[res.length*2];
        int k=0;
        for(int j=0;j<res.length;j++)
        {
            result[k]=res[j];
            k++;
        }
        for(;k<result.length;k++)
        {
            result[k]=arr[i]+" "+res[k-res.length];
        }
        return result;
    }


    private static void check(int[] arr, int i,String result) {
        if(i==arr.length)
        {
            System.out.println(result);
            return;
        }
        check(arr,i+1,result+arr[i]+" ");
        check(arr,i+1,result);
    }
}
