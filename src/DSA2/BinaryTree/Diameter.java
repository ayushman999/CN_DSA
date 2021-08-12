package DSA2.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Diameter {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Tree<Integer> root=insert(sc);
        Pair<Integer,Integer> pair=getDiaheight(root);
        System.out.println("Diameter: "+pair.diameter);
        System.out.println("Height: "+pair.height);
    }

    private static int diameter(Tree<Integer> root) {
        if(root==null)
        {
            return 0;
        }
        int m1=height(root.left)+height(root.right);
        int m2=diameter(root.left);
        int m3=diameter(root.right);
        return Math.max(m1,Math.max(m2,m3));
    }

    private static int height(Tree root) {
        if(root==null)
        {
            return 0;
        }
        if(root.right==null && root.left==null)
        {
            return 1;
        }
        int l1=height(root.left)+1;
        int l2=height(root.right)+1;
        return Math.max(l1,l2);
    }

    private static Tree<Integer> insert(Scanner sc) {
        int data=sc.nextInt();
        if(data==-1)
        {
            return null;
        }
        Queue<Tree<Integer>> q=new LinkedList<>();
        Tree<Integer> root=new Tree<>(data);
        q.add(root);
        while (!q.isEmpty())
        {
            data=sc.nextInt();
            Tree<Integer> parent=q.poll();
            if(data!=-1)
            {
                Tree<Integer> child=new Tree<>(data);
                q.add(child);
                parent.left=child;
            }
            data=sc.nextInt();
            if(data!=-1)
            {
                Tree<Integer> child=new Tree<>(data);
                q.add(child);
                parent.right=child;
            }
        }
        return root;
    }
    private static Pair<Integer,Integer> getDiaheight(Tree<Integer> root)
    {
        if(root==null)
        {
            Pair<Integer,Integer> pair=new Pair<>();
            pair.diameter=0;
            pair.height=0;
            return pair;
        }
        Pair<Integer,Integer> lo=getDiaheight(root.left);
        Pair<Integer,Integer> ro=getDiaheight(root.right);
        int d=lo.height+ro.height;
        int d2=Math.max(lo.diameter,ro.diameter);
        int h=Math.max(lo.height,ro.height)+1;
        Pair<Integer,Integer> r=new Pair<>();
        r.height=h;
        r.diameter=Math.max(d,d2);
        return r;

    }


}
class Pair<T,V>
{
    public T diameter;
    public V height;
}
