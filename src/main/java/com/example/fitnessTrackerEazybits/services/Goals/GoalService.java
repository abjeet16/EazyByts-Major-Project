package com.example.fitnessTrackerEazybits.services.Goals;

import com.example.fitnessTrackerEazybits.dto.GoalDto;

import java.util.List;

public interface GoalService {
    public GoalDto postGoal(GoalDto goalDto);

    public List<GoalDto> getGoals();

    public GoalDto updateGoalStatus(Long id);
}
