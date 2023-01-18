package se.jensenyh.javacourse.saltmerch.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import se.jensenyh.javacourse.saltmerch.backend.model.CartItem;
import se.jensenyh.javacourse.saltmerch.backend.repository.CartRepository;

import java.util.List;
import java.util.Objects;

public class CartService {

    @Autowired
    CartRepository cartRepository;

    public List<CartItem> getCart() {
        return cartRepository.selectAllItems();
    }

    public int addOrRemoveItemFromCart(String execute, CartItem cartItem) {
        if (Objects.equals(execute, "add")) {
            return cartRepository.insertOrIncrementItem(cartItem);
        }
        if (Objects.equals(execute, "remove")) {
            return cartRepository.deleteOrDecrementItem(cartItem);
        }
        else return -1;
    }

}
