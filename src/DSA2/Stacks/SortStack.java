package DSA2.Stacks;

import java.util.Scanner;
import java.util.Stack;

public class SortStack {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<size;i++)
        {
            stack.add(sc.nextInt());
        }
        rev(stack);
        System.out.println(stack);
    }

    private static void rev(Stack<Integer> stack) {
        if(stack.isEmpty())
        {
            return;
        }
        int temp=stack.pop();
        rev(stack);
        adjust(stack,temp);
    }

    private static void adjust(Stack<Integer> stack, int temp) {
        if(stack.isEmpty())
        {
            stack.push(temp);
            return;
        }
        if(stack.peek()>=temp)
        {
            stack.add(temp);
            return;
        }
        int h=stack.pop();
        adjust(stack,temp);
        stack.add(h);
    }
}
