package az.edu.itbrains.furni.services.impl;

import az.edu.itbrains.furni.dtos.RegisterDto;
import az.edu.itbrains.furni.models.User;
import az.edu.itbrains.furni.repositories.UserRepository;
import az.edu.itbrains.furni.services.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;

        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean registerUser(RegisterDto registerDto) {
        User findUser=userRepository.findByUsername(registerDto.getUsername());
        if ((findUser!=null)){
            return false;
        }
        User user=new User();
        user.setEmail(registerDto.getEmail());
        user.setUsername(registerDto.getUsername());


        String password=passwordEncoder.encode(registerDto.getPassword());//cefer12//?fefhire12234
        user.setPassword(password);
        userRepository.save(user);
        return true;



    }




}
