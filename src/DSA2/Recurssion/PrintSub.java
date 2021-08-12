package DSA2.Recurssion;

public class PrintSub {
    public static void main(String[] args) {
        String input="xyz";
        printSub(input,"");
    }

    private static void printSub(String input, String s) {
        if(input.length()==0)
        {
            System.out.println(s);
            return;
        }
        printSub(input.substring(1),s);
        printSub(input.substring(1),s+input.substring(0,1));
    }
}
