package DSA2.BST;

import DSA2.BinaryTree.Tree;

public class BST {
    Tree<Integer> root;
    public void insert(int data)
    {
        if(hasData(data))
        {
            System.out.println("Already in the BST");
        }
        else
        {
            root=insertData(root,data);
        }
    }

    private Tree<Integer> insertData(Tree<Integer> root, int data) {
        if(root==null)
        {
            Tree<Integer> dataNode=new Tree<>(data);
            return dataNode;
        }
        if(data>root.data)
        {
            root.right=insertData(root.right,data);
        }
        else if(data<root.data)
        {
            root.left=insertData(root.left,data);
        }
        return root;
    }

    public boolean hasData(int data) {
        return hasDataHelper(data,root);
    }

    private boolean hasDataHelper(int data, Tree<Integer> root) {
        if(root==null)
        {
            return false;
        }
        else if(root.data==data)
        {
            return true;
        }
        if(data>root.data)
        {
            return hasDataHelper(data,root.right);
        }
        if(data<root.data)
        {
            return hasDataHelper(data,root.left);
        }
        return false;
    }

    public Tree<Integer> delete(int data)
    {
        return deleteHelper(data,root);
    }

    private Tree<Integer> deleteHelper(int data, Tree<Integer> root) {
        if(root==null)
        {
            return root;
        }
        if(root.data==data && root.left==null && root.right==null)
        {
            return null;
        }
        if(root.data==data)
        {
            if(root.right==null)
            {
                return root.left;
            }
            else if(root.left==null)
            {
                return root.right;
            }
            else
            {
                int min= getminimum(root.right);
                Tree<Integer> newRoot=new Tree<>(min);
                newRoot.left=root.left;
                newRoot.right=root.right;
                root=newRoot;
                return root;

            }
        }
        if(data>root.data)
        {
            root.right=deleteHelper(data,root.right);
        }
        if(data<root.data)
        {
            root.left=deleteHelper(data,root.left);
        }
        return root;
    }

    private int getminimum(Tree<Integer> right) {
        if(right.left==null)
        {
            int temp=right.data;
            right=null;
            return temp;

        }
        return getminimum(right.left);
    }

    public Tree<Integer> getRoot()
    {
        return root;
    }
}
