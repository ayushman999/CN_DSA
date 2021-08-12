package DSA2.Recurssion;

public class CheckAB {
    public static void main(String[] args) {
        String input="aba";
        System.out.println(check(input,"",false));
    }

    private static boolean check(String input, String ref,boolean isTrue) {
        if(input.length()==0)
        {
            return isTrue;
        }
        else if(ref.equals("") && input.charAt(0) == 'a')
        {
            isTrue=true;
        }
        else if(ref.equals("a") && (input.charAt(0)=='a' || input.substring(0,2).equals("bb")))
        {
            isTrue=true;
        }
        else if(ref.equals("bb") && input.charAt(0)=='a')
        {
            isTrue=true;
        }
        else
        {
            isTrue=false;
        }
        if(input.length()>=2 && input.startsWith("bb"))
        {
            isTrue=check(input.substring(2),"bb",isTrue);
        }
        else
        {
            isTrue=check(input.substring(1),input.substring(0,1),isTrue);
        }
        return isTrue;

    }
}
