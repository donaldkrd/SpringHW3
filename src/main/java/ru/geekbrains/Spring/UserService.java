package ru.geekbrains.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final List<User> users = new ArrayList<>();
    private final NotificationService notificationService;
    @Autowired
    public UserService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
    public List<User> getUsers() {
//        notificationService.getAll();
        return users;
    }
    public User createUser(String name, int age, String email) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);
        notificationService.notifyUser(user);
        return user;
    }
    public NotificationService getNotificationService() {
        return notificationService;
    }
}
