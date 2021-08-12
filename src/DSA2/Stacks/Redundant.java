package DSA2.Stacks;

import java.util.Scanner;
import java.util.Stack;

public class Redundant {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        System.out.println(isTrue(str));
    }
    public static boolean isTrue(String str)
    {
        Stack<String> stack=new Stack<>();
        for(int i=0;i<str.length();i++)
        {
            String temp=str.substring(i,i+1);
            if(temp.equals("("))
            {
                stack.add("(");
            }
            else if(temp.equals(")"))
            {
                String prev=stack.peek();
                if(prev.equals("("))
                {
                    return false;
                }
                else
                {
                    stack.pop();
                    stack.pop();
                }
            }
            else
            {
                String prev=stack.peek();
                if(prev.equals("("))
                {
                   stack.add("a");
                }
                else
                {
                    continue;
                }
            }
        }
        return !stack.isEmpty();
    }
}
