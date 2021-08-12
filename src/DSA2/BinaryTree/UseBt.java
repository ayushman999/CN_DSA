package DSA2.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class UseBt {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Tree<Integer> root=insertRowWise(sc);
        InOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        preOrder(root);

    }

    public static void preOrder(Tree<Integer> root) {
        if(root==null)
        {
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    private static void postOrder(Tree<Integer> root) {
        if(root==null)
        {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

    public static void InOrder(Tree<Integer> root)
    {
        if(root==null)
        {
            return;
        }
        InOrder(root.left);
        System.out.print(root.data+" ");
        InOrder(root.right);
    }

    public static Tree<Integer> insertRowWise(Scanner sc) {
        int data=sc.nextInt();
        if(data==-1)
        {
            return null;
        }
        Tree<Integer> root=new Tree<>(data);
        Queue<Tree<Integer>> q=new LinkedList<>();
        q.add(root);
        while (!q.isEmpty())
        {
            Tree<Integer> r=q.poll();
            data=sc.nextInt();

            if(data!=-1)
            {
                Tree<Integer> child=new Tree<>(data);
                q.add(child);
                r.left=child;
            }
            data=sc.nextInt();
            if(data!=-1)
            {
                Tree<Integer> child=new Tree<>(data);
                q.add(child);
                r.right=child;
            }
        }
        return root;
    }

    private static Tree<Integer> insert(Scanner sc) {
        int data=sc.nextInt();
        if(data==-1)
        {
            return null;
        }
        Tree<Integer> root=new Tree<>(data);
        root.left=insert(sc);
        root.right=insert(sc);
        return root;
    }

    public static void print(Tree<Integer> root) {
        if(root==null)
        {
            return;
        }
        Queue<Tree<Integer>> q=new LinkedList<>();
        q.add(root);
        while (!q.isEmpty())
        {
            Tree<Integer> t=q.poll();
            String str=t.data+": ";
            if(t.left!=null)
            {
                q.add(t.left);
                str+=t.left.data+" ";
            }
            if(t.right!=null)
            {
                q.add(t.right);
                str+=t.right.data;
            }
            System.out.println(str);
        }
    }
}
