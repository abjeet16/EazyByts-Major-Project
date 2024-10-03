package com.example.fitnessTrackerEazybits.repository;

import com.example.fitnessTrackerEazybits.entity.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout,Long> {

    @Query("SELECT SUM(w.duration) FROM Workout w")
    Integer getTotalWorkoutDuration();

    @Query("SELECT SUM(w.caloriesBurned) FROM Workout w")
    Integer getTotalCaloriesBurned();
}
