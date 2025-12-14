package az.edu.itbrains.furni.repositories;

import az.edu.itbrains.furni.dtos.CartItemDto;
import az.edu.itbrains.furni.models.Cart;
import az.edu.itbrains.furni.models.Product;
import az.edu.itbrains.furni.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Long> {
    List<Cart> findByUserUsername(String username);

    Cart findByUserAndProduct(User user, Product product);

    Cart findByUserUsernameAndProductId(String username, Long productId);
}
