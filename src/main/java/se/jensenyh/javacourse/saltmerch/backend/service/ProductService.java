package se.jensenyh.javacourse.saltmerch.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import se.jensenyh.javacourse.saltmerch.backend.model.CartItem;
import se.jensenyh.javacourse.saltmerch.backend.repository.CartRepository;

import java.util.List;

public class ProductService {

    @Autowired
    CartRepository cartRepository;

    public List<CartItem> getCart() {
        return cartRepository.selectAllItems();
    }

    public int addOrRemoveItemFromCart(String execute, CartItem cartItem) {

    }

}
