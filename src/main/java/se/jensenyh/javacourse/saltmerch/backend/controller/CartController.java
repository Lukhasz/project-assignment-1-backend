package se.jensenyh.javacourse.saltmerch.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.jensenyh.javacourse.saltmerch.backend.repository.CartRepository;

@CrossOrigin//(origins = {"http://localhost:3010", "http://localhost:5432"})
@RestController
@RequestMapping("/carts")
public class CartController {


    @Autowired
    CartRepository cartRepository;

    @GetMapping("/")
    public Object getCart() {
        return cartRepository.selectAllItems();
    }

//    @PatchMapping("/{id}")
//    public Object addOrItemToCart(@PathVariable("id") int id,
//

}
