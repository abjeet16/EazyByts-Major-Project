package com.example.fitnessTrackerEazybits.services.activity;

import com.example.fitnessTrackerEazybits.dto.ActivityDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ActivityService {
    public ActivityDto postActivity(ActivityDto dto);
    public List<ActivityDto> getActivities();
}
