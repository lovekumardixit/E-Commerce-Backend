package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserRepo repo;

    // Constructor Injection
    public UserController(UserRepo repo) {
        this.repo = repo;
    }

    // Saare users fetch karne ke liye (Browser/Postman)
    @GetMapping("/users")
    public List<User> getUsers(){
        return repo.findAll();
    }
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id) {
        return repo.findById(id).orElse(null);
    }
    @GetMapping("/users/search/{name}")
    public List<User> getUserByName(@PathVariable String name) {
        return repo.findByName(name);
    }
    // Parameter based request
    // URL: http://localhost:8080/api/users/search?name=Vivek Dixit
//    @GetMapping("/users/search")
//    public List<User> getUserByName(@RequestParam String name) {
//        return repo.findByName(name);
//    }

    // Naya user add karne ke liye (Postman)
    @PostMapping("/users")
    public User addUser(@RequestBody User u){
        return repo.save(u);
    }
    // ID ke base par delete karne ke liye
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id) {
        if(repo.existsById(id)) {
            repo.deleteById(id);
            return "User with ID " + id + " deleted successfully!";
        } else {
            return "User not found!";
        }
    }
}