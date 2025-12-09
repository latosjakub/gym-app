package com.latos.workout.dto.user;

public class UserResponse {
    private Long id;
    private String username;
    private String email;
    private UserProfileDto userProfileDto;

    public UserResponse() {
    }

    public UserResponse(Long id, String username, String email, UserProfileDto userProfileDto) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.userProfileDto = userProfileDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserProfileDto getUserProfileDto() {
        return userProfileDto;
    }

    public void setUserProfileDto(UserProfileDto userProfileDto) {
        this.userProfileDto = userProfileDto;
    }
}
