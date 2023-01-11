package se.jensenyh.javacourse.saltmerch.backend.controller;


import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.jensenyh.javacourse.saltmerch.backend.model.CartItem;
import se.jensenyh.javacourse.saltmerch.backend.model.Product;
import se.jensenyh.javacourse.saltmerch.backend.repository.CartRepository;

import java.util.Objects;

@CrossOrigin //(origins = "http://localhost:3010")
@RestController
@RequestMapping("/carts")
public class CartController {


    @Autowired
    CartRepository cartRepository;

    @GetMapping("")
    public ResponseEntity<CartRepository> getCart() {
        cartRepository.selectAllItems();
        return new ResponseEntity<>(HttpStatus.OK);
    }


    //TODO: Figure out how to utilize PathVariable id
    @PatchMapping("/{id}")
    public ResponseEntity<CartItem> addOrRemoveItemFromCart(@PathVariable("id") int id,
                                                            @RequestBody CartItem cartItem,
                                                            @RequestParam String action) {

        if (Objects.equals(action, "add")) {
            cartRepository.insertOrIncrementItem(cartItem);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        if (Objects.equals(action, "remove")) {
            cartRepository.deleteOrDecrementItem(cartItem);
            return new ResponseEntity<>(HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    //TODO: Figure out how to utilize PathVariable id
    @DeleteMapping("/{id}")
    public ResponseEntity<CartItem> clearCartContentsOrRestock(@PathVariable("id") int id,
                                                               @RequestParam @Nullable String buyout) {

        if (Objects.equals(buyout, "true")) {
            cartRepository.deleteAllItems(false);
            return new ResponseEntity<>(HttpStatus.OK);

        } else {
            cartRepository.deleteAllItems(true);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
