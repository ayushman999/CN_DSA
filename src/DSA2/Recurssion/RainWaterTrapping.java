package DSA2.Recurssion;

public class RainWaterTrapping {

    public static void main(String[] args) {
        int[] building={3,1,2,4,0,1,3,2};
        System.out.println(check(building));
    }

    private static int check(int[] building) {
        int water=0;
        int[] left=new int[building.length];
        int[] right=new int[building.length];
        left[0]=building[0];
        right[building.length-1]=building[building.length-1];
        for(int i=1;i<building.length;i++)
        {
            left[i]=Math.max(left[i-1],building[i]);
        }
        for(int i=building.length-2;i>=0;i--)
        {
            right[i]=Math.max(building[i],right[i+1]);
        }
        for(int i=0;i<building.length;i++)
        {
            int j=Math.min(left[i],right[i]);
            water+=j-building[i];
        }
        return water;
    }
}
