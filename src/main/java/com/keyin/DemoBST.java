package com.keyin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class DemoBST {
    public static void main(String[] args) {
        SpringApplication.run(DemoBST.class, args);
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
