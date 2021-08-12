package DSA2.Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ReplaceWithLevel {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        TreeNode<Integer> root=UseTree.insertRowWise(sc);
        replace(root,0);
        printLevel(root);
    }

    private static void printLevel(TreeNode<Integer> root) {
        Queue<TreeNode<Integer>> q=new LinkedList<>();
        q.add(root);
        System.out.println(root.data);
        while (!q.isEmpty())
        {
            TreeNode<Integer> parent=q.poll();
            for(int i=0;i<parent.children.size();i++)
            {
                System.out.print(parent.children.get(i).data+" ");
                q.add(parent.children.get(i));
            }
            System.out.println();
        }
    }

    private static void replace(TreeNode<Integer> root,int l) {
        root.data=l;
        for(int i=0;i<root.children.size();i++)
        {
            replace(root.children.get(i),l+1);
        }
    }
}
