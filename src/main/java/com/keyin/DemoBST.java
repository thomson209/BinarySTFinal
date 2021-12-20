package com.keyin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class DemoBST {

    public static void main(String[] args) {
        SpringApplication.run(DemoBST.class, args);
    }
    @PostMapping("/bst/add")
    public BST.Node addNode(BST.Node newNode) {
        return addNode(newNode);
    }

    @GetMapping("bst/{node}")
    public List<BST.Node> BST() {
        return List.of(BST.root);
    }
}
