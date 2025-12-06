package com.latos.workout.dto;

import java.util.ArrayList;
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
