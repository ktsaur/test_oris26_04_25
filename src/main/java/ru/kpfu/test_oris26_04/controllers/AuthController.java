package ru.kpfu.test_oris26_04.controllers;

import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.test_oris26_04.dto.UserRegisterDto;
import ru.kpfu.test_oris26_04.services.UserService;

@Controller
public class AuthController {

    @Autowired
    public UserService userService;

    @PostMapping("/register")
    public String register(@RequestParam("username") String username, @RequestParam("email") String email, @RequestParam("password") String password) {
        UserRegisterDto userDto = new UserRegisterDto();
        userDto.setUsername(username);
        userDto.setEmail(email);
        userDto.setPassword(password);
        userService.saveUser(userDto);
        return "redirect:/confirmation-send";
    }
}
