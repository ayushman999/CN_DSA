package DSA2.HashMap;

import java.util.*;

public class AnagramList {
    public static void main(String[] args) {
        String[] words = {"no","on","is"};
        int p=1;
        HashMap<String,Integer> map=new HashMap<>();
        List<List<String>> result=new ArrayList<>();
        result.add(new ArrayList<>());
        result.get(0).add(words[0]);
        map.put(getString(words[0]),0);
        for(int i=1;i< words.length;i++)
        {
            String hash= getString(words[i]);
            if(map.containsKey(hash))
            {
                int pos=map.get(hash);
                result.get(pos).add(words[i]);
            }
            else
            {
                map.put(hash,p);
                result.add(new ArrayList<>());
                result.get(p).add(words[i]);
                p=p+1;
            }
        }
    }

    private static String getString(String word) {
        char[] temp=word.toCharArray();
        Arrays.sort(temp);
        return new String(temp);
    }

}