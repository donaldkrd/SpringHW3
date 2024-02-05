package ru.geekbrains.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
@Service
public class DataProcessingService {
    private final UserService userService;
    @Autowired
    public DataProcessingService(UserService userService) {
        this.userService = userService;
    }

    public List<User> sortUsersByAge(List<User> users){
        userService.getNotificationService().sortUsersByAge();
        return users.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList());
    }
    public List<User> filterUsersByAge(List<User> users, int age){
        userService.getNotificationService().filterUsersByAge();
        return users.stream().filter(user -> user.getAge() > age).collect(Collectors.toList());
    }

    public double calculateAverageAge(List<User> users){
        userService.getNotificationService().calculateAverage();
        return users.stream().mapToDouble(User::getAge).average().orElse(0);
    }
    public void addUserInList(User user){
        userService.getUsers().add(user);
    }
}
