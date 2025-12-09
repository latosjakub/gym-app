package com.latos.workout.service;

import com.latos.workout.dto.exercise.ExerciseDto;
import com.latos.workout.dto.exercise.ResponseExerciseDto;
import com.latos.workout.model.Exercise;
import com.latos.workout.repository.ExerciseRepository;
import org.springframework.stereotype.Service;


@Service
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }


    public ResponseExerciseDto addExercise(ExerciseDto exercise) {
        Exercise newExercise = new Exercise();
        newExercise.setName(exercise.getName());
        return toDto(exerciseRepository.save(newExercise));

    }


    private ResponseExerciseDto toDto(Exercise exercise){
        return new ResponseExerciseDto(
                exercise.getId(),
                exercise.getName()
        );
    }
}
