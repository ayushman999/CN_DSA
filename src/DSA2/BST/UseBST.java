package DSA2.BST;

import DSA2.BinaryTree.UseBt;

public class UseBST {
    public static void main(String[] args) {
        BST bst=new BST();
        bst.insert(4);
        bst.insert(1);
        bst.insert(6);
        bst.insert(3);
        bst.insert(5);
        bst.insert(2);
        bst.insert(0);
        UseBt.print(bst.getRoot());
        bst.delete(4);
        UseBt.print(bst.getRoot());
    }
}
