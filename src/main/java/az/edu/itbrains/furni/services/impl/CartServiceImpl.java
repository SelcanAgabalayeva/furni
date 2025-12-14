package az.edu.itbrains.furni.services.impl;

import az.edu.itbrains.furni.dtos.CartItemDto;
import az.edu.itbrains.furni.models.Cart;
import az.edu.itbrains.furni.models.Product;
import az.edu.itbrains.furni.models.User;
import az.edu.itbrains.furni.repositories.CartRepository;
import az.edu.itbrains.furni.repositories.ProductRepository;
import az.edu.itbrains.furni.repositories.UserRepository;
import az.edu.itbrains.furni.services.CartService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public CartServiceImpl(CartRepository cartRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<CartItemDto> getCartItemByUsername(String username) {

        return cartRepository.findByUserUsername(username)
                .stream()
                .map(cart -> new CartItemDto(
                        cart.getId(),
                        cart.getImageUrl(),
                        cart.getName(),
                        cart.getPrice(),
                        cart.getProduct().getId(),
                        cart.getQuantity()
                ))
                .toList();
    }

    @Override
    public double calculateSubtotal(List<CartItemDto> cartItemDtoList) {
        return cartItemDtoList.stream().mapToDouble(item ->item.getPrice()*item.getQuantity()).sum();

    }

    @Override
    public void addToCart(String username, Long productId) {
        User user=userRepository.findByUsername(username);
        Product product=productRepository.findById(productId).orElseThrow();

        Cart exist=cartRepository.findByUserAndProduct(user,product);
        if(exist!=null){
            exist.setQuantity(exist.getQuantity()+1);
            cartRepository.save(exist);

        }
        else {
            Cart newCart=new Cart();
            newCart.setUser(user);
            newCart.setProduct(product);
            newCart.setQuantity(1);
            newCart.setImageUrl(product.getImageUrl());
            newCart.setName(product.getName());
            newCart.setPrice(product.getPrice());
            cartRepository.save(newCart);
        }




    }

    @Override
    public void deleteItem(String username, Long productId) {
        Cart item=cartRepository.findByUserUsernameAndProductId(username,productId);
        if(item!=null){
            cartRepository.delete(item);
        }
    }

    @Override
    public void increaseQuantity(String username, Long productId) {
        Cart item=cartRepository.findByUserUsernameAndProductId(username,productId);
            if(item!=null){
                item.setQuantity(item.getQuantity()+1);
                cartRepository.save(item);
            }

    }

    @Override
    public void decreaseQuantity(String username, Long productId) {
        Cart item=cartRepository.findByUserUsernameAndProductId(username,productId);
            if(item!=null){
                if(item.getQuantity()>1){
                    item.setQuantity(item.getQuantity()-1);
                    cartRepository.save(item);
                }else {
                    cartRepository.delete(item);
                }

            }
        }
    }



