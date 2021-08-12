package DSA2.Trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class UseTree {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        TreeNode<Integer> root=insertRowWise(sc);
        System.out.println(greater(root)+"<- The Greatest!");
        System.out.println(height(root));
        System.out.println("---Depth---");
        printDepth(root,2);
        System.out.println("---No. of leaves---");
        System.out.println(countLeaf(root));
        System.out.println("---PreOrder---");
        preorder(root);
        System.out.println();
        System.out.println("---PostOrder---");
        postorder(root);

    }

    private static void postorder(TreeNode<Integer> root) {
        for(int i=0;i<root.children.size();i++)
        {
            postorder(root.children.get(i));
        }
        System.out.print(root.data+" ");
    }

    private static void preorder(TreeNode<Integer> root) {
        System.out.print(root.data+" ");
        for(int i=0;i<root.children.size();i++)
        {
            preorder(root.children.get(i));
        }
    }

    private static int countLeaf(TreeNode<Integer> root) {
        if(root.children.size()==0)
        {
            return 1;
        }
        int m=0;
        for(int i=0;i<root.children.size();i++)
        {
            m+=countLeaf(root.children.get(i));
        }
        return m;
    }

    private static void printDepth(TreeNode<Integer> root, int k) {
        if(k==0)
        {
            System.out.println(root.data);
            return;
        }
        if(k<0)
        {
            return;
        }
        for(int i=0;i<root.children.size();i++)
        {
            printDepth(root.children.get(i),k-1);
        }
    }

    private static int height(TreeNode<Integer> root) {
        int[] arr=new int[root.children.size()];
        for(int i=0;i<root.children.size();i++)
        {
            arr[i]=Math.max(height(root.children.get(i)),arr[i])+1;
        }
        if(arr.length>0)
        {
            Arrays.sort(arr);
            return arr[arr.length-1];
        }
        return 1;
    }

    private static TreeNode<Integer> insert(Scanner sc) {
        int data=sc.nextInt();
        int size=sc.nextInt();
        TreeNode<Integer> root=new TreeNode<>(data);
        for(int i=0;i<size;i++)
        {
            TreeNode<Integer> child=insert(sc);
            root.children.add(child);
        }
        return root;
    }

    public static TreeNode<Integer> insertRowWise(Scanner sc)
    {
        System.out.println("Enter node data");
        int data=sc.nextInt();
        TreeNode<Integer> node=new TreeNode<>(data);
        Queue<TreeNode<Integer>> q=new LinkedList<>();
        q.add(node);
        while (!q.isEmpty())
        {
            TreeNode<Integer> parent=q.poll();
            System.out.println("Enter size of "+parent.data+" node.");
            int size=sc.nextInt();
            for(int i=0;i<size;i++)
            {
                System.out.println("Enter data of "+parent.data+" for "+(i+1)+"th element.");
                TreeNode<Integer> child=new TreeNode<>(sc.nextInt());
                q.add(child);
                parent.children.add(child);
            }
        }
        return node;
    }
    private static int greater(TreeNode<Integer> node) {
        if(node==null)
        {
            return Integer.MIN_VALUE;
        }
        int d=node.data;
        for(int i=0;i<node.children.size();i++)
        {
            d=Math.max(greater(node.children.get(i)),d);
        }
        return d;
    }
    public static void printRowWise(TreeNode<Integer> root)
    {
        Queue<TreeNode<Integer>> q=new LinkedList<>();
        q.add(root);
        while (!q.isEmpty())
        {
            TreeNode<Integer> parent=q.poll();
            String str=parent.data+": ";
            for(int i=0;i<parent.children.size();i++)
            {
                str+=parent.children.get(i).data+", ";
                q.add(parent.children.get(i));
            }
            System.out.println(str);
        }
    }

    private static void print(TreeNode<Integer> root) {
        String data=root.data+": ";
        for(int i=0;i<root.children.size();i++)
        {
            data+=root.children.get(i).data+", ";
        }
        System.out.println(data);
        for(int i=0;i<root.children.size();i++)
        {
            print(root.children.get(i));
        }
    }

}
