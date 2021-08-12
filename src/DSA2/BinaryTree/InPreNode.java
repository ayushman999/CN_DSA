package DSA2.BinaryTree;

import java.util.Scanner;

public class InPreNode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int in[] = new int[size];
        int pre[] = new int[size];
        for (int i = 0; i < size; i++) {
            in[i] = sc.nextInt();
        }
        for (int i = 0; i < size; i++) {
            pre[i] = sc.nextInt();
        }
        /*Tree<Integer> root = getTree(0, in.length - 1, 0, in.length - 1, in, pre);*/
        Tree<Integer> root=merge(0,in.length-1,0,in.length-1,in,pre);
        UseBt.print(root);
    }

    private static Tree<Integer> merge(int inS, int inE, int preS, int preE, int[] in, int[] pre) {
        int res=-1;
        if(inS==inE && preE==preS)
        {
            Tree<Integer> root=new Tree<>(in[inS]);
            return root;
        }
        for(int i=0;i<=in.length-1;i++)
        {
            if(in[i]==pre[preS])
            {
                res=i;
                break;
            }
        }
        int lIS=inS;
        int lPS=preS+1;
        int lIE=res-1;
        if(lIE<inS)
        {
            return null;
        }
        int lPE=lIE-lIS+lPS;
        int rIS=res+1;
        int rPS=lPE+1;
        int rIE=inE;
        int rPE=preE;
        Tree<Integer> root=new Tree<>(pre[preS]);

        root.left=merge(lIS,lIE,lPS,lPE,in,pre);
        root.right=merge(rIS,rIE,rPS,rPE,in,pre);
        return root;

    }

    private static Tree<Integer> getTree(int i1, int i2, int p1, int p2, int[] in, int[] pre) {
        if (i2 < 0) {
            return null;
        }
        if (i1 == i2 && p1 == p2) {
            Tree<Integer> root = new Tree<>(pre[p1]);
            return root;
        }
        int rootV = pre[p1];
        int j = i1;
        while (in[j] != rootV) {
            j++;
        }
        Tree<Integer> root = new Tree<>(rootV);

        if(p1!=j) {
            root.left = getTree(i1, j - 1, p1 + 1, p1 + j-i1, in, pre);
        }
        if(p1+j+1 >in.length)
        {
            if(j==in.length-1)
            {
                return root;
            }
            root.right = getTree(j + 1, i2, p1+j+ 1-i1, p2, in, pre);
            return root;
        }
        root.right = getTree(j + 1, i2, p1 +j+ 1, p2, in, pre);
        return root;
    }


}
