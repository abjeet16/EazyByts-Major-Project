package com.example.fitnessTrackerEazybits.services.activity;

import com.example.fitnessTrackerEazybits.dto.ActivityDto;
import com.example.fitnessTrackerEazybits.entity.Activity;
import com.example.fitnessTrackerEazybits.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.slf4j.Activator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class activityServiceImp implements ActivityService{

    private final ActivityRepository activityRepository;

    @Override
    public ActivityDto postActivity(ActivityDto dto){
        Activity activity = new Activity();

        activity.setDate(dto.getDate());
        activity.setSteps(dto.getSteps());
        activity.setDistance(dto.getDistance());
        activity.setCaloriesBurned(dto.getCaloriesBurned());

        return activityRepository.save(activity).getActivityDto();
    }

    @Override
    public List<ActivityDto> getActivities() {
        List<Activity> activities = activityRepository.findAll();
        return activities.stream().map(Activity::getActivityDto).collect(Collectors.toList());
    }
}
