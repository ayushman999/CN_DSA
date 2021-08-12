package DSA2.HashMap;




import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class LongestConse {
    public static void main(String[] args) {
        HashMap<Integer,Integer> map=new HashMap<>();
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        for(int i=0;i<size;i++)
        {
            int value=sc.nextInt();
            if(map.containsKey(value))
            {
                if(map.get(value)>i)
                {
                    map.replace(value,i);

                }
                continue;
            }
            map.put(value,i);
        }
        Set<Integer> paths=map.keySet();
        ArrayList<Pair<Integer,Integer>> max=new ArrayList<>();
        ArrayList<Pair<Integer,Integer>> temp=new ArrayList<>();
        for(int i:paths)
        {

            if(temp.isEmpty())
            {
                temp.add(new Pair<>(i,map.get(i)));
                continue;
            }
            if(temp.get(temp.size()-1).key+1==i)
            {
                temp.add(new Pair<>(i,map.get(i)));
            }
            else
            {
                if(max.size()<temp.size()) {
                    max = temp;
                }
                else if(max.size()==temp.size() && temp.get(0).value<max.get(0).value)
                {
                    max=temp;
                }
                temp=new ArrayList<>();
                temp.add(new Pair<>(i,map.get(i)));
            }
        }
        if(max.size()<temp.size()) {
            max = temp;
        }
        else if(max.size()==temp.size() && temp.get(0).value<max.get(0).value)
        {
            max=temp;
        }
        for(Pair pair:max)
        {
            System.out.println(pair.key);
        }
    }
}
class Pair<K,V>{
    K key;
    V value;
    Pair(K key,V value)
    {
        this.key=key;
        this.value=value;
    }
}
