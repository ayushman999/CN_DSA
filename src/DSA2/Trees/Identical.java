package DSA2.Trees;

import java.util.Scanner;

public class Identical {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        TreeNode<Integer> root1=UseTree.insertRowWise(sc);
        TreeNode<Integer> root2=UseTree.insertRowWise(sc);
        System.out.println(check(root1,root2));
    }

    private static boolean check(TreeNode<Integer> root1, TreeNode<Integer> root2) {
        if(root1.data!=root2.data)
        {
            return false;
        }
        if(root1.children.size()!=root2.children.size())
        {
            return false;
        }
        boolean b=true;
        for(int i=0;i<root1.children.size();i++)
        {
            if(b==true) {
                b = check(root1.children.get(i), root2.children.get(i));
            }
            else
            {
                break;
            }
        }
        return b;
    }
}
