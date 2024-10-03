package com.example.fitnessTrackerEazybits.dto;

import lombok.Data;

import java.util.Date;

@Data
public class GoalDto {
    private Long id;

    private String Description;

    private Date startDate;

    private Date endDate;

    private boolean achieved = false;
}
