package DSA2.Recurssion;

public class Subsequences {
    public static void main(String[] args) {
        String str="abcd";
        String[] result=check(str);
        for(String item:result)
        {
            System.out.println(item);
        }
    }

    private static String[] check(String str) {
        if(str.length()==0)
        {
            String[] arr={""};
            return arr;
        }
        String[] secondary=check(str.substring(1));
        String[] arr=new String[2*secondary.length];
        int k=0;
        for(int i=0;i<secondary.length;i++)
        {
            arr[k]=secondary[i];
            k++;
        }
        for(int i=0;i< secondary.length;i++)
        {
            arr[k]=str.charAt(0)+secondary[i];
            k++;
        }
        return arr;
    }
}

