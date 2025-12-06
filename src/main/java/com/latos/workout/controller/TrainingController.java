package com.latos.workout.controller;

import com.latos.workout.dto.AddExercisesToTrainingRequest;
import com.latos.workout.model.Training;
import com.latos.workout.service.TrainingService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}/training")
public class TrainingController {

    private final TrainingService trainingService;

    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @PostMapping
    public ResponseEntity<Training> createTraining(
            @PathVariable Long userId,
            @RequestBody Training training){
        Training training1 = trainingService.addTraining(userId, training);
        return ResponseEntity.ok(training1);
    }

    @GetMapping
    public ResponseEntity<List<Training>> getTrainings(@PathVariable Long userId){
        List<Training> trainings = trainingService.getTrainings(userId);
        return  ResponseEntity.ok(trainings);
    }

    @DeleteMapping("/{trainingId}")
    public ResponseEntity<Void> deleteTaining(
            @PathVariable Long userId,
            @PathVariable Long trainingId
    ){
        trainingService.deleteTraining(trainingId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{trainingId}/exercises")
    public ResponseEntity<Training> addExerciseToTaining(
            @PathVariable Long trainingId,
            @RequestBody AddExercisesToTrainingRequest addExercises
    ){
        Training update = trainingService.addExerciseToTraining(trainingId, addExercises);
        return ResponseEntity.ok(update);
    }
}
