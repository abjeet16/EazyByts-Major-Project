package com.example.fitnessTrackerEazybits.services.Goals;

import com.example.fitnessTrackerEazybits.dto.GoalDto;
import com.example.fitnessTrackerEazybits.entity.Goal;
import com.example.fitnessTrackerEazybits.entity.Workout;
import com.example.fitnessTrackerEazybits.repository.GoalRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GoalServiceImp implements GoalService {

    private final GoalRepository goalRepository;
    @Override
    public GoalDto postGoal(@RequestBody GoalDto goalDto) {
        Goal goal = new Goal();
        goal.setDescription(goalDto.getDescription());
        goal.setStartDate(goalDto.getStartDate());
        goal.setEndDate(goalDto.getEndDate());

        return goalRepository.save(goal).getGoalDto();
    }

    @Override
    public List<GoalDto> getGoals() {
        List<Goal> goals = goalRepository.findAll();

        return goals.stream().map(Goal::getGoalDto).collect(Collectors.toList());
    }

    @Override
    public GoalDto updateGoalStatus(Long id) {
        Optional<Goal> optionalGoal = goalRepository.findById(id);
        if (optionalGoal.isPresent()){
            Goal existingGoal = optionalGoal.get();

            existingGoal.setAchieved(true);
            return goalRepository.save(existingGoal).getGoalDto();
        }throw new EntityNotFoundException("no goal by this id");
    }
}
