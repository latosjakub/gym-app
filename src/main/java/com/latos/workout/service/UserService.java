package com.latos.workout.service;

import com.latos.workout.dto.user.UserCreateRequest;
import com.latos.workout.dto.user.UserProfileDto;
import com.latos.workout.dto.user.UserResponse;
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


    public UserResponse createUserWithProfile(UserCreateRequest createUserRequest) {
        UserProfile profile = new UserProfile(
        );

        User newUser = new User(
                createUserRequest.getUsername(),
                createUserRequest.getEmail(),
                createUserRequest.getPassword(),
                profile
        );

        return userToUserResponse(userRepository.save(newUser));
    }

    public UserResponse userToUserResponse(User user){
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                userProfileToUserProfileDto(user.getProfile())
        );
    }

    public UserProfileDto userProfileToUserProfileDto(UserProfile userProfile){
        return new UserProfileDto(
                userProfile.getName(),
                userProfile.getLastname(),
                userProfile.getAge(),
                userProfile.getWeight()
        );
    }




    public Optional<UserProfileDto> updateUserProfile(Long id, UserProfileDto userProfileDto) {
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

        profile.setName(userProfileDto.getFirstName());
        profile.setLastname(userProfileDto.getLastName());
        profile.setAge(userProfileDto.getAge());
        profile.setWeight(userProfileDto.getWeight());

        userRepository.save(user);
        return Optional.of(userProfileToUserProfileDto(profile));




    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);


    }

    public Optional<UserResponse> getUserWithProfile(Long id) {
        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(userToUserResponse(user.get()));
    }
}
