package DSA2.BST;

import DSA2.BinaryTree.Tree;
import DSA2.BinaryTree.UseBt;

import java.util.Scanner;

public class ArraytoBst {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int[] pre = getPre(0, size - 1, arr);
        /*Tree<Integer> root=getBST(0,size-1,arr);
        UseBt.print(root);*/

    }

    private static int[] getPre(int i, int j, int[] arr) {
        if (i > j) {
            int[] res=new int[0];
            return res;
        }
        if (i == j) {
            int[] pre = new int[1];
            pre[0] = arr[i];
            return pre;
        }
        int[] pre;
        int mid =0;
        if((j&1)==1)
        {
            mid=(i+j)/2+1;
        }
        else
        {
            mid=(i+j)/2;
        }
        int[] res1 = getPre(i, mid - 1, arr);
        int[] res2 = getPre(mid + 1, j, arr);
        int l1 = res1.length;
        int l2 = res2.length;
        pre = new int[l1 + l2 + 1];
        pre[0] = arr[mid];
        for (int a = 0; a < res1.length; a++) {
            pre[a + 1] = res1[a];
        }
        for (int b = 0; b < res2.length; b++) {
            pre[b + res1.length + 1] = res2[b];
        }
        return pre;
    }

    private static Tree<Integer> getBST(int i, int j, int[] arr) {
        if (i > j) {
            return null;
        }
        if (i == j) {
            Tree<Integer> root = new Tree<>(arr[i]);
            return root;
        }
        int mid = (i + j) / 2;
        Tree<Integer> root = new Tree<>(arr[mid]);
        root.left = getBST(i, mid - 1, arr);
        root.right = getBST(mid + 1, j, arr);
        return root;
    }
}
