package pl.utp.ppiu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.stereotype.Service;
import pl.utp.ppiu.model.User;
import pl.utp.ppiu.repository.UserRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service        // klasa implementująca logikę biznesową dla obiektu user
public class UserService {

    public List<User> getAllUsers(){
        return UserRepository.users;
    }
    public List<User> getAllUsersOrderByRegistrationDateTimeDesc(){
        return UserRepository.users.stream()
                .sorted((o1, o2) -> o2.getRegistrationDateTime().compareTo(o1.getRegistrationDateTime()))
                .collect(Collectors.toList());
    }
    public Optional<User> getUserByEmail(String email){
        return UserRepository.users.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
    }
    public void updateUserPassword(String email, String password){
        Optional<User> userOptional = getUserByEmail(email);
        userOptional.ifPresent(user -> {
            User userToUpdate = userOptional.get();
            userToUpdate.setPassword(password);
        });
    }
    public void deleteUserByEmail(String email){
        Optional<User> userOptional = getUserByEmail(email);
        userOptional.ifPresent(user -> {
            User userToUpdate = userOptional.get();
            UserRepository.users.remove(userToUpdate);
        });
    }
}
