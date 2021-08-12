package DSA2.BinaryTree;

public class Tree<T> {
    public Tree left;
    public Tree right;
    public T data;
    public Tree(T data)
    {
        this.data=data;
        left=null;
        right=null;
    }
}
