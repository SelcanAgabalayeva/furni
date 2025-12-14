package az.edu.itbrains.furni.services;

import az.edu.itbrains.furni.dtos.CartItemDto;

import java.util.List;

public interface CartService {
    List<CartItemDto> getCartItemByUsername(String username);

    double calculateSubtotal(List<CartItemDto> cartItemDtoList);


    void addToCart(String username, Long productId);

    void deleteItem(String username, Long productId);

    void increaseQuantity(String username, Long productId);

    void decreaseQuantity(String username, Long productId);
}
