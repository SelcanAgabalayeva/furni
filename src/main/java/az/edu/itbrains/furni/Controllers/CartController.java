package az.edu.itbrains.furni.Controllers;

import az.edu.itbrains.furni.dtos.CartItemDto;
import az.edu.itbrains.furni.dtos.CouponDto;
import az.edu.itbrains.furni.services.CartService;
import az.edu.itbrains.furni.services.CouponService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class CartController {
    private final CartService cartService;
    private final CouponService couponService;

    public CartController(CartService cartService, CouponService couponService) {
        this.cartService = cartService;
        this.couponService = couponService;
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


    @PostMapping("/apply-coupon")
    public String applyCoupon(@RequestParam String couponCode, HttpSession httpSession, RedirectAttributes redirectAttributes){
        Optional<CouponDto> couponDtoOptional=couponService.validateCoupon(couponCode);
        if(couponDtoOptional.isPresent()){
            httpSession.setAttribute("appliedCoupon",couponDtoOptional.get());
            redirectAttributes.addFlashAttribute("couponSuccess","Coupon applied success");

        }else {
            httpSession.removeAttribute("appliedCoupon");
            redirectAttributes.addFlashAttribute("couponError","Coupon wrong unsuccess");

        }
        return "redirect:/cart";
    }


}
