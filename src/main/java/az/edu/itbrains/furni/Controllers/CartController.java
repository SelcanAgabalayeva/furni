package az.edu.itbrains.furni.Controllers;

import az.edu.itbrains.furni.dtos.CartItemDto;
import az.edu.itbrains.furni.services.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }
    @GetMapping("/cart")
    private String cart(Model model, Principal principal){
        if(principal==null){
            return "redirect:/login";
        }
        String username= principal.getName();
        List<CartItemDto> cartItemDtoList=cartService.getCartItemByUsername(username);
        double subtotal=cartService.calculateSubtotal(cartItemDtoList);
        model.addAttribute("cartItems",cartItemDtoList);
        model.addAttribute("cartTotal",subtotal);
        return "cart.html";

    }
    @PostMapping("/cart/add")
    public String addToCart(@RequestParam Long productId,Principal principal){
        if(principal==null){
            return "redirect:/login";
        }
        String username= principal.getName();
        cartService.addToCart(username,productId);
        return "redirect:/cart";

    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long productId,Principal principal){
        String username= principal.getName();
        cartService.deleteItem(username,productId);
        return "redirect:/cart";
    }
    @PostMapping("/update")
    public String updateQuantity(@RequestParam Long productId,@RequestParam String action, Principal principal){
        String username= principal.getName();

        if(action.equals("increase")){
            cartService.increaseQuantity(username,productId);
        }else if(action.equals("decrease")){
            cartService.decreaseQuantity(username,productId);

        }
        return "redirect:/cart";

    }


}
