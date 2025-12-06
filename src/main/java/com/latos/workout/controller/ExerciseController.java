package com.latos.workout.controller;

import com.latos.workout.dto.ExerciseDto;
import com.latos.workout.dto.ResponseExerciseDto;
import com.latos.workout.model.Exercise;
import com.latos.workout.model.Training;
import com.latos.workout.service.ExerciseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {


    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }


    @PostMapping
    public ResponseEntity<ResponseExerciseDto> addExercise(@RequestBody ExerciseDto exerciseDto){
        ResponseExerciseDto response = exerciseService.addExercise(exerciseDto);
        return ResponseEntity.ok(response);
    }



}
