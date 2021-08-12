package DSA2.BST;

import DSA2.BinaryTree.Tree;
import DSA2.BinaryTree.UseBt;

import java.util.Scanner;

public class isbst {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Tree<Integer> root= UseBt.insertRowWise(sc);
        Pair<Boolean,Pair<Integer,Integer>> p=check(root);
        System.out.println(p.first+"\nLowest: "+p.second.first+"\nHighest: "+p.second.second);
    }

    private static Pair<Boolean,Pair<Integer,Integer>> check(Tree<Integer> root)
    {
        if(root==null)
        {
            Pair<Boolean,Pair<Integer,Integer>> p=new Pair<>();
            p.first=true;
            p.second= new Pair<>();
            p.second.first=Integer.MAX_VALUE;
            p.second.second=Integer.MIN_VALUE;
            return p;
        }
        Pair<Boolean,Pair<Integer,Integer>> p=check(root.left);
        Pair<Boolean,Pair<Integer,Integer>> g=check(root.right);
        Pair<Boolean,Pair<Integer,Integer>> r=new Pair<>();
        r.second= new Pair<>();
        r.second.first=Math.min(root.data,Math.min(p.second.first,g.second.first));
        r.second.second=Math.max(root.data,Math.max(p.second.second,g.second.second));
        r.first=p.first&&g.first&&(root.data<g.second.first)&&(root.data>p.second.second);
        return r;
    }
    private static boolean checkIf(Tree<Integer> root) {
        if(root==null)
        {
            return true;
        }
        int m1=maximum(root.left);
        int m2=minimum(root.right);
        if(root.data<=m1)
        {
            return false;
        }
        if(root.data>=m2)
        {
            return false;
        }
        boolean right=checkIf(root.right);
        boolean left=checkIf(root.left);
        return right&left;
    }

    private static int minimum(Tree<Integer> right) {
        if(right==null)
        {
            return Integer.MAX_VALUE;
        }
        return Math.min(right.data, Math.min( minimum(right.right),minimum(right.left)));
    }

    private static int maximum(Tree<Integer> left) {
        if(left==null)
        {
            return Integer.MIN_VALUE;
        }
        return Math.max(left.data, Math.max(maximum(left.left),maximum(left.right)));
    }
}
class Pair<T,V>
{
    T first;
    V second;
}
