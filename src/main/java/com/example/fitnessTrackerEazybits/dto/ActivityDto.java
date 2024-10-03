package com.example.fitnessTrackerEazybits.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ActivityDto {
    private Long id;

    private Date date;

    private int steps;

    private Double distance;

    private int caloriesBurned;
}
