package com.example.fitnessTrackerEazybits.services.workout;

import com.example.fitnessTrackerEazybits.dto.ActivityDto;
import com.example.fitnessTrackerEazybits.dto.WorkoutDto;
import com.example.fitnessTrackerEazybits.repository.WorkoutRepository;

import java.util.List;

public interface WorkoutService {
    public WorkoutDto postWorkout(WorkoutDto dto);
    public List<WorkoutDto> getWorkouts();
}
