package com.latos.workout.dto.exercise;

import com.latos.workout.dto.training.TrainingExerciseItemRequest;

import java.util.List;

public class AddExercisesToTrainingRequest {

    private List<TrainingExerciseItemRequest> exercises;

    public AddExercisesToTrainingRequest() {
    }

    public List<TrainingExerciseItemRequest> getExercises() {
        return exercises;
    }

    public void setExercises(List<TrainingExerciseItemRequest> exercises) {
        this.exercises = exercises;
    }
}
