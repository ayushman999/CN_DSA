package DSA2.Trees;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CountNodes {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        TreeNode<Integer> node=insert(sc);
        System.out.println(check(node));
        print(node);
    }

    private static int check(TreeNode<Integer> node) {
        int count=1;
        for(int i=0;i<node.children.size();i++)
        {
            count+=check(node.children.get(i));
        }
        return count;
    }

    private static void print(TreeNode<Integer> node) {
        Queue<TreeNode<Integer>> q=new LinkedList<>();
        q.add(node);
        while (!q.isEmpty())
        {
            TreeNode<Integer> parent=q.poll();
            String str=parent.data+": ";
            for(int i=0;i<parent.children.size();i++)
            {
                str+=parent.children.get(i).data+" ";
                q.add(parent.children.get(i));
            }
            System.out.println(str);
        }
    }

    private static TreeNode<Integer> insert(Scanner sc) {
        System.out.println("Enter starting node.");
        int data=sc.nextInt();
        Queue<TreeNode<Integer>> q=new LinkedList<>();
        TreeNode<Integer> node=new TreeNode<>(data);
        q.add(node);
        while (!q.isEmpty())
        {
            TreeNode<Integer> parent=q.poll();
            System.out.println("Enter size of: "+parent.data);
            int size=sc.nextInt();
            for(int i=0;i<size;i++)
            {
                System.out.println("Enter "+i+"th children of "+parent.data);
                int d=sc.nextInt();
                TreeNode<Integer> children=new TreeNode<>(d);
                q.add(children);
                parent.children.add(children);
            }
        }
        return node;
    }
}
