package DSA2.BST;

import DSA2.BinaryTree.Tree;
import DSA2.BinaryTree.UseBt;

import java.util.ArrayList;
import java.util.Scanner;

public class BSTpath {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int data=sc.nextInt();
        Tree<Integer> root= UseBt.insertRowWise(sc);
        ArrayList<Integer> list=getPath(root,data);
        System.out.println(list);

    }

    private static ArrayList<Integer> getPath(Tree<Integer> root, int data) {
        if(root==null)
        {
            return null;
        }
        ArrayList<Integer> list=new ArrayList<>();
        if(root.data==data)
        {
            list.add(data);
            return list;
        }
        ArrayList<Integer> left=getPath(root.left,data);
        if(left!=null)
        {
            left.add(root.data);
            return left;
        }
        ArrayList<Integer> right=getPath(root.right,data);
        if(right!=null)
        {
            right.add((root.data));
            return right;
        }
        return null;
    }
}
