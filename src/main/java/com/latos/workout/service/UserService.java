package com.latos.workout.service;

import com.latos.workout.dto.CreateUserRequest;
import com.latos.workout.model.User;
import com.latos.workout.model.UserProfile;
import com.latos.workout.repository.UserProfileRepository;
import com.latos.workout.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserProfileRepository userProfileRepository;


    public UserService(UserRepository userRepository, UserProfileRepository userProfileRepository) {
        this.userRepository = userRepository;
        this.userProfileRepository = userProfileRepository;
    }


    public User createUserWithProfile(CreateUserRequest createUserRequest) {
        UserProfile profile = new UserProfile(
                createUserRequest.getFirstName(),
                createUserRequest.getLasName(),
                createUserRequest.getAge(),
                createUserRequest.getWeight()
        );

        User newUser = new User(
                createUserRequest.getUsername(),
                createUserRequest.getEmail(),
                createUserRequest.getPassword(),
                profile
        );

        return userRepository.save(newUser);
    }

    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    public Optional<UserProfile> updateUserProfile(Long id, UserProfile userProfile) {
        Optional<User> userOpt = userRepository.findById(id);

        if(userOpt.isEmpty()){
            return  Optional.empty();
        }

        User user = userOpt.get();

        UserProfile profile = user.getProfile();
        if(profile == null){
            profile = new UserProfile();
            user.setProfile(profile);
        }

        profile.setName(userProfile.getName());
        profile.setLastname(userProfile.getLastname());
        profile.setAge(userProfile.getAge());
        profile.setWeight(userProfile.getWeight());

        userRepository.save(user);
        return Optional.of(profile);




    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);


    }
}
