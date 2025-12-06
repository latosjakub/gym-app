package com.latos.workout.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "training", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TrainingExercise> trainingExercises = new ArrayList<>();

    public User getUser() {
        return user;
    }

    public List<TrainingExercise> getTrainingExercises() {
        return trainingExercises;
    }

    public void setTrainingExercises(List<TrainingExercise> trainingExercises) {
        this.trainingExercises = trainingExercises;
    }

    public void addExercise(Exercise exercise, int sets, int reps, double weight){
        TrainingExercise te = new TrainingExercise(sets,reps,weight);
        te.setTraining(this);
        te.setExercise(exercise);
    }

    public void removeTrainingExercise(TrainingExercise trainingExercise){
        trainingExercises.remove(trainingExercise);
        trainingExercise.setTraining(null);
        trainingExercise.setExercise(null);
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Training() {
    }

    public Training(Long id, String name, LocalDate date, User user) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.user = user;
    }

    public Training(String name, LocalDate date) {
        this.name = name;
        this.date = date;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
