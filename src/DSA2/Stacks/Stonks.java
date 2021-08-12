package DSA2.Stacks;

import java.util.Scanner;
import java.util.Stack;

public class Stonks {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        int[] arr=new int[size];
        for(int i=0;i<size;i++)
        {
            arr[i]=sc.nextInt();
        }
        Stack<pair> stack=new Stack<>();
        stack.add(new pair(arr[0],0));
        int[] result=new int[arr.length];
        result[0]=1;
        int pp=1;
        for(int i=1;i<arr.length;i++)
        {
            pair p=new pair(arr[i],i);
            while (!stack.isEmpty() && stack.peek().getData()<=arr[i])
            {
                stack.pop();
            }
            if(stack.isEmpty())
            {
                result[pp]=i+1;
            }
            else {
                result[pp]=i-stack.peek().getPosition();
            }
            pp++;
            stack.add(p);

        }
        for(int item:result)
        {
            System.out.print(item+" ");
        }

    }
}
class pair{
    private int data;
    private int position;
    pair(int data,int position)
    {
        this.data=data;
        this.position=position;
    }
    public int getData(){return data;}
    public int getPosition(){return position;}
}
