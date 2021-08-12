package DSA2.Stacks;

import java.util.Scanner;
import java.util.Stack;

public class BracketReversal {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        System.out.println(check(str));
    }

    private static int check(String str) {
        Stack<String> stack=new Stack<>();
        for(int i=0;i<str.length();i++)
        {
            String temp=str.substring(i,i+1);
            if(temp.equals("}") && !stack.isEmpty() && stack.peek().equals("{"))
            {
                stack.pop();
            }
            else
            {
                stack.add(temp);
            }
        }
        if(stack.size()==0 || (stack.size()&1)!=0)
        {
            return -1;
        }
        int count=0;
        while (!stack.isEmpty())
        {
            String temp=stack.pop();
            if(stack.peek().equals(temp))
            {
                stack.pop();
                count++;
            }
            else
            {
                count+=2;
                stack.pop();
            }
        }
        return count;
    }
}
