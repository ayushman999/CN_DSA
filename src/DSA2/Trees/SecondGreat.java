package DSA2.Trees;

import java.util.Scanner;
import java.util.concurrent.ScheduledExecutorService;

public class SecondGreat {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        TreeNode<Integer> root=UseTree.insertRowWise(sc);
        TreeNode<Integer> greatest=great(root,root);
        greatest.data=Integer.MIN_VALUE;
        greatest=great(root,root);
        check(root,greatest);
    }

    private static void check(TreeNode<Integer> root, TreeNode<Integer> greatest) {
        int i=0;
        for(;i<root.children.size();i++)
        {
            if(root.children.get(i)==greatest)
            {
                System.out.println(root.data);
                return;
            }
            else {
                check(root.children.get(i),greatest);
            }
        }
    }


    private static TreeNode<Integer> great(TreeNode<Integer> root,TreeNode<Integer> great) {
        if(great.data<root.data)
        {
            great=root;
        }
        for(int i=0;i<root.children.size();i++)
        {
            great=great(root.children.get(i),great);
        }
        return great;
    }
}
