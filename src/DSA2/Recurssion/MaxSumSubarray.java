package DSA2.Recurssion;

public class MaxSumSubarray {
    public static void main(String[] args) {
        int[] arr={34, -50, 42, 14, -5, 86};
        System.out.println(check(arr));
    }

    private static int check(int[] arr) { //Kadane's algorithm
        int max=Integer.MIN_VALUE;
        int maxNow=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            maxNow+=arr[i];
            if(maxNow<0)
            {
                maxNow=0;
            }
            else if(maxNow>max)
            {
                max=maxNow;
            }
        }
        return max;
    }
}
