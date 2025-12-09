package com.latos.workout.dto.exercise;

public class ResponseExerciseDto {

    private Long id;
    private String name;

    public ResponseExerciseDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ResponseExerciseDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
