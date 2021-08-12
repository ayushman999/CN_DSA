package DSA2.Stacks;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        for(int i=1;i<=10;i++)
        {
            stack.add(i);
        }
        reverse(stack);
        while (!stack.isEmpty())
        {
            System.out.println(stack.pop());
        }
    }

    private static void reverse(Stack<Integer> stack) {
        if(stack.isEmpty())
        {
            return;
        }
        int tempH=stack.peek();
        stack.pop();
        reverse(stack);
        insertAtBottom(stack,tempH);
    }

    private static void insertAtBottom(Stack<Integer> stack, int k) {
        if(stack.isEmpty())
        {
            stack.push(k);
            return;
        }
        int tempH=stack.peek();
        stack.pop();
        insertAtBottom(stack,k);
        stack.push(tempH);
    }
}
