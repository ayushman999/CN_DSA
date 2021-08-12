package DSA2;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bc {
    public static void main(String[] args) throws IOException {
        int[] arr={3,2,4,3,7,5,6};
        check(arr);
    }

    private static void check(int[] arr) {
        Stack<Integer> stack=new Stack<>();
        int[] res=new int[arr.length];
        int p=0;
        for(int i=arr.length-1;i>=0;i--)
        {
            if(stack.isEmpty())
            {
                stack.push(arr[i]);
                res[p]=-1;
                p++;
            }
            else
            {
                if(arr[i]<stack.peek())
                {
                    res[p]=stack.peek();
                    p++;
                    stack.push(arr[i]);
                }
                else
                {
                    while (!stack.isEmpty() && arr[i]>stack.peek())
                    {
                        stack.pop();
                    }
                    if(stack.isEmpty())
                    {
                        res[p]=-1;
                        p++;
                        stack.push(arr[i]);
                    }
                    else
                    {
                        res[p]=stack.peek();
                        stack.push(arr[i]);
                        p++;
                    }
                }
            }

        }
        for(int i=res.length-1;i>=0;i--)
        {
            System.out.print(res[i]+" ");
        }
    }


}
