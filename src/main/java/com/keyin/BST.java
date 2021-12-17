package com.keyin;

import java.util.Scanner;

class BST {

    // defines BST node
    class Node {
        int value;
        Node left, right;

        public Node(int data){
            value = data;
            left = right = null;
        }
    }
    // BST root node
    static Node root;

    // Constructor for BST - empty tree
    BST(){
        root = null;
    }
    //delete a node from BST
    void deleteValue(int value) {
        root = deleteRecursive(root, value);
    }

    //recursive delete function
    Node deleteRecursive(Node root, int value)  {
        //tree is empty
        if (root == null)  return root;

        //traverse the tree
        if (value < root.value)     //traverse left subtree
            root.left = deleteRecursive(root.left, value);
        else if (value > root.value)  //traverse right subtree
            root.right = deleteRecursive(root.right, value);
        else  {
            // node contains only one child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node has two children;
            //get inorder successor (min value in the right subtree)
            root.value = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRecursive(root.right, root.value);
        }
        return root;
    }

    int minValue(Node root)  {
        //initially minVal = root
        int minVal = root.value;
        //find minVal
        while (root.left != null)  {
            minVal = root.left.value;
            root = root.left;
        }
        return minVal;
    }

    // insert a node in BST
    void insert(int value)  {
        root = insertRecursive(root, value);
    }

    //recursive insert function
    Node insertRecursive(Node root, int value) {
        //tree is empty
        if (root == null) {
            root = new Node(value);
            return root;
        }
        //traverse the tree
        if (value < root.value)     //insert in the left subtree
            root.left = insertRecursive(root.left, value);
        else if (value > root.value)    //insert in the right subtree
            root.right = insertRecursive(root.right, value);
        // return pointer
        return root;
    }

    // method for inorder traversal of BST
    void inorder() {
        inorderRecursive(root);
    }

    // recursively traverse the BST
    void inorderRecursive(Node root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.print(root.value + " ");
            inorderRecursive(root.right);
        }
    }

    boolean search(int value)  {
        root = searchRecursive(root, value);
        return root != null;
    }

    //recursive insert function
    Node searchRecursive(Node root, int value) {
        // Base Cases: root is null or value is present at root
        if (root==null || root.value ==value)
            return root;
        // val is greater than root's value
        if (root.value > value)
            return searchRecursive(root.left, value);
        // val is less than root's value
        return searchRecursive(root.right, value);
    }
    void preOrder(Node node) {
        if (node == null)
            return;
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void main(String[] args)  {
        //create a BST object
        BST bst = new BST();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of nodes for your tree: ");
        int n = scanner.nextInt();
        int[] input = new int[n];

        System.out.println("Please enter the values: ");
        for (int i =0; i < n; i++) {
            int currInput = scanner.nextInt();
            bst.insert(currInput);
            input[i] = currInput;
        }

        System.out.println("Pre-order traversal of BST: ");
        bst.preOrder(BST.root);
        System.out.println("\nThe root value is: ");
        System.out.println(BST.root.value);
        scanner.close();

    }
}
