package io.spring.restfulwebservice.service;

import io.spring.restfulwebservice.model.User;
import io.spring.restfulwebservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static List<User> USERS = new ArrayList<>();

    private UserRepository userRepository;

    @Autowired
    public UserDaoService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private static long userCount = 0;

    static {
        USERS.add(new User(++userCount, "Adam", LocalDate.now().minusYears(30)));
        USERS.add(new User(++userCount, "eve", LocalDate.now().minusYears(40)));
        USERS.add(new User(++userCount, "Jim", LocalDate.now().minusYears(23)));
        USERS.add(new User(++userCount, "Jack", LocalDate.now().minusYears(12)));
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findUser(long id) {
        /*Predicate<? super User> predicate = user -> user.getId() == id;
         USERS.stream().filter(predicate).findFirst().orElse(null);*/
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        /*User newUser = new User(++userCount, user.getName(), user.getBirthDate());
        USERS.add(newUser);*/
//        long maxId = userRepository.findAll()
//                .stream()
//                .max(Comparator.comparing(User::getId))
//                .get().getId();
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    public void deleteUserById(long id) {
        /*Predicate<? super User> predicate = user -> user.getId() == id;
        USERS.removeIf(predicate);*/
        userRepository.deleteById(id);
    }
}
