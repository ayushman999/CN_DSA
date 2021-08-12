package DSA2.Stacks;

import java.util.Scanner;
import java.util.Stack;

public class BalancedParenthesis {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int l = input.length();
        for(int i=0;i<l;i++)
        {
            String s=input.substring(i,i+1);
            if(isOpen(s))
            {
                stack.add(s);
            }
            else
            {
                if(!stack.isEmpty() && s.equals(getOpposite(stack.peek())))
                {
                    stack.pop();
                }
                else
                {
                    System.out.println("false");
                }
            }
        }
        if(stack.isEmpty())
        {
            System.out.println("true");
        }
        else
        {
            System.out.println("false");
        }
    }
    public static String getOpposite(String str)
    {
        if(str.equals("("))
        {
            return ")";
        }
        else if(str.equals("{"))
        {
            return "}";
        }
        else if(str.equals("["))
        {
            return "]";
        }
        else if(str.equals(")"))
        {
            return "(";
        }
        else if(str.equals("}"))
        {
            return "{";
        }
        else if(str.equals("]"))
        {
            return "[";
        }
        return "";
    }
    public static boolean isOpen(String str)
    {
        if(str.equals("("))
        {
            return true;
        }
        else if(str.equals("{"))
        {
            return true;
        }
        else if(str.equals("["))
        {
            return true;
        }
        return false;
    }
    public static boolean isClosed(String str)
    {
        if(str.equals(")"))
        {
            return true;
        }
        else if(str.equals("}"))
        {
            return true;
        }
        else if(str.equals("]"))
        {
            return true;
        }
        return false;
    }
}
