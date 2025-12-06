package com.latos.workout.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "exercise")
    private List<TrainingExercise> trainingExercises = new ArrayList<>();

    public List<TrainingExercise> getTrainingExercises() {
        return trainingExercises;
    }

    public void setTrainingExercises(List<TrainingExercise> trainingExercises) {
        this.trainingExercises = trainingExercises;
    }

    public Exercise() {
    }

    public Exercise(Long id, String name, Set<Training> trainings) {
        this.id = id;
        this.name = name;

    }

    public Exercise(String name){
        this.name = name;
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
