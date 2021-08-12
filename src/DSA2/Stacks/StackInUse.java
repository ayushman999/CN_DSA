package DSA2.Stacks;

public class StackInUse {
    public static void main(String[] args) throws FullCapacityException, StackIsEmptyException {
        /*printStackByArray();*/
        printStackByLL();
    }

    private static void printStackByLL() throws StackIsEmptyException {
        StackInLL stack=new StackInLL();
        for(int i=0;i<10;i++)
        {
            stack.push(i+1);
        }
        for(int i=0;i<10;i++)
        {
            System.out.println(stack.pop());
        }
        stack.pop();
    }

    private static void printStackByArray() throws StackIsEmptyException {
        StackByArray stack=new StackByArray();
        for(int i=0;i<11;i++)
        {
            stack.push(i+1);
        }
        for(int i=0;i<11;i++)
        {
            System.out.println(stack.pop());
        }
    }
}
