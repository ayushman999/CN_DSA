package DSA2.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class SubsetSum {
    public static void main(String[] args) {
        int[] arr={10,2,-2,-20,10,12};
        int size=arr.length;
        calculate(arr,size,-10);
    }

    private static void calculate(int[] arr, int size,int k) {
        HashMap<Integer, ArrayList<Integer>> map=new HashMap<>();
        int s=0;
        for(int i=0;i<size;i++)
        {
            s+=arr[i];
            if(map.containsKey(s))
            {
                ArrayList<Integer> list=map.get(s);
                list.add(i);
                map.replace(s,list);
            }
            else
            {
                ArrayList<Integer> list=new ArrayList<>();
                list.add(i);
                map.put(s,list);
            }
        }
        Set<Integer> paths=map.keySet();
        int res=0;
        for(int key:paths)
        {
            if(key==k)
            {
                res++;
                continue;
            }
            int r=key-k;
            if(map.containsKey(r))
            {
                ArrayList<Integer> list=map.get(r);
                for(int l:list)
                {

                }
            }
        }
    }
}
