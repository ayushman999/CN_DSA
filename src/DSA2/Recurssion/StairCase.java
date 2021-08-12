package DSA2.Recurssion;

public class StairCase {
    public static void main(String[] args) {
        int N=4;
        System.out.println(check(1,0,N,0));
    }

    private static int check(int hop, int steps, int total,int count) {
        if(steps==total)
        {
            return count+1;
        }
        else if(steps>total)
        {
            return count;
        }
        count=check(1,steps+1,total,count);
        count=check(2,steps+2,total,count);
        count=check(3,steps+3,total,count);
        return count;
    }
}
