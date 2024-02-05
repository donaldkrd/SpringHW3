package ru.geekbrains.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class DataProcessingController {
    private final DataProcessingService dataProcessingService;
    private final UserService userService;
    @Autowired
    public DataProcessingController(DataProcessingService dataProcessingService, UserService userService){
        this.dataProcessingService = dataProcessingService;
        this.userService = userService;
    }
    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public ResponseEntity<List<User>> sortUsers(@RequestBody List<User> users){
        return new ResponseEntity<>(this.dataProcessingService.sortUsersByAge(this.userService.getUsers()), HttpStatus.OK);
    }
    @RequestMapping(value = "/filter/{age}", method = RequestMethod.GET)
    public ResponseEntity<List<User>> filterByAge(@PathVariable("age") Integer age, @RequestBody List<User> users){
        return new ResponseEntity<>(this.dataProcessingService.filterUsersByAge(this.userService.getUsers(), age), HttpStatus.OK);
    }
    @RequestMapping(value = "/average", method = RequestMethod.POST)
    public ResponseEntity<Double> average(@RequestBody List<User> users){
        return new ResponseEntity<>(this.dataProcessingService.calculateAverageAge(this.userService.getUsers()), HttpStatus.OK);
    }
}
