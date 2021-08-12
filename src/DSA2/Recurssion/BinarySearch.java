package DSA2.Recurssion;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr={2,3,4,5,6,7,8};
        int k=2;
        System.out.println(check(arr,0,arr.length-1,k));
    }

    private static boolean check(int[] arr,int l,int r,int k) {
        int mid=(l+r)/2;
        if(arr[mid]==k)
        {
            return true;
        }
        if(arr[mid]>k)
        {
            return check(arr,l,mid-1,k);
        }
        else
        {
            return check(arr,mid+1,r,k);
        }
    }
}
