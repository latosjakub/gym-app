package com.latos.workout.repository;

import com.latos.workout.model.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainigRepository extends JpaRepository<Training, Long> {
}
