package az.edu.itbrains.furni.services;

import az.edu.itbrains.furni.dtos.RegisterDto;
import az.edu.itbrains.furni.models.User;

public interface UserService {
    boolean registerUser(RegisterDto registerDto);


}
