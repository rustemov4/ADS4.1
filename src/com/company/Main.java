
package com.company;
import java.util.Scanner;
class Node
{
    Node left, right;
    int key;

    public Node(int key)
    {
        left = null;
        right = null;
        this.key = key;
    }
    /* Function to set left node */
    public void setLeft(Node left)
    {
        this.left = left;
    }
    /* Function to set right node */
    public void setRight(Node right)
    {
        this.right = right;
    }
    /* Function to get left node */
    public Node getLeft()
    {
        return left;
    }
    /* Function to get right node */
    public Node getRight()
    {
        return right;
    }

    public int getKey()
    {
        return key;
    }

}
class BST
{
     private Node root;

    public BST()
    {
        root = null;
    }
    public void insert(int data)
    {
        root = insertKey(root, data);
    }
    public Node insertKey(Node node, int key)
    {
        if (node == null){
            node = new Node(key);
            return node;}
        else
        {
            if (key <= node.getKey()){
                node.left = insertKey(node.left, key);}
            else if(key > node.getKey()){
                node.right = insertKey(node.right, key);}
        }
        return node;
    }
    public void delete(int k)
    { root = deleteKey(root, k);
      System.out.println("Deleted");
    }
    private Node deleteKey(Node root, int k)
    {
        Node temp1;
        Node temp2;
        Node n;
        if (root.getKey() == k)
        {
            Node left, right;
            left = root.getLeft();
            right = root.getRight();
            if (left == null && right == null)
                return null;
            else if (left == null)
            {
                temp1 = right;
                return temp1;
            }
            else if (right == null)
            {
                temp1 = left;
                return temp1;
            }
            else
            {
                temp2 = right;
                temp1 = right;
                while (temp1.getLeft() != null){
                    temp1 = temp1.getLeft();}
                temp1.setLeft(left);
                return temp2;
            }
        }
        if (k < root.getKey())
        {
            n = deleteKey(root.getLeft(), k);
            root.setLeft(n);
        }
        else
        {
            n = deleteKey(root.getRight(), k);
            root.setRight(n);
        }
        return root;
    }
    public void inorder()
    {
        inorder(root);
    }
    private void inorder(Node root)
    {
        if (root != null)
        {
            inorder(root.getLeft());
            System.out.print(root.getKey() +" ");
            inorder(root.getRight());
        }
    }
}
public class Main {
    public static void main(String[] args) {
        BST bst = new BST();
        Scanner in = new Scanner(System.in);
        for(int i = 0; i < 10; i++){
            int a = in.nextInt();
            bst.insert(a);
        }
        bst.inorder();


    }
}


