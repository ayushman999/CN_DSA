package DSA2.Recurssion;

import java.util.ArrayList;

public class PrintPermutation {
    static ArrayList<String> gandMarao=new ArrayList<>();
    public static void main(String[] args) {
        String n="abc";

        check(n,0);
        System.out.println(gandMarao);
    }

    private static void check(String n, int i) {
        if(i==n.length()-1)
        {
            gandMarao.add(n);
            /*System.out.println(n);*/
            return;
        }
        for(int j=i;j<n.length();j++)
        {
            n=swap(i,j,n);
            check(n,i+1);
            n=swap(i,j,n);
        }
    }

    private static String swap(int i, int j, String n) {
        StringBuilder builder=new StringBuilder(n);
        builder.setCharAt(i,n.charAt(j));
        builder.setCharAt(j,n.charAt(i));
        return builder.toString();
    }
}
