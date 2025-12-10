package com.latos.workout.controller;

import com.latos.workout.dto.user.CreateUserRequest;
import com.latos.workout.dto.user.UserCreateRequest;
import com.latos.workout.dto.user.UserProfileDto;
import com.latos.workout.dto.user.UserResponse;
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
    public ResponseEntity<UserResponse> createUser(@RequestBody UserCreateRequest userCreateRequest){
        UserResponse createdUser = userService.createUserWithProfile(userCreateRequest);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserWithProfie(@PathVariable Long id){
        Optional<UserResponse> userResponse = userService.getUserWithProfile(id);
        return userResponse.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PutMapping("/{id}/profile")
    public ResponseEntity<UserProfileDto> updateUser(
            @PathVariable Long id,
            @RequestBody UserProfileDto userProfileDto){
        Optional<UserProfileDto> profile = userService.updateUserProfile(id, userProfileDto);
        return profile.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
