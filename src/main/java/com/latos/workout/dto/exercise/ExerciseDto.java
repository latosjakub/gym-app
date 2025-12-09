package com.latos.workout.dto.exercise;

public class ExerciseDto {


    private String name;

    public ExerciseDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
