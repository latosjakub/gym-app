package com.latos.workout.model;

import jakarta.persistence.*;

@Entity
@Table(name = "training_exercises")
public class TrainingExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer sets;
    private Integer reps;
    private Double weight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "training_id")
    private Training training;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    public TrainingExercise() {
    }

    public TrainingExercise(Long id, Integer sets, Integer reps, Double weight, Training training, Exercise exercise) {
        this.id = id;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
        this.training = training;
        this.exercise = exercise;
    }

    public TrainingExercise(int sets, int reps, double weight) {
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSets() {
        return sets;
    }

    public void setSets(Integer sets) {
        this.sets = sets;
    }

    public Integer getReps() {
        return reps;
    }

    public void setReps(Integer reps) {
        this.reps = reps;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
}
