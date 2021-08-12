package DSA2.BST;

import DSA2.BinaryTree.Tree;
import DSA2.BinaryTree.UseBt;
import DSA2.LinkedList.Node;
import DSA2.LinkedList.PinkedList;

import java.util.LinkedList;
import java.util.Scanner;

public class BSTtoLL {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Tree<Integer> root= UseBt.insertRowWise(sc);
        NodePair<Node<Integer>,Node<Integer>> pair=getBetterLL(root);
        Node<Integer> head=pair.head;
        PinkedList.print(head);
    }

    private static NodePair<Node<Integer>, Node<Integer>> getBetterLL(Tree<Integer> root) {
        if(root==null)
        {
            NodePair<Node<Integer>,Node<Integer>> pair=new NodePair<>();
            pair.head=null;
            pair.tail=null;
            return pair;
        }
        NodePair<Node<Integer>,Node<Integer>> pairLeft=getBetterLL(root.left);
        NodePair<Node<Integer>,Node<Integer>> pairRight=getBetterLL(root.right);
        Node<Integer> mid=new Node<>(root.data);
        mid.next=pairRight.head;
        NodePair<Node<Integer>,Node<Integer>> pair=new NodePair<>();
        if(pairLeft.head==null)
        {
            pair.head= mid;
            if(pairRight.tail==null)
            {
                pair.tail=mid;
                return pair;
            }
            pair.tail= pairRight.tail;
            return pair;
        }
        {
            pair.head=pairLeft.head;
            pairLeft.tail.next=mid;
            if(pairRight.tail==null)
            {
                pair.tail=mid;
                return pair;
            }
            pair.tail=pairRight.tail;
            return pair;
        }



    }

    private static Node<Integer> getLL(Tree<Integer> root) {
        Node<Integer> head=null;
        if(root==null)
        {
            return null;
        }
        Node<Integer> mid=new Node<>(root.data);
        Node<Integer> left=getLL(root.left);
        Node<Integer> right=getLL(root.right);
        mid.next=right;

        if(left==null)
        {
            head=mid;
            return head;
        }
        else{
            head=left;
            while (left.next!=null)
            {
                left=left.next;
            }
            left.next=mid;
            return head;
        }
    }


}
class NodePair<T,V>
{
    T head;
    T tail;
}
