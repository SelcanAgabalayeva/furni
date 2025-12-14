package az.edu.itbrains.furni.Controllers;

import az.edu.itbrains.furni.dtos.RegisterDto;
import az.edu.itbrains.furni.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String thankyou(){
        return "register.html";
    }
    @PostMapping("/register")
    public String register(RegisterDto registerDto){
        boolean result=userService.registerUser(registerDto);
        if (result){
            return "redirect:/register";
        }
        return  "redirect:/register";
    }
    @GetMapping("/login")
    public String login(@RequestParam(value = "error",required = false) String error, Model model){
        if (error!=null){
            model.addAttribute("loginError","Melumet sehvdir");

        }
        return "register.html";
    }



}
