package com.example.fitnessTrackerEazybits.services.Stats;

import com.example.fitnessTrackerEazybits.dto.StatsDto;
import com.example.fitnessTrackerEazybits.repository.ActivityRepository;
import com.example.fitnessTrackerEazybits.repository.GoalRepository;
import com.example.fitnessTrackerEazybits.repository.WorkoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatsServiceImp implements StatsService{

    private final GoalRepository goalRepository;

    private final ActivityRepository activityRepository;

    private final WorkoutRepository workoutRepository;

    @Override
    public StatsDto getStats(){
        Long achievedGoals = goalRepository.countAchievedGoals();
        Long notAchievedGoals = goalRepository.countNotAchievedGoals();

        Integer totalSteps = activityRepository.getTotalSteps();
        Double totalDistance = activityRepository.getTotalDistance();
        Integer totalActivityCaloriesBurned = activityRepository.getTotalCaloriesBurned();

        Integer totalWorkoutDuration = workoutRepository.getTotalWorkoutDuration();
        Integer totalWorkoutCaloriesBurned = workoutRepository.getTotalCaloriesBurned();

        int totalCaloriesBurned = (totalActivityCaloriesBurned !=null ? totalActivityCaloriesBurned : 0) +
                (totalWorkoutCaloriesBurned != null ? totalWorkoutCaloriesBurned : 0);

        StatsDto dto = new StatsDto();
        dto.setAchievedGoals(achievedGoals!=null ? achievedGoals : 0);
        dto.setNotAchievedGoals(notAchievedGoals!=null ? notAchievedGoals : 0);

        dto.setSteps(totalSteps!=null?totalSteps:0);
        dto.setDistance(totalDistance!=null?totalDistance:0.0);
        dto.setTotalCaloriesBurned(totalCaloriesBurned);

        dto.setDuration(totalWorkoutDuration != null ? totalWorkoutDuration : 0);

        return dto;
    }
}
