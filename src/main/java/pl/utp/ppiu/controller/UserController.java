package pl.utp.ppiu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.utp.ppiu.model.User;
import pl.utp.ppiu.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController     // klasa mapująca żądania protokołu http na dane json
public class UserController {
    @Autowired      // wstrzyknięcie zależności przez pole!!!
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/orderedUsers")
    public List<User> getAllUsersOrderByRegistrationDateTimeDesc(){
        return userService.getAllUsersOrderByRegistrationDateTimeDesc();
    }
    @GetMapping("/user/{email}")
    public User getUserByEmail(
            @PathVariable("email") String email
    ){
        return userService.getUserByEmail(email).get();
    }
    @PutMapping("/user/update")
    public void updateUserPassword(@RequestParam("email") String email, @RequestParam("password") String password){
        userService.updateUserPassword(email,password);
    }
    @DeleteMapping("/user/delete")
    public void deleteUserByEmail(@RequestParam("email") String email){
        userService.deleteUserByEmail(email);
    }


}
