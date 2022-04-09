package org.opinions.analyst.controllers;

import org.opinions.analyst.exeptions.ResourceNotFoundExeption;
import org.opinions.analyst.models.User;
import org.opinions.analyst.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/u1/")
public class UserController
{
    @Autowired
    private UserRepository userRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/users")
    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    // create user rest api
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/users")
    public User createUser(@RequestBody User user)
    {
        return userRepository.save(user);
    }

    // get user by id
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id)
    {
        User user =userRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundExeption("User not exist whis id "+id));
        return ResponseEntity.ok(user);
    }
//update user rest api
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id,@RequestBody User userDetails)
    {
        User user =userRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundExeption("User not exist whis id "+id));
        user.setLogin(userDetails.getLogin());
        user.setTelephone(userDetails.getTelephone());
        User updateUser = userRepository.save(user);
        return ResponseEntity.ok(updateUser);
    }

    //delete user rest api
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteUser(@PathVariable long id)
    {
        User user =userRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundExeption("User not exist whis id "+id));
        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }
}
