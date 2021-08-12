package DSA2.Recurssion;

public class SubsetSum {
    public static void main(String[] args) {
        int arr[]={1,2,3,3,4,5,5,12,15,17,17,18};
        int k=6;
        for(int i=0;i<arr.length-1;i++)
        {
            check(arr,i+1,i,k);
        }
    }

    private static void check(int[] arr,int i,int ref,int k) {
        if((arr[ref]+arr[i])>k)
        {
            ref++;
            return;
        }
        if((arr[ref]+arr[i])==k)
        {
            System.out.println(ref+" "+i);
        }
        check(arr,i+1,ref,k);
    }
}
