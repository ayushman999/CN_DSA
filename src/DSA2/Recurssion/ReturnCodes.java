package DSA2.Recurssion;

import java.util.Arrays;

public class ReturnCodes {
    public static void main(String[] args) {
        String n = "cba";
        check(n, 0, "");
        StringBuilder s=new StringBuilder(n);
    }

    private static String[] getCodes(String n, int i) {
        if (i >= n.length()) {
            int sample = n.charAt(i) + 96;
            String s =""+ (char) sample;
            String result[] = {s};
            return result;
        }
        String[] res1 = getCodes(n, i + 1);
        String[] res2 = getCodes(n, i + 2);
        String[] result=new String[(res1.length)*(res2.length)];
        int k=0;
    return res1;}

    private static void check(String n, int i, String s) {
        if (i >= n.length()) {
            String[] str = s.split(" ");
            for (String item : str) {
                if (item != "") {
                    int sample = Integer.parseInt(item) + 96;
                    System.out.print((char) sample);
                }
            }
            System.out.println();
            return;
        }
        check(n, i + 1, s + " " + n.charAt(i));
        if ((i + 2) <= n.length()) {
            check(n, i + 2, s + " " + n.substring(i, i + 2));
        }
    }
}
