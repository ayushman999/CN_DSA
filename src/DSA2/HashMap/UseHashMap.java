package DSA2.HashMap;

import java.util.HashMap;
import java.util.Set;

public class UseHashMap
{
    public static void main(String[] args) {
        Map<String,Integer> map=new Map<>();
        for(int i=1;i<=50;i++)
        {
            map.insert("abc"+i,i);
            System.out.println(map.getLoadFactor());
        }
        map.delete("abc1");
        map.delete("abc2");
        for(int i=1;i<=20;i++)
        {
            System.out.println("abc"+i+": "+map.getValue("abc"+i));
        }
    }
}
