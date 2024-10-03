package com.example.fitnessTrackerEazybits.services.workout;

import com.example.fitnessTrackerEazybits.dto.WorkoutDto;
import com.example.fitnessTrackerEazybits.entity.Activity;
import com.example.fitnessTrackerEazybits.entity.Workout;
import com.example.fitnessTrackerEazybits.repository.WorkoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkoutServiceImp implements WorkoutService {

    private final WorkoutRepository workoutRepository;

    @Override
    public WorkoutDto postWorkout(WorkoutDto dto) {
        Workout workout = new Workout();
        workout.setDate(dto.getDate());
        workout.setType(dto.getType());
        workout.setDuration(dto.getDuration());
        workout.setCaloriesBurned(dto.getCaloriesBurned());

        return workoutRepository.save(workout).getWorkoutDto();
    }

    @Override
    public List<WorkoutDto> getWorkouts() {
        List<Workout> workouts = workoutRepository.findAll();
        return workouts.stream().map(Workout::getWorkoutDto).collect(Collectors.toList());
    }
}
