package DSA2.HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class NutsNBolts {
    public static void main(String[] args) {
        char[] nuts={'@', '%', '$', '#', '^'};
        char[] bolts={'%', '@', '#', '$', '^'};
        calculate(nuts,bolts);
    }

    private static void calculate(char[] nuts, char[] bolts) {
        char[] order={ '!' ,'#' ,'$' ,'%' ,'&' ,'*' ,'@' ,'^' ,'~'};
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<nuts.length;i++)
        {
            map.put(nuts[i],i);
        }
        int p=0;
        if(map.containsKey(order[0]))
        {
            nuts[p]=order[0];
            p+=1;
        }
        if(map.containsKey(order[1]))
        {
            nuts[p]=order[1];
            p+=1;
        }
        if(map.containsKey(order[2]))
        {
            nuts[p]=order[2];
            p+=1;
        }
        if(map.containsKey(order[3]))
        {
            nuts[p]=order[3];
            p+=1;
        }
        if(map.containsKey(order[4]))
        {
            nuts[p]=order[4];
            p+=1;
        }
        if(map.containsKey(order[5]))
        {
            nuts[p]=order[5];
            p+=1;
        }
        if(map.containsKey(order[6]))
        {
            nuts[p]=order[6];
            p+=1;
        }
        if(map.containsKey(order[7]))
        {
            nuts[p]=order[7];
            p+=1;
        }
        if(map.containsKey(order[8]))
        {
            nuts[p]=order[8];
            p+=1;
        }
        bolts=nuts;
    }
}
