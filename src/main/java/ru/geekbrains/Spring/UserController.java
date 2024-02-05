package ru.geekbrains.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final RegistrationService registrationService;
    @Autowired
    public UserController(UserService userService, RegistrationService registrationService) {
        this.userService = userService;
        this.registrationService = registrationService;
    }
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUserList(){
        userService.getNotificationService().getAll();
        return new ResponseEntity<>(this.userService.getUsers(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestParam String name, @RequestParam int age, @RequestParam String email){
        return new ResponseEntity<>(this.userService.createUser(name, age, email), HttpStatus.CREATED);
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<User> addUser(@RequestParam String name, @RequestParam int age, @RequestParam String email){
        return new ResponseEntity<>(this.registrationService.addUser(name, age, email), HttpStatus.CREATED);
    }
}
