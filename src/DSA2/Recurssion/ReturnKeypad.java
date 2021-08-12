package DSA2.Recurssion;

import java.util.ArrayList;
import java.util.Collections;

public class ReturnKeypad {
    public static void main(String[] args) {
        String[][] str=new String[10][];
        String input="322";
        str[0]= new String[]{""};
        str[1]= new String[]{""};
        str[2]= new String[]{"a","b","c"};
        str[3]= new String[]{"d","e","f"};
        str[4]= new String[]{"g","h","i"};
        str[5]= new String[]{"j","k","l"};
        str[6]= new String[]{"m","n","o"};
        str[7]= new String[]{"p","q","r","s"};
        str[8]= new String[]{"t","u","v"};
        str[9]= new String[]{"w","x","y","z"};
        String[] result=check(str,input);
        for(String item:result)
        {
            System.out.println(item);
        }

    }

    private static String[] check(String[][] str,String input) {
        if(input.equals("0") || input.equals("1") || input.length()==0)
        {
            String arr[]={""};
            return arr;
        }
        String[] res=check(str,input.substring(1));
        String[] possible=str[Integer.parseInt(input.substring(0,1))];
        String[] arr =new String[(possible.length)*(res.length)];
        int k=0;
        for(int i=0;i<possible.length;i++)
        {
            for(int j=0;j< res.length;j++)
            {
                arr[k]=possible[i]+res[j];
                k++;
            }
        }
        return arr;
    }
}
