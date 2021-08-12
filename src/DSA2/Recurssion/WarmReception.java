package DSA2.Recurssion;

public class WarmReception {
    static int[] arrival={850,900,1000,1100,1400};
    static int[] departure={950,999,2000,1500,1450};
    public static void main(String[] args) {
        /*quicksort(0,arrival.length-1);*/
        int num=5;
        System.out.println(check(num,arrival,departure));
    }

    private static void quicksort(int l,int h) {
       if (l<h) {
           int pivot = partion(l, h);
           quicksort(l, pivot - 1);
           quicksort(pivot + 1, h);

       }
    }

    private static int partion(int l, int h) {
        int pivot=arrival[l];
        int i=l;
        int j=h;
        while (i<j)
        {
            while (pivot>=arrival[i]) i++;
            while (pivot<arrival[j]) j--;
            if(i<j)
            {
                swap(i,j);
            }
        }
        swap(l,j);
        return j;
    }

    private static void swap(int i, int j) {
        int temp1=arrival[i];
        int temp2=departure[i];
        arrival[i]=arrival[j];
        arrival[j]=temp1;

    }

    private static int check(int num, int[] arrival, int[] departure) {
        int chair=0;
        int maxNow=0;
        for(int i=0;i<arrival.length-1;i++)
        {
            if(departure[i]>arrival[i+1]) {
                maxNow++;
            }
            else {
                if(chair<maxNow)
                {
                    chair=maxNow;
                    maxNow=0;
                }
            }
        }
        if(chair<maxNow)
        {
            chair=maxNow;
        }
        return chair+1;
    }
}
