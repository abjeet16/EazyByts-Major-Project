package com.example.fitnessTrackerEazybits.entity;

import com.example.fitnessTrackerEazybits.dto.WorkoutDto;
import com.fasterxml.jackson.databind.DatabindException;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private Date date;

    private int duration;

    private int caloriesBurned;

    public WorkoutDto getWorkoutDto(){
        WorkoutDto workoutDto = new WorkoutDto();
        workoutDto.setId(id);
        workoutDto.setDate(date);
        workoutDto.setType(type);
        workoutDto.setDuration(duration);
        workoutDto.setCaloriesBurned(caloriesBurned);

        return workoutDto;
    }
}
