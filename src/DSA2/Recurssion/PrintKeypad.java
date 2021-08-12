package DSA2.Recurssion;

public class PrintKeypad {
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
        check(str,input,"");
    }

    private static void check(String[][] str,String input, String s) {
        if(input.length()==0){
            System.out.println(s);
            return;
        }
        int i=Integer.parseInt(input.substring(0,1));
        for(int j=0;j<str[i].length;j++)
        {
            check(str,input.substring(1),s+str[i][j]);
        }
    }
}
