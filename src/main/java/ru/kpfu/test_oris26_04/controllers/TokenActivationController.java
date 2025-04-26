package ru.kpfu.test_oris26_04.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.test_oris26_04.model.User;
import ru.kpfu.test_oris26_04.repository.UserRepository;
import ru.kpfu.test_oris26_04.services.UserService;

@Controller
public class TokenActivationController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/activate")
    public String activateAccount(@RequestParam String token) {
        User user = userService.findByActivationToken(token);


        user.setActivated(true);
        user.setActivationToken(null);

        userService.activateUser(token);

        return "activation-success";
    }
}