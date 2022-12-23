package se.jensenyh.javacourse.saltmerch.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.jensenyh.javacourse.saltmerch.backend.model.Product;
import se.jensenyh.javacourse.saltmerch.backend.repository.ProductRepository;

import java.util.List;
@CrossOrigin//(origins = {"http://localhost:3010", "http://localhost:5432"})
@RestController
@RequestMapping("/products")
public class ProductController
{

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/")
    public Object getAllProducts() {
        return productRepository.selectAll();
    }

    @GetMapping("/hats")
    public Object getAllHats() {
        return productRepository.selectAllOfCategory("hats");
    }

    @GetMapping("/jackets")
    public Object getAllJackets() {
        return productRepository.selectAllOfCategory("jackets");
    }

    @GetMapping("/tshirts")
    public Object getAllTShirts() {
        return productRepository.selectAllOfCategory("tshirts");
    }

    @GetMapping("/bags")
    public Object getAllBags() {
        return productRepository.selectAllOfCategory("bags");
    }


    @GetMapping("/{id}")
    public Object getProduct(@PathVariable("id") int id) {
        return productRepository.getEntireProduct(id);
    }


//    @PostMapping("/hats")
//    public ResponseEntity addHats(@RequestBody Product body) {
//
//    }

}
