package com.latos.workout.controller;

import com.latos.workout.dto.CreateUserRequest;
import com.latos.workout.model.User;
import com.latos.workout.model.UserProfile;
import com.latos.workout.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserRequest createUserRequest){
        User created = userService.createUserWithProfile(createUserRequest);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserWithProfie(@PathVariable Long id){
        Optional<User> user = userService.getUser(id);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/profile")
    public ResponseEntity<UserProfile> updateUser(
            @PathVariable Long id,
            @RequestBody UserProfile userProfile){
        Optional<UserProfile> profile = userService.updateUserProfile(id, userProfile);
        return profile.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
