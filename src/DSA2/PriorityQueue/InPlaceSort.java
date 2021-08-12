package DSA2.PriorityQueue;

import java.util.ArrayList;

public class InPlaceSort {

    public ArrayList<Integer> inplacesort(ArrayList<Integer> list)
    {
        for(int i=0;i<list.size();i++)
        {
            int child=i;
            int parent=(child-1)/2;
            while (child>0)
            {
                if(list.get(child)<list.get(parent))
                {
                    int temp=list.get(child);
                    list.set(child,list.get(parent));
                    list.set(parent,temp);
                    child=parent;
                    parent=(child-1)/2;
                }
                else
                {
                    break;
                }
            }
        }
        return list;
    }

}
