package com.latos.workout.service;

import com.latos.workout.dto.AddExercisesToTrainingRequest;
import com.latos.workout.dto.TrainingExerciseItemRequest;
import com.latos.workout.model.Exercise;
import com.latos.workout.model.Training;
import com.latos.workout.model.TrainingExercise;
import com.latos.workout.model.User;
import com.latos.workout.repository.ExerciseRepository;
import com.latos.workout.repository.TrainigRepository;
import com.latos.workout.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TrainingService {
    private final TrainigRepository trainigRepository;
    private final UserRepository userRepository;

    private final ExerciseRepository exerciseRepository;


    public TrainingService(TrainigRepository trainigRepository, UserRepository userRepository, ExerciseRepository exerciseRepository) {
        this.trainigRepository = trainigRepository;
        this.userRepository = userRepository;
        this.exerciseRepository = exerciseRepository;
    }

    public Training addTraining(Long userId, Training training) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("User not found"));

        Training newTraining = new Training(
                training.getName(),
                LocalDate.now()
        );

        user.addTraining(newTraining);
        return trainigRepository.save(newTraining);
    }

    public List<Training> getTrainings(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("User not found"));

        return user.getTrainings();
    }

    public void deleteTraining(Long trainingId) {
        trainigRepository.deleteById(trainingId);
    }

    public Training addExerciseToTraining(Long trainingId, AddExercisesToTrainingRequest request){
        Training training = trainigRepository.findById(trainingId).orElseThrow(()->new RuntimeException("Training not found"));

        if(request==null){
            return training;
        }

        for(TrainingExerciseItemRequest item : request.getExercises()){

            Exercise exercise = exerciseRepository.findById(item.getExerciseId()).orElseThrow(()-> new RuntimeException("Exercise not found"));

            TrainingExercise te = new TrainingExercise(
                    item.getSets(),
                    item.getReps(),
                    item.getWeight()
            );

            te.setExercise(exercise);
            te.setTraining(training);

            training.getTrainingExercises().add(te);

        }

        return trainigRepository.save(training);

    }
}
