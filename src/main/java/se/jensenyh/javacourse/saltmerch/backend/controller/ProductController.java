package se.jensenyh.javacourse.saltmerch.backend.controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpOutputMessage;
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



    @GetMapping("")
    public List<Product> getAllProducts() {
        return productRepository.selectAll();
    }


//    @GetMapping("/{category}")
//    public List<Product> getAllFromSpecificCategory(@PathVariable("category") String category) {
//        return productRepository.selectAllOfCategory(category);
//    }


    @GetMapping("{variable}")
    public Object getAllFromSpecificCategoryOrID(@PathVariable("variable") String var) {
        switch (var) {
            case "hats":
                return productRepository.selectAllOfCategory(var);
            case "jackets":
                return productRepository.selectAllOfCategory(var);
            case "tshirts":
                return productRepository.selectAllOfCategory(var);
            case "bags":
                return productRepository.selectAllOfCategory(var);
            default:
                int number = Integer.parseInt(var);
                return productRepository.getEntireProduct(number);
        }
    }



//    @GetMapping("/hats")
//    public List<Product> getAllHats() {
//        return productRepository.selectAllOfCategory("hats");
//    }
//
//    @GetMapping("/jackets")
//    public List<Product> getAllJackets() {
//        return productRepository.selectAllOfCategory("jackets");
//    }
//
//    @GetMapping("/tshirts")
//    public List<Product> getAllTShirts() {
//        return productRepository.selectAllOfCategory("tshirts");
//    }
//
//    @GetMapping("/bags")
//    public List<Product> getAllBags() {
//        return productRepository.selectAllOfCategory("bags");
//    }
//
//
//    @GetMapping("/{id}")
//    public Product getProduct(@PathVariable("id") int id) {
//        return productRepository.getEntireProduct(id);
//    }


    @PostMapping("/hats")
    public ResponseEntity<Product> addHat(@RequestBody Product prod) {
        String category = "hats";
        productRepository.insertProductAndProps(prod, category);
        return new ResponseEntity<>(prod, HttpStatus.CREATED);
    }

    @PostMapping("/jackets")
    public ResponseEntity<Product> addJacket(@RequestBody Product prod) {
        String category = "jackets";
        productRepository.insertProductAndProps(prod, category);
        return new ResponseEntity<>(prod, HttpStatus.CREATED);
    }

    @PostMapping("/tshirts")
    public ResponseEntity<Product> addTShirt(@RequestBody Product prod) {
        String category = "tshirts";
        productRepository.insertProductAndProps(prod, category);
        return new ResponseEntity<>(prod, HttpStatus.CREATED);
    }

    @PostMapping("/bags")
    public ResponseEntity<Product> addBag(@RequestBody Product prod) {
        String category = "bags";
        productRepository.insertProductAndProps(prod, category);
        return new ResponseEntity<>(prod, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProductMetadata(@PathVariable("id") int id, @RequestBody Product body) {
        productRepository.updateProductMeta(id, body);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping("/{id}/variants")
    public ResponseEntity<Product> createVariantForSpecificProduct(@PathVariable("id") int id, @RequestBody ColorVariant body) {
        productRepository.addVariant(id, body);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PutMapping("/{id}/variants/stock")
    public ResponseEntity<Product> restockSpecificSizeOfVariant(@PathVariable("id") int id,
                                                       @RequestParam String size,
                                                       String color,
                                                       int quantity) {
        productRepository.restockSize(id, size, color, quantity);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") int id) {
        productRepository.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("/{productId}/variants/{variantId}")
    public ResponseEntity<Product> deleteVariant(@PathVariable("productId") int pid, @PathVariable ("variantId") String vid) {
        productRepository.deleteVariant(pid, vid);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
