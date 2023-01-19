package se.jensenyh.javacourse.saltmerch.backend.controller;


import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.jensenyh.javacourse.saltmerch.backend.model.CartItem;
import se.jensenyh.javacourse.saltmerch.backend.service.CartService;

@CrossOrigin (origins = "http://localhost:3010")
@RestController
@RequestMapping("/carts")
public class CartController {


    @Autowired
    CartService cartService;


//    @GetMapping("")
//    public ResponseEntity<CartItem> getCart() {
//        cartRepository.selectAllItems();
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<CartItem> getCartId() {
        cartService.getCart();
        return new ResponseEntity<>(HttpStatus.OK);
    }


    //TODO: Figure out how to utilize PathVariable id
    @PatchMapping("/{id}")
    public ResponseEntity<CartItem> addOrRemoveItemFromCart(@PathVariable("id") int id,
                                                            @RequestParam String action,
                                                            @RequestBody CartItem cartItem) {

        if (id == 1) {
            int fromCartService = cartService.addOrRemoveItemFromCart(action, cartItem);

            switch (fromCartService) {
                case 1:
                    return new ResponseEntity<>(HttpStatus.OK);
                case -1:
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                case -2:
                    return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        }
//        if (Objects.equals(action, "add")) {
//            cartRepository.insertOrIncrementItem(cartItem);
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//
//        if (Objects.equals(action, "remove")) {
//            cartRepository.deleteOrDecrementItem(cartItem);
//            return new ResponseEntity<>(HttpStatus.OK);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    //TODO: Figure out how to utilize PathVariable id
    @DeleteMapping("/{id}")
    public ResponseEntity<CartItem> clearCartContentsOrRestock(@PathVariable("id") int id,
                                                               @RequestParam @Nullable boolean buyout) {

        if (id == 1) {
            cartService.emptyCart(buyout);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);


//        if (Objects.equals(buyout, "true")) {
//            cartRepository.deleteAllItems(false);
//            return new ResponseEntity<>(HttpStatus.OK);
//
//        } else {
//            cartRepository.deleteAllItems(true);
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
    }
}
