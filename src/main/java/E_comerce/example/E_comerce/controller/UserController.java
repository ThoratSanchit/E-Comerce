package E_comerce.example.E_comerce.controller;

import E_comerce.example.E_comerce.model.User;
import E_comerce.example.E_comerce.repository.UserRepository;
import E_comerce.example.E_comerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User loginData) {
        User user = userService.loginUser(loginData.getEmail(), loginData.getPassword());

        return user != null ? "Login Successful" : "Invalid Email or Password";
    }

    @GetMapping("/userinfo/{email}")
    public Optional<User> getUserInfo(@PathVariable String email) {

        Optional<User> user=userRepository.findByEmail(email);

        return  user;


    }

}
