package DSA2.Trees;

import java.util.Scanner;

public class CheckPresent {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int element=sc.nextInt();
        TreeNode<Integer> root=UseTree.insertRowWise(sc);
        System.out.println(greaterThan(root,element));
    }

    private static int greaterThan(TreeNode<Integer> root,int element)
    {
        int count=0;
        if(root.data>element)
        {
            count= 1;
        }
        for(int i=0;i<root.children.size();i++)
        {
            count+=greaterThan(root.children.get(i),element);
        }
        return count;

    }

    private static boolean checkPresence(TreeNode<Integer> root, int element) {
        if(root.data==element)
        {
            return true;
        }
        boolean present=false;
        for(int i=0;i<root.children.size();i++)
        {
            present=checkPresence(root.children.get(i),element);
        }
        return present;
    }
}
