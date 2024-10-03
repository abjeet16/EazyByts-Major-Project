package com.example.fitnessTrackerEazybits.entity;

import com.example.fitnessTrackerEazybits.dto.GoalDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private Date startDate;

    private Date endDate;

    private boolean achieved = false;

    public GoalDto getGoalDto(){
        GoalDto goalDto = new GoalDto();
        goalDto.setDescription(description);
        goalDto.setAchieved(achieved);
        goalDto.setStartDate(startDate);
        goalDto.setId(id);
        goalDto.setEndDate(endDate);
        return goalDto;
    }

}
