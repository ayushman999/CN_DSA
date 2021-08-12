package DSA2.PriorityQueue;

import java.util.*;

public class GameWithString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        int k=sc.nextInt();
        PriorityQueue<Chr> pq=new PriorityQueue<>(new CompareCh());
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<str.length();i++)
        {
            if(map.containsKey(str.charAt(i)))
            {
                map.put(str.charAt(i),map.get(str.charAt(i))+1);
            }
            else
            {
                map.put(str.charAt(i),1);
            }
        }
        Set<Character> set=map.keySet();
        for(Character ch:set)
        {
            pq.add(new Chr(ch,map.get(ch)));
        }
        while (k>0)
        {
            Chr p=pq.peek();
            p.reps=p.reps-1;
            pq.poll();
            pq.add(p);
            k--;
        }
        int sum=0;
        while (!pq.isEmpty())
        {
            Chr ch=pq.poll();
            sum+=Math.pow(ch.reps,2);
        }
        System.out.println(sum);
    }
}
class Chr{
    Character ch;
    int reps;
    Chr(char ch,int reps)
    {
        this.ch=ch;
        this.reps=reps;
    }
}
class CompareCh implements Comparator<Chr>
{

    @Override
    public int compare(Chr o1, Chr o2) {
        if(o1.reps>o2.reps)
        {
            return -1;
        }
        else
        {
            return 1;
        }
    }
}
