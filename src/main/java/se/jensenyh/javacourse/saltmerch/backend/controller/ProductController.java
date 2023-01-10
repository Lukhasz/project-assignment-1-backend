package se.jensenyh.javacourse.saltmerch.backend.controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.jensenyh.javacourse.saltmerch.backend.model.ColorVariant;
import se.jensenyh.javacourse.saltmerch.backend.model.Product;
import se.jensenyh.javacourse.saltmerch.backend.repository.ProductRepository;

import java.awt.*;
import java.util.List;
@CrossOrigin (origins = "http://localhost:3010")
@RestController
@RequestMapping("/products")
public class ProductController
{

    @Autowired
    ProductRepository productRepository;

//    @GetMapping("/")
//    public ResponseEntity getAllProducts() {
//        productRepository.selectAll();
//        return new ResponseEntity(HttpStatus.OK);
//    }

    @GetMapping("")
    public List<Product> getAllProducts() {
        return productRepository.selectAll();
    }

    @GetMapping("/hats")
    public List<Product> getAllHats() {
        return productRepository.selectAllOfCategory("hats");
    }

    @GetMapping("/jackets")
    public List<Product> getAllJackets() {
        return productRepository.selectAllOfCategory("jackets");
    }

    @GetMapping("/tshirts")
    public List<Product> getAllTShirts() {
        return productRepository.selectAllOfCategory("tshirts");
    }

    @GetMapping("/bags")
    public List<Product> getAllBags() {
        return productRepository.selectAllOfCategory("bags");
    }


    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") int id) {
        return productRepository.getEntireProduct(id);
    }


    @PostMapping("/hats")
    public ResponseEntity<Product> addHat(@RequestBody Product prod, @RequestBody String category) {
        productRepository.insertProductAndProps(prod, category);
        return new ResponseEntity<>(prod, HttpStatus.CREATED);
    }


//    @PostMapping("/hats")
//    public Product addHat(@RequestBody Product prod, @RequestBody String category) {
//        productRepository.insertProductAndProps(prod, category);
//        return new Product(prod, HttpStatus.CREATED);
//    }

//    @PostMapping("/hats")
//    public ResponseEntity addHat(@RequestBody Product id, @RequestBody String body) {
//        productRepository.addVariant(id, body);
//        return new ResponseEntity(id, HttpStatus.CREATED);
//    }

    @PostMapping("/jackets")
    public ResponseEntity addJacket(@RequestBody Product prod, @RequestBody String category) {
        productRepository.insertProductAndProps(prod, category);
        return new ResponseEntity(prod, HttpStatus.CREATED);
    }

    @PostMapping("/tshirts")
    public ResponseEntity addTShirt(@RequestBody Product prod, @RequestBody String category) {
        productRepository.insertProductAndProps(prod, category);
        return new ResponseEntity(prod, HttpStatus.CREATED);
    }

    @PostMapping("/bags")
    public ResponseEntity addBag(@RequestBody Product prod, @RequestBody String category) {
        productRepository.insertProductAndProps(prod, category);
        return new ResponseEntity(productRepository.insertProductAndProps(prod, category).id, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable("id") int id, @RequestBody Product body) {
        productRepository.updateProductMeta(id, body);
        return new ResponseEntity(HttpStatus.OK);
    }


    @PostMapping("/{id}/variants")
    public ResponseEntity createVariant(@PathVariable("id") int id, @RequestBody ColorVariant body) {
        productRepository.addVariant(id, body);
        return new ResponseEntity(HttpStatus.CREATED);
    }


    @PutMapping("/{id}/variants/stock")
    public ResponseEntity restockSpecificSizeOfVariant(@PathVariable("id") int id,
                                                       @RequestParam String size,
                                                       String color,
                                                       int quantity) {
        productRepository.restockSize(id, size, color, quantity);
        return new ResponseEntity(HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") int id) {
        productRepository.deleteProduct(id);
        return new ResponseEntity(HttpStatus.OK);
    }


    @DeleteMapping("/{productId}/variants/{variantId}")
    public ResponseEntity deleteVariant(@PathVariable("productId") int pid, @PathVariable ("variantId") int vid) {
        productRepository.deleteVariant(pid, String.valueOf(vid));
        return new ResponseEntity(HttpStatus.OK);
    }


}
