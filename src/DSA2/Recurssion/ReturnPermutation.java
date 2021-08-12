package DSA2.Recurssion;

public class ReturnPermutation {
    public static void main(String[] args) {
        String n="abc";
        String[] str=check(n,0);
        for(String item:str)
        {
            System.out.println(item);
        }
    }

    private static String[] check(String n, int i) {
        if(i==n.length()-1)
        {
            String[] r={n.charAt(i)+""};
            return r;
        }
        String[] res=check(n,i+1);
        String result[]=new String[(res[0].length()+1)*res.length];
        int k=0;
        for(String s:res)
        {
            result[k]=n.charAt(i)+s;
            k++;
            for(int j=0;j<s.length();j++)
            {
                result[k]=s.substring(0,j+1)+n.charAt(i)+s.substring(j+1);
                k++;
            }
        }
        return result;
    }
}
