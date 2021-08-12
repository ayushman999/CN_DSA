package DSA2.BinaryTree;

import java.util.Scanner;

public class ShortestCity {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        System.out.println(check(a,b));

    }

    private static int check(int a, int b) {
        int l1=level(a);
        int l2=level(b);
        return l1+l2-1;

    }

    private static int level(int a) {
        int level=1;
        while (a>Math.pow(2,level))
        {
            level++;
        }
        return level;
    }
}
